/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import styled from "styled-components";
import { useNavigate } from "react-router";
import CancelButton from "./../CancelButton";
import InfBox from "./InfBox";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  border: 5px solid red;
`;
const MyInf = styled.div`
  width: 1050px;
  height: 370px;
`;
const BaseImg = styled.div`
  display: inline-block;
  width: 300px;
  height: 300px;
`;
const SubFuncBox = styled.div`
  position: relative;
  display: inline-block;
  width: 300px;
  height: 300px;
`;
const ChatButton = styled.div`
  position: absolute;
  top: 80px;
  left: 90px;
  width: 120px;
  height: 50px;
  font-size: 35px;
  background-color: pink;
  border-radius: 100px;
  cursor: pointer;
  border: 5px solid red;
`;
const EditMyInfoButton = styled.div`
  position: absolute;
  top: 160px;
  left: 50px;
  width: 200px;
  height: 50px;
  font-size: 35px;
  background-color: pink;
  border-radius: 100px;
  cursor: pointer;
  border: 5px solid red;
`;
function Mypage() {
  if (!localStorage.getItem(ACCESS_TOKEN)) {
    alert("로그인이 필요한 서비스입니다!!!");
    window.location.href = "/login";
  }
  const navigate = useNavigate();
  return (
    <Outside>
      <MyInf>
        <CancelButton navigate={navigate} />
        <BaseImg>
          <img
            src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
            alt="my image"
            style={{
              marginLeft: "20px",
              width: "300px",
              height: "300px",
              borderRadius: "1000px",
            }}
          />
        </BaseImg>
        <InfBox />
        <SubFuncBox>
          <ChatButton
            onClick={() => {
              navigate("/chat");
            }}
          >
            채팅방
          </ChatButton>
          <EditMyInfoButton
            onClick={() => {
              navigate("/mypage/edit");
            }}
          >
            내 정보 수정
          </EditMyInfoButton>
        </SubFuncBox>
      </MyInf>
    </Outside>
  );
}

export default Mypage;
