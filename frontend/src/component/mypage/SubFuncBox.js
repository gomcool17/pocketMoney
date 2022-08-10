import React from "react";
import styled from "styled-components";

const Outside = styled.div`
  position: relative;
  display: inline-block;
  width: 300px;
  height: 300px;
`;
const ChatButton = styled.div`
  position: absolute;
  top: 40px;
  left: 90px;
  width: 120px;
  height: 50px;
  font-size: 35px;
  text-align: center;
  background-color: pink;
  border-radius: 100px;
  cursor: pointer;
  border: 5px solid red;
`;
const EditMyInfoButton = styled.div`
  position: absolute;
  top: 120px;
  left: 50px;
  width: 200px;
  height: 50px;
  font-size: 35px;
  text-align: center;
  background-color: pink;
  border-radius: 100px;
  cursor: pointer;
  border: 5px solid red;
`;

const KindScore = styled.div`
  position: absolute;
  top: 210px;
  left: 70px;
  width: 150px;
  height: 40px;
  font-size: 25px;
  text-align: center;
  background-color: lightYellow;
  border-radius: 100px;
  border: 5px solid yellow;
`;
function SubFuncBox(props) {
  return (
    <Outside>
      <ChatButton
        onClick={() => {
          props.navigate("/chat");
        }}
      >
        채팅방
      </ChatButton>
      <EditMyInfoButton
        onClick={() => {
          props.navigate("/mypage/edit");
        }}
      >
        내 정보 수정
      </EditMyInfoButton>
      <KindScore>친절도: 100</KindScore>
    </Outside>
  );
}

export default SubFuncBox;
