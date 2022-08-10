import React, { useState } from "react";
import styled from "styled-components";
import Date from "./Date";
import DayOfWeek from "./DayOfWeek";
import ImgUpload from "./ImgUpload";

const OutLine = styled.div`
  width: 800px;
  height: 420px;
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
        <StyledDiv>지역:</StyledDiv>
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
      </InfBlock>
      <InfBlock>
        <StyledDiv>요일:</StyledDiv>
        <DayOfWeek />
      </InfBlock>
      <InfBlock>
        <Date />
      </InfBlock>
      <InfBlock>
        <ImgUpload />
      </InfBlock>
    </OutLine>
  );
}

export default InfBox;
