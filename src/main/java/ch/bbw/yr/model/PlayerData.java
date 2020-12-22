/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.model;

import zone.nora.slothpixel.player.status.PlayerStatus;

public class PlayerData {
    //Standard stats
    private int karma;
    private PlayerStatus playerStatus;

    //Skyblock stats
    private double coinPurse;
    private int totalDeaths;
    private int totalKills;

    public PlayerData(int karma, PlayerStatus playerStatus, double coinPurse, int totalDeaths, int totalKills) {
        this.karma = karma;
        this.playerStatus = playerStatus;
        this.coinPurse = coinPurse;
        this.totalDeaths = totalDeaths;
        this.totalKills = totalKills;
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
