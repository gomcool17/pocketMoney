import React from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import CancelButton from "../CancelButton";
import TitleBlock from "./TitleBlock";
import InfBox from "./InfBox";
import ContentBox from "./ContentBox";
import { useNavigate } from "react-router";
const Outside = styled.div`
  width: 800px;
  margin: 0 auto;
  border: 1px solid blue;
`;

function BoardWrite() {
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
