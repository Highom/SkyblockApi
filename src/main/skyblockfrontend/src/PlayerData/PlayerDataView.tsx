/* eslint-disable react/prop-types */
import { Box, Typography } from "@material-ui/core";
import { format, toDate } from "date-fns";
import React from "react";
import { PlayerData } from "./PlayerDataInterfaces";

export interface PlayerDataViewProps{
    playerData: PlayerData;
    isLoading: boolean;
    username: string | null;
}

const PlayerDataView: React.FC<PlayerDataViewProps> = ({ playerData, isLoading ,username }) => {

    if(isLoading){
        return <Typography variant="h5">Getting the PlayerData for you</Typography>;
    }

    let PlayerStatus;
    if (playerData.playerStatus.online) {
        PlayerStatus = (
            <>
                <Typography> {username} is Online</Typography>
                <Typography>Map: {playerData.playerStatus.game.map}</Typography>
                <Typography>Gamemode: {playerData.playerStatus.game.mode}</Typography>
                <Typography>Type: {playerData.playerStatus.game.type}</Typography>
            </>
        )
    }else{
        PlayerStatus = (
            <>
                <Typography> {username} is Offline</Typography>
                <Typography>Last Game: {playerData.lastGame}</Typography>
                <Typography>Last Online: {format(toDate(playerData.lastLogout), "kk:mm dd/MM/yyyy")}</Typography>
            </>
        )
    }

    return (
        <>
        <Box paddingBottom={1}>
            <Typography variant="h5">{username}&apos;s Global stats</Typography>
            <Typography>Karma: {playerData.karma}</Typography>
        </Box>
        <Box paddingBottom={1}>
            <Typography variant="h5">{username}&apos;s Current Status</Typography>
            {PlayerStatus}
        </Box>
        <Box paddingBottom={1}>
            <Typography variant="h5">{username}&apos;s Skyblock stats</Typography>
            <Typography>Coin Purse: {playerData.coinPurse}</Typography>
            <Typography>Total Deaths: {playerData.totalDeaths}</Typography>
            <Typography>Total Kills: {playerData.totalKills}</Typography>
        </Box>
        </>
    );
};

export default PlayerDataView;