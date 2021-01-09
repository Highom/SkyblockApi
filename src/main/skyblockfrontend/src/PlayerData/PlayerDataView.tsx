import React from "react";
import { PlayerData } from "./PlayerDataInterfaces";

export interface PlayerDataViewProps{
    playerData: PlayerData;
}

const PlayerDataView: React.FC<PlayerDataViewProps> = () => {
    return (
        <p>test</p>
    );
};

export default PlayerDataView;