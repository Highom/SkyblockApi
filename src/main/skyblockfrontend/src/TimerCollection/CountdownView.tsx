/* eslint-disable react/prop-types */
import Typography from "@material-ui/core/Typography";
import { formatDuration, intervalToDuration } from "date-fns";
import React, { useEffect, useState } from "react";


export interface CountdownViewProps{ 
    event: Date;
}

const CountdownView: React.FC<CountdownViewProps> = ({ event}) => {
    const [countdown, setCountdown] = useState<string>();
    
    useEffect(() => {
        setInterval(() => setCountdown(formatDuration(intervalToDuration({ start: Date.now(),end: event}))), 1000);
    }, []);

    return (
            <Typography variant="caption">「{countdown}」</Typography>
    );
};

export default CountdownView;