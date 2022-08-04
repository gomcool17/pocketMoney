import React from "react";
import styled from "styled-components";
import CancelButton from "../CancelButton";
import ChattingRoom from "./ChattingRoom";
import { useNavigate } from "react-router";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  border-top: 5px solid blue;
  border-left: 5px solid blue;
  border-right: 5px solid blue;
`;
const Block = styled.div`
  width: 1050px;
  height: 100px;
  border-bottom: 5px solid blue;
`;

function ChatPage() {
  const navigate = useNavigate();
  return (
    <Outside>
      <CancelButton navigate={navigate} />
      <Block style={{ height: "50px" }}></Block>
      <Block></Block>
      <ChattingRoom />
      <Block></Block>
    </Outside>
  );
}

export default ChatPage;
