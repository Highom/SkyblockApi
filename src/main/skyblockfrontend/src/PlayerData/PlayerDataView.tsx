/* eslint-disable react/prop-types */
import React from "react";
import { PlayerData } from "./PlayerDataInterfaces";

export interface PlayerDataViewProps{
    playerData: PlayerData;
    username: string | null;
}

const PlayerDataView: React.FC<PlayerDataViewProps> = ({ playerData, username }) => {
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
                <p>Last Online: {playerData.lastLogout}</p>
            </>
        )
    }

    return (
        <>
            <h2>{username}&apos;s Global stats</h2>
            <p>Karma: {playerData.karma}</p>
            <p>{playerData.uuid}</p>
            {/* <PlayerStatus />  */}
            <h2>{username}&apos;s Skyblock stats</h2>
            <p>Coin Purse: {playerData.coinPurse}</p>
            <p>Total Deaths: {playerData.totalDeaths}</p>
            <p>Total Kills: {playerData.totalKills}</p>
        </>
    );
};

export default PlayerDataView;