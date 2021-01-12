/* eslint-disable react/prop-types */
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
        return <h1>Getting the PlayerData for you</h1>;
    }

    let PlayerStatus;
    if (playerData.playerStatus.online) {
        PlayerStatus = (
            <>
                <p> {username} is Online</p>
                <p>Map: {playerData.playerStatus.game.map}</p>
                <p>Gamemode: {playerData.playerStatus.game.mode}</p>
                <p>Type: {playerData.playerStatus.game.type}</p>
            </>
        )
    }else{
        PlayerStatus = (
            <>
                <p> {username} is Offline</p>
                <p>Last Game: {playerData.lastGame}</p>
                <p>Last Online: {format(toDate(playerData.lastLogout), "kk:mm dd/MM/yyyy")}</p>
            </>
        )
    }

    return (
        <>
            <h2>{username}&apos;s Global stats</h2>
            <p>Karma: {playerData.karma}</p>
            <h2>{username}&apos;s Current Status</h2>
            {PlayerStatus}
            <h2>{username}&apos;s Skyblock stats</h2>
            <p>Coin Purse: {playerData.coinPurse}</p>
            <p>Total Deaths: {playerData.totalDeaths}</p>
            <p>Total Kills: {playerData.totalKills}</p>
        </>
    );
};

export default PlayerDataView;