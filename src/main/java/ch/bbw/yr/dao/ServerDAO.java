/**
 * @Author: Yannick Ruck
 * @Date: 15/01/2021
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.db.entities.ApiRequest;
import ch.bbw.yr.db.repositories.ApiRequestRepository;
import ch.bbw.yr.model.server.ServerInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerDAO {

    public ServerInfo getServerInfo() {
        ServerInfo serverInfo = null;
        try {
            String url = "https://eu.mc-api.net/v3/server/ping/mc.hypixel.net";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                serverInfo = gson.fromJson(reader, ServerInfo.class);

                ApiRequestRepository apiRequestRepository = new ApiRequestRepository();
                apiRequestRepository.createApiRequest(new ApiRequest(url,serverInfo.toString()));
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverInfo;
    }
}
