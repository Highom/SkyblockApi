import React, { useEffect, useState } from "react";
import { ApiHistory } from "./HistoryInterface";
import Axios from "axios";
import HistoryView from "./HistoryView";

let historyDefined: Array<ApiHistory>;

const HistoryContainer: React.FC = () => {
    const [isLoading, setLoading] = useState(true);
    const [history,setHistory] = useState<ApiHistory[]>();
    const api = "http://localhost:8080";

    useEffect(() => {
            Axios.get<ApiHistory[]>(`${api}/history`).then(( res => {
                 setHistory(res.data);
                 setLoading(false);
                })).catch( err => {console.log(err)});
        }, []);

    if(history !== undefined)
    {
        historyDefined = history;
    }
    return (
        <HistoryView history={historyDefined} isLoading={isLoading}/>
    );
};

export default HistoryContainer;