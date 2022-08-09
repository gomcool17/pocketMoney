import React, { useState } from "react";
import { useNavigate } from "react-router";
import { ACCESS_TOKEN } from "./../../../constant/LocalStorage";
import styled from "styled-components";
import CancelButton from "../../CancelButton";

const EditButton = styled.a`
  display: block;
  margin: 15px auto;
  height: 45px;
  font-size: 20px;
  padding-top: 13px;
  border: 2px solid black;
  max-width: 500px;
  text-decoration: none;
  color: black;
  &:hover {
    color: #00a0c6;
    text-decoration: none;
    cursor: pointer;
  }
`;
const StyledInput = styled.input`
  display: block;
  font-size: 17px;
  margin: 10px auto;
  max-width: 480px;
  width: 80%;
  padding: 10px;
  height: 35px;
  border: 1px solid gray;
  cursor: pointer;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
  }
`;
const EditBox = styled.div`
  margin: 10px auto;
  width: 800px;
  text-align: center;
  border: 5px solid blue;
`;

function EditMyInfo() {
  const [nickName, setNickName] = useState("");
  const [age, setAge] = useState("");
  const [sex, setSex] = useState("");
  const [userName, setUserName] = useState("");
  if (!localStorage.getItem(ACCESS_TOKEN)) {
    alert("로그인이 필요한 서비스입니다!!!");
    window.location.href = "/login";
  }
  const navigate = useNavigate();
  return (
    <EditBox>
      <CancelButton navigate={navigate} />
      <StyledInput
        value={nickName}
        onChange={(e) => setNickName(e.target.value)}
        placeholder={"닉네임"}
      />
      <StyledInput
        value={userName}
        onChange={(e) => setUserName(e.target.value)}
        placeholder={"이름"}
      />
      <StyledInput
        value={age}
        onChange={(e) => setAge(e.target.value)}
        placeholder={"나이"}
      />
      <StyledInput
        value={sex}
        onChange={(e) => setSex(e.target.value)}
        placeholder={"성별"}
      />
      <StyledInput
        type="text"
        id="pInput"
        readOnly={true}
        placeholder={"도시"}
        onClick={() => {
          window.name = "parentForm";
          window.open(
            "/signup/city",
            "childForm",
            "top=10, left=10, width=650, height=600, status=no, menubar=no, toolbar=no, resizable=no"
          );
        }}
      />
      <EditButton
        onClick={() => {
          if (
            nickName.length &&
            age.length &&
            sex.length &&
            document.getElementById("pInput").value &&
            userName.length
          ) {
            //마이페이지 수정 api
          } else {
            alert("빈칸을 다 채워주세요");
          }
        }}
      >
        수정하기
      </EditButton>
    </EditBox>
  );
}

export default EditMyInfo;
