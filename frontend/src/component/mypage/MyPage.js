/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import styled from "styled-components";
import { useNavigate } from "react-router";
import CancelButton from "./../CancelButton";

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
const InfBox = styled.div`
  display: inline-block;
  width: 300px;
  height: 300px;
  padding-left: 100px;
`;
const NickName = styled.div`
  width: 200px;
  height: 30px;
  margin: 10px;
  border: 5px solid blue;
`;
const ChatButtonBox = styled.div`
  position: relative;
  display: inline-block;
  width: 300px;
  height: 300px;
`;
const ChatButton = styled.div`
  position: absolute;
  top: 120px;
  left: 110px;
  width: 100px;
  height: 40px;
  font-size: 30px;
  background-color: pink;
  cursor: pointer;
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
              cursor: "pointer",
              borderRadius: "1000px",
            }}
          />
        </BaseImg>
        <InfBox>
          <NickName></NickName>
          <NickName></NickName>
          <NickName></NickName>
          <NickName></NickName>
          <NickName></NickName>
          <NickName></NickName>
        </InfBox>
        <ChatButtonBox>
          <ChatButton
            onClick={() => {
              navigate("/chat");
            }}
          >
            채팅방
          </ChatButton>
        </ChatButtonBox>
      </MyInf>
    </Outside>
  );
}

export default Mypage;
