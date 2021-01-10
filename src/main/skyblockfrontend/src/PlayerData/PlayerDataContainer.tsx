import React, { useState } from "react";
import PlayerDataView from "./PlayerDataView";
import Axios from "axios";
import { PlayerData } from "./PlayerDataInterfaces";


let playerDataDefined: PlayerData;


const PlayerDataContainer: React.FC = () => {
    const [playerData,setPlayerData] = useState<PlayerData>();
    const username = localStorage.getItem('username');
    const api = "http://localhost:8080";

    Axios.get<PlayerData>(`${api}/player?username=${username}`).then(( res => { setPlayerData(res.data)})).catch( err => {console.log(err)});
    
    if(playerData !== undefined)
    {
        playerDataDefined = playerData;
    }
    return (
        <PlayerDataView playerData={playerDataDefined} username={username}/>
    );
};

export default PlayerDataContainer;