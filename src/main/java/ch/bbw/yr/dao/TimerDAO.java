/**
 * @Author: Yannick Ruck
 * @Date: 29/12/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.db.entities.ApiRequest;
import ch.bbw.yr.db.repositories.ApiRequestRepository;
import ch.bbw.yr.model.timers.EventTimer;
import ch.bbw.yr.model.timers.GenericTimer;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

public class TimerDAO {

    public GenericTimer getGenericTimer(String timerName) {
        GenericTimer genericTimer = null;
        try {
            String url = String.format("https://hypixel-api.inventivetalent.org/api/skyblock/%s/estimate", timerName);
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                genericTimer = gson.fromJson(reader, GenericTimer.class);

                ApiRequestRepository apiRequestRepository = new ApiRequestRepository();
                apiRequestRepository.createApiRequest(new ApiRequest(url,genericTimer.toString()));
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genericTimer;
    }

    public EventTimer getEventTimer(String timerName) {
        EventTimer eventTimer = null;
        try {
            String url = String.format("https://hypixel-api.inventivetalent.org/api/skyblock/%s/estimate", timerName);
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                eventTimer = gson.fromJson(reader, EventTimer.class);

                ApiRequestRepository apiRequestRepository = new ApiRequestRepository();
                apiRequestRepository.createApiRequest(new ApiRequest(url,eventTimer.toString()));
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventTimer;
    }
}