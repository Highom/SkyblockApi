/* eslint-disable react/prop-types */
import React from "react";
import { TimerCollection } from "./TimerCollectionInterfaces";
import { formatDuration, intervalToDuration } from 'date-fns'
import { Typography } from "@material-ui/core";

export interface TimerCollectionViewProps{
    timerCollection: TimerCollection;
    isLoading: boolean;
}

const PlayerDataView: React.FC<TimerCollectionViewProps> = ({ timerCollection, isLoading }) => {

    if(isLoading){
        return <Typography variant="h5">Getting the TimerCollection for you</Typography>;
    }

    return (
        <>
            <Typography variant="h5">Timers</Typography>
            <p>Bank Interest is {timerCollection.bankInterest.estimateRelative}</p>
            <p>Dark Auction is {timerCollection.darkAuction.estimateRelative}</p>
            <p>New Year event is {timerCollection.newYear.estimateRelative} for {formatDuration(intervalToDuration({start: timerCollection.newYear.estimate, end: timerCollection.newYear.endEstimate}))}</p>
            <p>Spooky festival is {timerCollection.spookyFestival.estimateRelative}for {formatDuration(intervalToDuration({start: timerCollection.spookyFestival.estimate, end: timerCollection.spookyFestival.endEstimate}))}</p>
            <p>Winter Event is {timerCollection.winterEvent.estimateRelative} for {formatDuration(intervalToDuration({start: timerCollection.winterEvent.estimate, end: timerCollection.winterEvent.endEstimate}))}</p>
        </>
    );
};

export default PlayerDataView;