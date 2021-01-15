export interface ServerInfo{
    online: boolean;
    version: Version;
    players: Players;
    description: string;
}

export interface Version{
    name: string;
}

export interface Players{
    max: number;
    online: number;
}