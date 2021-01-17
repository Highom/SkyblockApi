/* eslint-disable react/prop-types */
import { Box, Button, Dialog, DialogActions, DialogContent, DialogTitle, List, ListItem, ListItemText, Typography } from "@material-ui/core";
import React from "react";
import { useState } from "react";
import { ApiHistory } from "./HistoryInterface";

export interface HistoryViewProps{
    history: ApiHistory[];
    isLoading: boolean;
}

const HistoryView: React.FC<HistoryViewProps> = ({ history, isLoading }) => {
    const [isOpen, setOpen] = useState(false);
   
    if(isLoading){
        return <Typography variant="h5">Getting the History for you</Typography>;
    }

    const handleOpen = () => {
        setOpen(true);
    }

    const handleClose = () => {
        setOpen(false);
    };
    
    return (
        <>
            <Box paddingBottom={1}>
                <Button onClick={handleOpen}>
                    History
                </Button>
            </Box>
            <Dialog open={isOpen} onClose={handleClose}>
                <DialogTitle id="form-dialog-title">History</DialogTitle>
                <DialogContent>
                    <List dense={true}>
                    {history.map(
                        (apiCall,i) =>{
                            <ListItem key={i}>
                                <ListItemText
                                    primary={`Id:${apiCall.id}, request: ${apiCall.request}, answer: ${apiCall.answer}, date:${apiCall.dateCalled}`}
                                />
                            </ListItem>
                        }
                    )}
                    </List>
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Cancel
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    );
};

export default HistoryView;