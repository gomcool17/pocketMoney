import React from "react";
import DefaultPage from "./component/main/DefaultPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import BoardDetails from "./component/boardDetails/BoardDetails";
import LoginPage from "./component/login/LoginPage";
import SignUpPage from "./component/login/SignUpPage";
import Mypage from "./component/mypage/MyPage";
import ChatPage from "./component/chat/ChatPage";
import PopupPostCode from "./component/login/city/PopupPostCode";
import KakaoLoginHandler from "./component/login/KakaoLoginHandler";
import BoardWrite from "./component/boardWrite/BoardWrite";
import EditMyInfo from "./component/mypage/edit/EditMyInfo";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" exact element={<DefaultPage />} />
        <Route path="/login" exact element={<LoginPage />} />
        <Route path="/signup" exact element={<SignUpPage />} />
        <Route path="/signup/city" exact element={<PopupPostCode />} />
        <Route path="/mypage" exact element={<Mypage />} />
        <Route path="/mypage/edit" exact element={<EditMyInfo />} />
        <Route path="/board/:boardId" exact element={<BoardDetails />} />
        <Route path="/board/write" exact element={<BoardWrite />} />
        <Route
          path="/board/write/modify/:boardId"
          exact
          element={<BoardWrite />}
        />
        <Route path="/chat" exact element={<ChatPage />} />
        <Route path="/login/kakao" exact element={<KakaoLoginHandler />} />
      </Routes>
    </Router>
  );
}

export default App;
