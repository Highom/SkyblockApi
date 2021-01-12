import React from "react";
import NameDialogView from "./NameDialogView";


const NameDialogContainer: React.FC = () => {
    const username = localStorage.getItem('username');

    return (
        <NameDialogView hasName={username !== null}/>
    );
};

export default NameDialogContainer;