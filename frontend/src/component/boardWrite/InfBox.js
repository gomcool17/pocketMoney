import React, { useState } from "react";
import styled from "styled-components";
const OutLine = styled.div`
  width: 800px;
  height: 210px;
  padding-top: 20px;
`;
const InfBlock = styled.div`
  width: 800px;
  height: 70px;
  padding-left: 20px;
`;
const StyledDiv = styled.div`
  display: inline-block;
  width: 100px;
  height: 30px;
  font-size: 30px;
`;
const StyledInput = styled.input`
  display: inline-block;
  font-size: 30px;
  width: 100px;
  background-color: #00000000;
  height: 30px;
  margin-right:10px;
  border: 1px solid gray;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;
const UploadButton = styled.div`
  width: 150px;
  height: 50px;
  line-height: 50px;
  font-size: 20px;
  text-align: center;
  margin-right: 40px;
  margin-left: auto;
  cursor: pointer;
  background-color: lightGreen;
`;
function InfBox() {
  const [price, setPrice] = useState("");
  const [time, setTime] = useState("");
  return (
    <OutLine>
      <InfBlock>
        <StyledDiv>시급:</StyledDiv>
        <StyledInput value={price} onChange={(e) => setPrice(e.target.value)} />
        <StyledDiv>원</StyledDiv>
      </InfBlock>
      <InfBlock>
        <StyledDiv>시간:</StyledDiv>
        <StyledInput value={time} onChange={(e) => setTime(e.target.value)} />
        <StyledDiv>시간</StyledDiv>
      </InfBlock>
      <InfBlock>
        <UploadButton>사진 업로드</UploadButton>
      </InfBlock>
    </OutLine>
  );
}

export default InfBox;
