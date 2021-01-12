/* eslint-disable react/prop-types */
import React from "react";
import { TimerCollection } from "./TimerCollectionInterfaces";
import { formatDuration, intervalToDuration } from 'date-fns'
import { Box, Typography } from "@material-ui/core";

export interface TimerCollectionViewProps{
    timerCollection: TimerCollection;
    isLoading: boolean;
}

const PlayerDataView: React.FC<TimerCollectionViewProps> = ({ timerCollection, isLoading }) => {

    if(isLoading){
        return <Typography variant="h5">Getting the TimerCollection for you</Typography>;
    }

    return (
        <Box>
            <Typography variant="h5">Timers</Typography>
            <Typography>Bank Interest is {timerCollection.bankInterest.estimateRelative}</Typography>
            <Typography>Dark Auction is {timerCollection.darkAuction.estimateRelative}</Typography>
            <Typography>New Year event is {timerCollection.newYear.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.newYear.estimate, end: timerCollection.newYear.endEstimate}))}</Typography>
            <Typography>Spooky festival is {timerCollection.spookyFestival.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.spookyFestival.estimate, end: timerCollection.spookyFestival.endEstimate}))}</Typography>
            <Typography>Winter Event is {timerCollection.winterEvent.estimateRelative} and lasts for {formatDuration(intervalToDuration({start: timerCollection.winterEvent.estimate, end: timerCollection.winterEvent.endEstimate}))}</Typography>
        </Box>
    );
};

export default PlayerDataView;