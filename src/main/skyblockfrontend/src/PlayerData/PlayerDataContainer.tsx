import React, { useEffect, useState } from "react";
import PlayerDataView from "./PlayerDataView";
import Axios from "axios";
import { PlayerData } from "./PlayerDataInterfaces";
import { Typography } from "@material-ui/core";

let playerDataDefined: PlayerData;

const PlayerDataContainer: React.FC = () => {
    const [isLoading, setLoading] = useState(true);
    const [playerData,setPlayerData] = useState<PlayerData>();
    const username = localStorage.getItem('username');
    const api = "http://localhost:8080";

    useEffect(() => {
        if (username !== undefined) {
            Axios.get<PlayerData>(`${api}/player?username=${username}`).then(( res => {
                 setPlayerData(res.data);
                 setLoading(false);
                })).catch( err => {console.log(err)});            
        }
    }, []);

    if (username === null) {
        return <Typography variant="h5">No name specified</Typography>
    }

    if(playerData !== undefined)
    {
        playerDataDefined = playerData;
    }
    return (
        <PlayerDataView playerData={playerDataDefined} isLoading={isLoading} username={username}/>
    );
};

export default PlayerDataContainer;