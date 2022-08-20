import React from "react";
import styled from "styled-components";

const ContentBox = styled.div`
  width: 1050px;
  font-size: 30px;
`;
const SubInf = styled.div`
  margin: 10px auto;
  width: 1000px;
  border: 5px solid blue;
`;
const Writer = styled.div`
  display: inline-block;
  width: 500px;
  height: 50px;
  margin: 10px;
  font-size: 30px;
`;
const KindScore = styled.div`
  display: inline-block;
  width: 450px;
  height: 50px;
  margin: 10px;
  font-size: 30px;
  text-align: right;
`;
const Salary = styled.div`
  margin: 10px;
  width: 400px;
  height: 50px;
`;
const Area = styled.div`
  margin: 10px;
  width: 600px;
  height: 50px;
`;
const View = styled.div`
  margin: 10px;
  width: 400px;
  height: 50px;
`;
const DateOfViewTag = styled.div`
  margin: 10px;
  display: inline-block;
  width: 80px;
`;
const DateOfView = styled.div`
  display: inline-block;
`;

const Content = styled.div`
  margin: 0 auto;
  width: 1000px;
  height: 400px;
  overflow: auto;
  border: 5px solid blue;
`;

function BoardBody(props) {
  const DAYOFWEEK_LIST = [
    { id: 0, date: "월" },
    { id: 1, date: "화" },
    { id: 2, date: "수" },
    { id: 3, date: "목" },
    { id: 4, date: "금" },
    { id: 5, date: "토" },
    { id: 6, date: "일" },
  ];
  return (
    <ContentBox>
      <SubInf>
        <Writer>작성자: {props.data ? props.data.nickName : ""}</Writer>
        <KindScore>100도 이미지</KindScore>
        <Salary>시급: {props.data ? props.data.pay : ""} 원</Salary>
        <Area>지역: {props.data ? props.data.area : ""}</Area>
        <View>조회수: {props.data ? props.data.view : ""}</View>
        <DateOfViewTag>요일:</DateOfViewTag>
        {DAYOFWEEK_LIST.map((item) => {
          return (
            <DateOfView>
              {props.data
                ? props.data.dayOfWeek.includes(item.id)
                  ? item.date + "\u00A0\u00A0"
                  : ""
                : ""}
            </DateOfView>
          );
        })}
      </SubInf>
      <Content>
        {props.data
          ? props.data.content.split("\n").map((line) => {
              return (
                <>
                  {line}
                  <br />
                </>
              );
            })
          : ""}
      </Content>
    </ContentBox>
  );
}

export default BoardBody;
