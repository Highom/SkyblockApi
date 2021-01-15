import React, { useEffect, useState } from "react";
import Axios from "axios";
import { ServerInfo } from "./ServerInfoInterface";
import ServerInfoView from "./ServerInfoView";

let serverInfoDefined: ServerInfo;

const ServerInfoContainer: React.FC = () => {
    const [isLoading, setLoading] = useState(true);
    const [serverInfo,setServerInfo] = useState<ServerInfo>();
    const api = "http://localhost:8080";
    
    useEffect(() => {
        Axios.get<ServerInfo>(`${api}/server`).then(( res => {
            setServerInfo(res.data);
             setLoading(false);
            }))
            .catch( err => {console.log(err)});
    }, []);
   
    if(serverInfo !== undefined)
    {
        serverInfoDefined = serverInfo;
    }
    return (
        <ServerInfoView serverInfo={serverInfoDefined} isLoading={isLoading}/>
    );
};

export default ServerInfoContainer;