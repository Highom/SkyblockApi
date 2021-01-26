import React, { useEffect, useState } from "react";
import Axios from "axios";
import { TimerCollection } from "./TimerCollectionInterfaces";
import TimerCollectionView from "./TimerCollectionView";

const TimerCollectionContainer: React.FC = () => {
    const [timerCollection,setTimerData] = useState<TimerCollection | undefined>();
    const api = "http://localhost:8080";
    
    useEffect(() => {
        Axios.get<TimerCollection>(`${api}/timers`).then(( res => {
             setTimerData(res.data);
            }))
            .catch( err => {console.log(err)});
    }, []);

    return (
        <TimerCollectionView timerCollection={timerCollection}/>
    );
};

export default TimerCollectionContainer;