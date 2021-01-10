/* eslint-disable react/prop-types */
import React from "react";
import { TimerCollection } from "./TimerCollectionInterfaces";
import { intervalToDuration } from 'date-fns'

export interface TimerCollectionViewProps{
    timerCollection: TimerCollection;
}

const PlayerDataView: React.FC<TimerCollectionViewProps> = ({ timerCollection }) => {
    return (
        <>
            <p>Bank Interest is {timerCollection.bankInterest.estimateRelative}</p>
            <p>Dark Auction is {timerCollection.darkAuction.estimateRelative}</p>
            <p>New Year event is {timerCollection.newYear.estimateRelative} for {intervalToDuration({start: timerCollection.newYear.estimate, end: timerCollection.newYear.endEstimate})}</p>
            <p>Spooky festival is {timerCollection.spookyFestival.estimateRelative}</p>
            <p>Winter Event is {timerCollection.winterEvent.estimateRelative}</p>
        </>
    );
};

export default PlayerDataView;