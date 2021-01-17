/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.model;

import ch.bbw.yr.db.entities.ApiRequest;
import ch.bbw.yr.db.entities.User;
import ch.bbw.yr.db.repositories.ApiRequestRepository;
import ch.bbw.yr.db.repositories.UserRepository;
import com.google.gson.Gson;
import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.player.Player;
import zone.nora.slothpixel.player.status.PlayerStatus;
import zone.nora.slothpixel.skyblock.players.SkyblockPlayer;
import zone.nora.slothpixel.skyblock.profiles.SkyblockProfile;

public class PlayerData {
    //Standard stats
    private int karma;
    private long lastLogout;
    private String lastGame;
    private PlayerStatus playerStatus;
    private String uuid;

    //Skyblock stats
    private double coinPurse;
    private int totalDeaths;
    private int totalKills;

    public PlayerData(String username) {
        ApiRequestRepository apiRequestRepository = new ApiRequestRepository();
        Slothpixel slothpixel = new Slothpixel();
        Player player = slothpixel.getPlayer(username);
        Gson gson = new Gson();
        apiRequestRepository.createApiRequest(new ApiRequest(String.format("https://api.slothpixel.me/api/players/%s",username), gson.toJson(player)));
        String playerUuid = player.getUuid();
        SkyblockProfile skyblockProfile = slothpixel.getSkyblockProfile(playerUuid);
        apiRequestRepository.createApiRequest(new ApiRequest(String.format("https://api.slothpixel.me/api/skyblock/profile/%s",username), gson.toJson(skyblockProfile)));
        SkyblockPlayer skyblockPlayer = skyblockProfile.getMembers().get(playerUuid);

        karma = player.getKarma();
        lastLogout = player.getLastLogout();
        lastGame = player.getLastGame();
        coinPurse = skyblockPlayer.getCoinPurse();
        totalDeaths = skyblockPlayer.getStats().getTotalDeaths();
        totalKills = skyblockPlayer.getStats().getTotalKills();
        uuid = playerUuid;

        //the UserStatus only seems to work if you change the capitalisation every time so we change it after every call.
        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserByName(username);
        if (user == null){
          userRepository.createUser(new User(username,true));
          user = userRepository.getUserByName(username);
        }
        String newUsername;
        if(user.isCapital()){
          newUsername =  username.substring(0,1).toUpperCase() + username.substring(1);
          user.setCapital(false);
        }else {
            newUsername = username.substring(0,1).toLowerCase() + username.substring(1);
            user.setCapital(true);
        }
        userRepository.updateUser(user);
        PlayerStatus playerStatus = slothpixel.getPlayerStatus(newUsername);
        apiRequestRepository.createApiRequest(new ApiRequest(String.format("https://api.slothpixel.me/api/players/%s/status", newUsername), gson.toJson(playerStatus)));
        this.playerStatus = playerStatus;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public long getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(long lastLogout) {
        this.lastLogout = lastLogout;
    }

    public String getLastGame() {
        return lastGame;
    }

    public void setLastGame(String lastGame) {
        this.lastGame = lastGame;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public double getCoinPurse() {
        return coinPurse;
    }

    public void setCoinPurse(double coinPurse) {
        this.coinPurse = coinPurse;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
