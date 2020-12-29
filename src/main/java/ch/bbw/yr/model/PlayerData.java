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
    private PlayerStatus playerStatus;

    //Skyblock stats
    private double coinPurse;
    private int totalDeaths;
    private int totalKills;

    public PlayerData(String username) {
        Slothpixel slothpixel = new Slothpixel();
        Player player = slothpixel.getPlayer(username);
        PlayerStatus playerStatus = slothpixel.getPlayerStatus(username);
        SkyblockProfile skyblockProfile = slothpixel.getSkyblockProfile(username);
        SkyblockPlayer skyblockPlayer = skyblockProfile.getMembers().get(player.getUuid());

        karma = player.getKarma();
        this.playerStatus = playerStatus;
        coinPurse = skyblockPlayer.getCoinPurse();
         totalDeaths = skyblockPlayer.getStats().getTotalDeaths();
         totalKills = skyblockPlayer.getStats().getTotalKills();
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
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

    @Override
    public String toString() {
        return "PlayerData{" +
                "karma=" + karma +
                ", playerStatus=" + playerStatus +
                ", coinPurse=" + coinPurse +
                ", totalDeaths=" + totalDeaths +
                ", totalKills=" + totalKills +
                '}';
    }
}
