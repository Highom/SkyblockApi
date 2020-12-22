/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.model.PlayerData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zone.nora.slothpixel.Slothpixel;
import zone.nora.slothpixel.player.Player;
import zone.nora.slothpixel.player.status.PlayerStatus;
import zone.nora.slothpixel.skyblock.players.SkyblockPlayer;
import zone.nora.slothpixel.skyblock.profiles.SkyblockProfile;

import java.util.HashMap;

@Controller
@RequestMapping("/api")
public class ApiController {
    Slothpixel slothpixel = new Slothpixel();

    @GetMapping
    public PlayerData getAllPlayerData(@RequestParam(name= "username", required = true) String username){
        Player player = slothpixel.getPlayer(username);
        PlayerStatus playerStatus = slothpixel.getPlayerStatus(username);
        SkyblockProfile skyblockProfile = slothpixel.getSkyblockProfile(username);
        SkyblockPlayer skyblockPlayer = skyblockProfile.getMembers().get(player.getUuid());

        PlayerData playerData = new PlayerData(player.getKarma(),
                playerStatus,
                skyblockPlayer.getCoinPurse(),
                skyblockPlayer.getStats().getTotalDeaths(),
                skyblockPlayer.getStats().getTotalKills());

        System.out.println(playerData.toString());
        return playerData;
    }
}
