import React from "react";
import DefaultPage from "./component/main/DefaultPage";
import {BrowserRouter as Router, Route, Routes,} from "react-router-dom";
import BoardDetails from "./component/boardDetails/BoardDetails";
import LoginPage from "./component/login/LoginPage";
import SignUpPage from "./component/login/SignUpPage";

function App() {
  return (<Router>
    <Routes>
      <Route path="/" exact element={<DefaultPage />} />
      <Route path="/login" exact element={<LoginPage />} />
      <Route path="/signup" exact element={<SignUpPage />} />
      <Route path="/board/:boardId" exact element={<BoardDetails />} />
    </Routes>
  </Router>);
}

export default App;
