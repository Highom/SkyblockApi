/**
 * @Author: Yannick Ruck
 * @Date: 03/01/2021
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.mojang.UserProfile;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MojangDAO {
    public UserProfile getUserProfile(String username) {
        UserProfile userProfile = null;
        try {
            StringBuilder url = new StringBuilder(String.format("https://api.mojang.com/users/profiles/minecraft/%s", username));
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                userProfile = gson.fromJson(reader, UserProfile.class);
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userProfile;
    }
}
