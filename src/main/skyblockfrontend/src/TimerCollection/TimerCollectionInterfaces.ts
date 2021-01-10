export interface TimerCollection{
    darkAuction :GenericTimer;
    bankInterest :GenericTimer;
    newYear :EventTimer;
    spookyFestival :EventTimer;
    winterEvent :EventTimer;
}

export interface GenericTimer{
    success: boolean;
    msg: string;
    type: string;
    queryTime: number;
    estimate: number;
    estimateRelative: string;
    num: number;
}

export interface EventTimer extends GenericTimer{
    endEstimate: number;
    endEstimateRelative: string;
    active: boolean;
}