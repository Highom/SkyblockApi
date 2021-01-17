/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import { Box, createMuiTheme, Paper, ThemeProvider } from '@material-ui/core';
import React from 'react';
import './App.css';
import HistoryContainer from './history/HistoryContainer';
import NameDialogContainer from './NameDialog/NameDialogContainer';
import PlayerDataContainer from './PlayerData/PlayerDataContainer';
import ServerInfoContainer from './ServerInfo/ServerInfoContainer';
import TimerCollectionContainer from './TimerCollection/TimerCollectionContainer';

function App() {

  const darkTheme = createMuiTheme({
        palette: {
          type: 'dark',
        },
      })
  return (
    <ThemeProvider theme={darkTheme}>
      <Paper style={{ height: "100vh" }}>
      <Box className="App">
        <NameDialogContainer />
        <HistoryContainer />
        <ServerInfoContainer />
        <PlayerDataContainer />
        <TimerCollectionContainer />
      </Box>
      </Paper>
    </ThemeProvider>
  );
}

export default App;
