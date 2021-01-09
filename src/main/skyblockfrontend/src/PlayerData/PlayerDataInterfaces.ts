export interface PlayerData{
    karma: number;
    lastLogout: number;
    lastGame: string;
    playerStatus: PlayerStatus;
    coinPurse: number;
    totalDeaths: number;
    totalKills: number;
    uuid: string;
}

export interface PlayerStatus{
    online: boolean;
    game: PlayerStatusGame;
}

export interface PlayerStatusGame{
    type: string;
    mode: string;
    map: string;
}