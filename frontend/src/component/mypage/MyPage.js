/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import styled from "styled-components";
import { useNavigate } from "react-router";
import CancelButton from "./../CancelButton";
import InfBox from "./InfBox";
import SubFuncBox from "./SubFuncBox";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  border: 5px solid blue;
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

function Mypage() {
  if (!sessionStorage.getItem(ACCESS_TOKEN)) {
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
        <SubFuncBox navigate={navigate} />
      </MyInf>
    </Outside>
  );
}

export default Mypage;
