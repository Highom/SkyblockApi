/* eslint-disable react/prop-types */
import { Box, Button, Dialog, DialogContent, DialogContentText, DialogTitle, TextField } from "@material-ui/core";
import React, { useRef, useState } from "react";

export interface NameDialogViewProps{
    hasName: boolean;
}

const NameDialogView: React.FC<NameDialogViewProps> = ({ hasName }) => {
    const [isOpen, setOpen] = useState(!hasName);
    const usernameRef = useRef();

    const handleSubmit = (event :React.FormEvent) => {
        event.preventDefault();
        setOpen(false);
        localStorage.setItem("username", "Highom") //FIXME: usernameRef.current.value
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
                        inputRef={usernameRef}
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