/**
 * @Author: Yannick Ruck
 * @Date: 15/01/2021
 */
package ch.bbw.yr.model.server;

public class ServerInfo {
    private boolean online;
    private Version version;
    private Players players;
    private  String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
