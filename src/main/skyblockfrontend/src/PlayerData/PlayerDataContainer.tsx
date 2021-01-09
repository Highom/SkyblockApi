import React, { useEffect, useState } from "react";
import PlayerDataView from "./PlayerDataView";
import Axios from 'axios';


const [playerData,setPlayerData] = useState([]);

useEffect( () =>{
    Axios.get(`http://localhost:8080/player?username=${localStorage.getItem('name')}`)
    .then(res => { setPlayerData(res.data)})
    .catch( err => {console.log(err)});
}, [])

const PlayerDataContainer: React.FC = () => {
    return (
        //Currently not working. Need to figure out how to get the returned json into the PlayerData Interface. 
        <PlayerDataView playerData={playerData}/>
    );
};

export default PlayerDataContainer;