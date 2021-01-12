import React, { useEffect, useState } from "react";
import Axios from "axios";
import { TimerCollection } from "./TimerCollectionInterfaces";
import TimerCollectionView from "./TimerCollectionView.";


let timerCollectionDefined: TimerCollection;


const TimerCollectionContainer: React.FC = () => {
    const [isLoading, setLoading] = useState(true);
    const [timerCollection,setTimerData] = useState<TimerCollection>();
    const api = "http://localhost:8080";
    
    useEffect(() => {
        Axios.get<TimerCollection>(`${api}/timers`).then(( res => {
             setTimerData(res.data);
             setLoading(false);
            }))
            .catch( err => {console.log(err)});
    }, []);

    if(timerCollection !== undefined)
    {
        timerCollectionDefined = timerCollection;
    }
    return (
        <TimerCollectionView timerCollection={timerCollectionDefined} isLoading={isLoading}/>
    );
};

export default TimerCollectionContainer;