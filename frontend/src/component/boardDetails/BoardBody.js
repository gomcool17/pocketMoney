import React from "react";
import styled from "styled-components";

const ContentBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 1050px;
  font-size: 30px;
  border: 5px solid green;
`;
const Salary = styled.div`
  width: 200px;
  height: 50px;
  border: 5px solid green;
`;
const Time = styled.div`
  width: 200px;
  height: 50px;
  border: 5px solid green;
`;
const Content = styled.div`
  width: 1050px;
  height: 400px;
  overflow: auto;
  border: 5px solid green;
`;
const MapBox = styled.div`
  width: 1050px;
  height: 400px;
  border: 5px solid green;
`;

function BoardBody() {
  return (
    <ContentBox>
      <Salary>10000원</Salary>
      <Time>시간</Time>
      <Content>내용</Content>
      <MapBox>지도</MapBox>
    </ContentBox>
  );
}

export default BoardBody;
