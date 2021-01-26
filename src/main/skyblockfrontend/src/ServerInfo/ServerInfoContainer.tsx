import React, { useEffect, useState } from "react";
import Axios from "axios";
import { ServerInfo } from "./ServerInfoInterface";
import ServerInfoView from "./ServerInfoView";

const ServerInfoContainer: React.FC = () => {
    const [serverInfo,setServerInfo] = useState<ServerInfo | undefined>();
    const api = "http://localhost:8080";
    
    useEffect(() => {
        Axios.get<ServerInfo>(`${api}/server`).then(( res => {
            setServerInfo(res.data);
            }))
            .catch( err => {console.log(err)});
    }, []);
   
    return (
        <ServerInfoView serverInfo={serverInfo}/>
    );
};

export default ServerInfoContainer;