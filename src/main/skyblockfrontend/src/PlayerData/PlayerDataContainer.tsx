import React, { useState } from "react";
import PlayerDataView from "./PlayerDataView";
import Axios from "axios";
import { PlayerData } from "./PlayerDataInterfaces";
import { waitFor } from "@testing-library/react";


let playerDataDefined: PlayerData;


const PlayerDataContainer: React.FC = () => {
    const [playerData,setPlayerData] = useState<PlayerData>();

    Axios.get<PlayerData>(`http://localhost:8080/player?username=${localStorage.getItem('username')}`).then(( res => { setPlayerData(res.data)})).catch( err => {console.log(err)});
    
    if(playerData !== undefined)
    {
        playerDataDefined = playerData;
    }
    return (
        <PlayerDataView playerData={playerDataDefined}/>
    );
};

export default PlayerDataContainer;