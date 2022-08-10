import React from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import CancelButton from "../CancelButton";
import TitleBlock from "./TitleBlock";
import ContentBox from "./ContentBox";
import { useNavigate } from "react-router";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import InfBox from "./infbox/InfBox";
const Outside = styled.div`
  width: 800px;
  margin: 0 auto;
  border: 1px solid blue;
`;

function BoardWrite() {
  if (!localStorage.getItem(ACCESS_TOKEN)) {
    alert("로그인이 필요한 서비스입니다!!!");
    window.location.href = "/login";
  }
  const navigate = useNavigate();
  return (
    <>
      <MainHeader />
      <Outside>
        <CancelButton navigate={navigate} />
        <TitleBlock />
        <InfBox />
        <ContentBox />
      </Outside>
    </>
  );
}

export default BoardWrite;
