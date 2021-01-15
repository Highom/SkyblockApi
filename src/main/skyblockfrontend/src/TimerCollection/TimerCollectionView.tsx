/* eslint-disable react/prop-types */
import React from "react";
import { TimerCollection } from "./TimerCollectionInterfaces";
import { formatDuration, intervalToDuration, toDate } from 'date-fns'
import { Box, Typography } from "@material-ui/core";
import CountdownView from "./CountdownView";

export interface TimerCollectionViewProps{
    timerCollection: TimerCollection;
    isLoading: boolean;
}

const TimerCollectionView: React.FC<TimerCollectionViewProps> = ({ timerCollection, isLoading }) => {

    if(isLoading){
        return <Typography variant="h5">Getting the TimerCollection for you</Typography>;
    }

    return (
        <Box>
            <Typography variant="h5">Timers</Typography>
            <Typography>Bank Interest is {timerCollection.bankInterest.estimateRelative}</Typography>
            <CountdownView event={toDate(timerCollection.bankInterest.estimate)}/>
            <Typography>Dark Auction is {timerCollection.darkAuction.estimateRelative}</Typography>
            <CountdownView event={toDate(timerCollection.darkAuction.estimate)}/>
            <Typography>New Year event is {timerCollection.newYear.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.newYear.estimate, end: timerCollection.newYear.endEstimate}))}</Typography>
            <CountdownView event={toDate(timerCollection.newYear.estimate)}/>
            <Typography>Spooky festival is {timerCollection.spookyFestival.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.spookyFestival.estimate, end: timerCollection.spookyFestival.endEstimate}))}</Typography>
            <CountdownView event={toDate(timerCollection.spookyFestival.estimate)}/>
            <Typography>Winter Event is {timerCollection.winterEvent.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.winterEvent.estimate, end: timerCollection.winterEvent.endEstimate}))}</Typography>
            <CountdownView event={toDate(timerCollection.winterEvent.estimate)}/>
        </Box>
    );
};

export default TimerCollectionView;