/**
 * @Author: Yannick Ruck
 * @Date: 29/12/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.timers.EventTimer;
import ch.bbw.yr.model.timers.GenericTimer;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TimerDAO {

    public GenericTimer getGenericTimer(String timerName) {
        GenericTimer genericTimer = null;
        try {
            StringBuilder url = new StringBuilder(String.format("https://hypixel-api.inventivetalent.org/api/skyblock/%s/estimate", timerName));
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                genericTimer = gson.fromJson(reader, GenericTimer.class);
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
            StringBuilder url = new StringBuilder(String.format("https://hypixel-api.inventivetalent.org/api/skyblock/%s/estimate", timerName));
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            conn.setRequestProperty("User-Agent", "SkyblockApi 1.0.0");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                eventTimer = gson.fromJson(reader, EventTimer.class);
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventTimer;
    }
}