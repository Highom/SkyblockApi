/* eslint-disable react/prop-types */
import { Box, Typography } from "@material-ui/core";
import React from "react";
import { ServerInfo } from "./ServerInfoInterface";

export interface ServerInfoViewProps{
    serverInfo: ServerInfo | undefined;
}

const ServerInfoView: React.FC<ServerInfoViewProps> = ({ serverInfo }) => {

    if(serverInfo == undefined){
        return <Typography variant="h5">Getting the ServerInfo for you</Typography>;
    }

    let ServerStatus;
    if (serverInfo.online) {
        ServerStatus = (
            <>
                <Typography>Hypixel is Online</Typography>
            </>
        )
    }else{
        ServerStatus = (
            <>
                <Typography>Hypixel is Offline</Typography>
            </>
        )
    }

    return (
        <Box>
            <Typography variant="h5">Server Info</Typography>
            {ServerStatus}
            <Typography>The Server {serverInfo.version.name}</Typography>
            <Typography>There are {serverInfo.players.online}/{serverInfo.players.max} Players online</Typography>
        </Box>
    );
};

export default ServerInfoView;