/**
 * @Author: Yannick Ruck
 * @Date: 22/12/2020
 */
package ch.bbw.yr.controller;

import ch.bbw.yr.dao.ServerDAO;
import ch.bbw.yr.db.entities.ApiRequest;
import ch.bbw.yr.db.repositories.ApiRequestRepository;
import ch.bbw.yr.model.PlayerData;
import ch.bbw.yr.model.server.ServerInfo;
import ch.bbw.yr.model.timers.TimerCollection;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @CrossOrigin
    @GetMapping("/server")
    public ServerInfo getServerInfo(){
        ServerDAO serverDAO = new ServerDAO();
        return serverDAO.getServerInfo();
    }

    @CrossOrigin
    @GetMapping("/history")
    public List<ApiRequest> getHistory(){
        ApiRequestRepository apiRequestRepository = new ApiRequestRepository();
        return apiRequestRepository.getAllApiRequests();
    }
}
