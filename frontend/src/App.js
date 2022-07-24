import React from "react";
import DefaultPage from "./component/DefaultPage";
import {BrowserRouter as Router, Route, Routes,} from "react-router-dom";

function App() {
  return (<Router>
    <Routes>
      <Route path="/" exact element={<DefaultPage />} />
    </Routes>
  </Router>);
}

export default App;
