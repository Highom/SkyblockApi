import React, { useState } from "react";
import Axios from "axios";
import { TimerCollection } from "./TimerCollectionInterfaces";
import TimerCollectionView from "./TimerCollectionView.";


let timerCollectionDefined: TimerCollection;


const TimerCollectionContainer: React.FC = () => {
    const [timerCollection,setTimerData] = useState<TimerCollection>();
    const api = "http://localhost:8080";

    Axios.get<TimerCollection>(`${api}/timers`).then(( res => { setTimerData(res.data)})).catch( err => {console.log(err)});
    
    if(timerCollection !== undefined)
    {
        timerCollectionDefined = timerCollection;
    }
    return (
        <TimerCollectionView timerCollection={timerCollectionDefined}/>
    );
};

export default TimerCollectionContainer;