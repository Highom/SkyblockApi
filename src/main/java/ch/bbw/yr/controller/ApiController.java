/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.model.PlayerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApiController {

    @GetMapping("/player")
    public PlayerData getAllPlayerData(@RequestParam(name= "username", required = true) String username){
        return new PlayerData(username);
    }

    }
}
