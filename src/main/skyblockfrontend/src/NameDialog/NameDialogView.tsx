/* eslint-disable react/prop-types */
import { Box, Button, Dialog, DialogContent, DialogContentText, DialogTitle, TextField } from "@material-ui/core";
import React, { useState } from "react";

export interface NameDialogViewProps{
    hasName: boolean;
}

const NameDialogView: React.FC<NameDialogViewProps> = ({ hasName }) => {
    const [isOpen, setOpen] = useState(!hasName);
    const [username, setUsername] = useState("");

    const handleSubmit = (event :React.FormEvent) => {
        event.preventDefault();
        setOpen(false);
        localStorage.setItem("username", username)
    };

    const changeName = () => {
        setOpen(true);
    }

    return (
        <>
            <Box paddingBottom={1}>
                <Button onClick={changeName}>
                    change name
                </Button>
            </Box>
            <Dialog open={isOpen}>
                <DialogTitle id="form-dialog-title">Enter Username</DialogTitle>
                <DialogContent>
                <DialogContentText>
                    We need you&apos;re Username to get your Hypixel Data, the PlayerData won&apos;t work without it.
                </DialogContentText>
                <form onSubmit={handleSubmit}>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="username"
                        label="Username"
                        type="text"
                        fullWidth
                        required
                        defaultValue={localStorage.getItem("username")}
                        onChange={event => setUsername(event.target.value)}
                    />
                    <Button type="submit" color="primary">
                        Submit
                    </Button>
                </form>
                </DialogContent>
            </Dialog>
        </>
    );
};

export default NameDialogView;