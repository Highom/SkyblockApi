/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.model.PlayerData;
import ch.bbw.yr.model.timers.TimerCollection;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ApiController {

    @CrossOrigin
    @GetMapping("/player")
    public PlayerData getAllPlayerData(@RequestParam(name= "username", required = true) String username){
        return new PlayerData(username);
    }

    @CrossOrigin
    @GetMapping("/timers")
    public TimerCollection getAllTimers(){
        return new TimerCollection();
    }
}
