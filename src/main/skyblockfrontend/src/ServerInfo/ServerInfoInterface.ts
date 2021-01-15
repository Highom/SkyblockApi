export interface ServerInfo{
    online: boolean;
    version: Version;
    players: Players;
}

export interface Version{
    name: string;
}

export interface Players{
    max: number;
    online: number;
}