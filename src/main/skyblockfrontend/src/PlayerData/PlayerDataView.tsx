/* eslint-disable react/prop-types */
import React from "react";
import { PlayerData } from "./PlayerDataInterfaces";

export interface PlayerDataViewProps{
    playerData: PlayerData;
}

const PlayerDataView: React.FC<PlayerDataViewProps> = ({ playerData }) => {
    let PlayerStatus;
    if (playerData.playerStatus.online) {
        PlayerStatus = (
            <>
                <p>{playerData.playerStatus.game.map}</p>
                <p>{playerData.playerStatus.game.mode}</p>
                <p>{playerData.playerStatus.game.type}</p>
            </>
        )
    }else{
        PlayerStatus = (
            <>
                <p>{playerData.lastGame}</p>
                <p>{playerData.lastLogout}</p>
            </>
        )
    }

    return (
        <>
            <p>{playerData.karma}</p>
            <p>{playerData.coinPurse}</p>
            <p>{playerData.totalDeaths}</p>
            <p>{playerData.totalKills}</p>
            <p>{playerData.uuid}</p>
            {/* <PlayerStatus />  */}
        </>
    );
};

export default PlayerDataView;