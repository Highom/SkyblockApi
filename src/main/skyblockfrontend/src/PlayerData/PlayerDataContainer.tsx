import React, { useEffect, useState } from "react";
import PlayerDataView from "./PlayerDataView";
import Axios from "axios";
import { PlayerData } from "./PlayerDataInterfaces";
import { Typography } from "@material-ui/core";


    //Set these from NameDialog
    // setUsername(username);
    // localStorage.setItem("username", username)
    

const PlayerDataContainer: React.FC = () => {
    const [playerData,setPlayerData] = useState<PlayerData | undefined>();
    const [username,setUsername] = useState(localStorage.getItem('username'));
    const api = "http://localhost:8080";

    useEffect(() => {
        if (username !== undefined) {
            Axios.get<PlayerData>(`${api}/player?username=${username}`).then(( res => {
                 setPlayerData(res.data);
                })).catch( err => {console.log(err)});            
        }
    }, []);

    if (username === null) {
        return <Typography variant="h5">No name specified</Typography>
    }

    return (
        <PlayerDataView playerData={playerData} username={username}/>
    );
};

export default PlayerDataContainer;