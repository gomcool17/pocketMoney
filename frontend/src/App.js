import React from "react";
import DefaultPage from "./component/main/DefaultPage";
import {BrowserRouter as Router, Route, Routes,} from "react-router-dom";
import BoardDetails from "./component/boardDetails/BoardDetails";

function App() {
  return (<Router>
    <Routes>
      <Route path="/" exact element={<DefaultPage />} />
      <Route path="/board/:boardId" exact element={<BoardDetails />} />
    </Routes>
  </Router>);
}

export default App;
