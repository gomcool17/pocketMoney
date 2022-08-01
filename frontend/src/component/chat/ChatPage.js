import React from "react";
import styled from "styled-components";
import ChattingRoom from "./ChattingRoom";

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
  return (
    <Outside>
      <Block></Block>
      <Block></Block>
      <ChattingRoom />
      <Block></Block>
    </Outside>
  );
}

export default ChatPage;
