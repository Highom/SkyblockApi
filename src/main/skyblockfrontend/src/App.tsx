/* eslint-disable @typescript-eslint/explicit-module-boundary-types */
import React from 'react';
import './App.css';
import PlayerDataContainer from './PlayerData/PlayerDataContainer';
import TimerCollectionContainer from './TimerCollection/TimerCollectionContainer';

function App() {
  return (
    <div className="App">
      <PlayerDataContainer />
      <TimerCollectionContainer />
    </div>
  );
}

export default App;
