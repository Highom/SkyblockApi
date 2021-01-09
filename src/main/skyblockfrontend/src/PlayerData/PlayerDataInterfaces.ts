export interface PlayerData{
    karma: number;
    lastLogout: number;
    lastGame: string;
    playerStatus: PlayerStatus;
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