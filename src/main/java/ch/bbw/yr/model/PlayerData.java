/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.model;

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
        Slothpixel slothpixel = new Slothpixel();
        Player player = slothpixel.getPlayer(username);
        String playerUuid = player.getUuid();
        PlayerStatus playerStatus = slothpixel.getPlayerStatus(playerUuid);
        SkyblockProfile skyblockProfile = slothpixel.getSkyblockProfile(playerUuid);
        SkyblockPlayer skyblockPlayer = skyblockProfile.getMembers().get(playerUuid);

        karma = player.getKarma();
        lastLogout = player.getLastLogout();
        lastGame = player.getLastGame();
        this.playerStatus = playerStatus;
        coinPurse = skyblockPlayer.getCoinPurse();
        totalDeaths = skyblockPlayer.getStats().getTotalDeaths();
        totalKills = skyblockPlayer.getStats().getTotalKills();
        uuid = playerUuid;
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
