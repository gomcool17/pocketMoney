import React from "react";
import styled from "styled-components";
const Outside = styled.div`
  display: inline-block;
  width: 300px;
  height: 300px;
  padding-left: 100px;
`;
const Information = styled.div`
  width: 200px;
  height: 35px;
  margin: 10px;
  font-size: 28px;
  border: 2px solid blue;
  border-radius: 100px;
`;
function InfBox() {
  return (
    <Outside>
      <Information>이메일: </Information>
      <Information>닉네임: </Information>
      <Information>이름: </Information>
      <Information>나이: </Information>
      <Information>성별: </Information>
      <Information>도시: </Information>
    </Outside>
  );
}

export default InfBox;
