/**
 * @Author: Yannick Ruck
 * @Date: 15/01/2021
 */
package ch.bbw.yr.model.server;

public class ServerInfo {
    private boolean online;
    private Version version;
    private Players players;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "online=" + online +
                ", version=" + version +
                ", players=" + players +
                '}';
    }
}
