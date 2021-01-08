/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.model;

import ch.bbw.yr.dao.MojangDAO;
import ch.bbw.yr.model.mojang.UserProfile;
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

    //Skyblock stats
    private double coinPurse;
    private int totalDeaths;
    private int totalKills;

    //Mojang
    private String uuid;

    public PlayerData(String username) {
        Slothpixel slothpixel = new Slothpixel();
        Player player = slothpixel.getPlayer(username);
        PlayerStatus playerStatus = slothpixel.getPlayerStatus(username);
        SkyblockProfile skyblockProfile = slothpixel.getSkyblockProfile(username);
        SkyblockPlayer skyblockPlayer = skyblockProfile.getMembers().get(player.getUuid());

        MojangDAO mojangDAO = new MojangDAO();
        UserProfile userProfile = mojangDAO.getUserProfile(username);

        karma = player.getKarma();
        lastLogout = player.getLastLogout();
        lastGame = player.getLastGame();
        this.playerStatus = playerStatus;
        coinPurse = skyblockPlayer.getCoinPurse();
        totalDeaths = skyblockPlayer.getStats().getTotalDeaths();
        totalKills = skyblockPlayer.getStats().getTotalKills();
        uuid = userProfile.getId();
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

    @Override
    public String toString() {
        return "PlayerData{" +
                "karma=" + karma +
                ", lastLogout=" + lastLogout +
                ", lastGame='" + lastGame + '\'' +
                ", playerStatus=" + playerStatus +
                ", coinPurse=" + coinPurse +
                ", totalDeaths=" + totalDeaths +
                ", totalKills=" + totalKills +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
