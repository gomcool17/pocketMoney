import React from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import { useParams } from "react-router";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  border: 5px solid blue;
`;
const ContentHeader = styled.div`
  margin-top: 10px;
  width: 1050px;
  height: 70px;
`;
const ConnectButton = styled.div`
  width: 150px;
  height: 50px;
  line-height: 50px;
  font-size: 20px;
  border: 5px solid green;
  text-align: center;
  margin-right: 20px;
  margin-left: auto;
  cursor: pointer;
`;
const ContentImg = styled.div`
  width: 1050px;
  height: 400px;
  border: 5px solid green;
`;
const Writer = styled.div`
  display: inline-block;
  width: 500px;
  height: 50px;
  margin: 10px;
  border: 5px solid green;
  font-size: 30px;
`;
const KindScore = styled.div`
  display: inline-block;
  width: 450px;
  height: 50px;
  margin: 10px;
  border: 5px solid green;
  font-size: 30px;
  text-align: right;
`;
const ContentBox = styled.div`
  display: flex;
  flex-direction: column;
  width: 1050px;
  font-size: 30px;
  border: 5px solid green;
`;
const Title = styled.div`
  width: 1050px;
  height: 50px;
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
const CommentBox = styled.div`
  width: 1050px;
  height: 400px;
  overflow: auto;
  border: 5px solid green;
`;
const Comment = styled.div`
  margin: 20px auto;
  width: 900px;
  min-height: 100px;
  overflow: auto;
  border: 5px solid green;
`;

const BoardDetails = () => {
  const match = () => {
    alert("매칭테스트 성공");
  };
  const params = useParams();
  const boardId = params.boardId;
  return (
    <>
      <MainHeader />
      <Outside>
        <ContentHeader>
          <ConnectButton onClick={match}>연락하기</ConnectButton>
        </ContentHeader>
        <ContentImg>이미지</ContentImg>
        <Writer>히히</Writer>
        <KindScore>100도 이미지</KindScore>
        <ContentBox>
          <Title>강아지 산책하실분</Title>
          <Salary>10000원</Salary>
          <Time>시간</Time>
          <Content>내용</Content>
          <MapBox>지도</MapBox>
          <CommentBox>
            <Comment>
              안녕안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요하세요안녕하세요안녕하세요
            </Comment>
            <Comment>안녕하세요</Comment>
            <Comment>안녕하세요</Comment>
            <Comment>안녕하세요</Comment>
            <Comment>ㅈㅂㄷㅇㄴㅊㅌㅋ안녕하세요</Comment>
            <Comment>안녕하세요</Comment>
          </CommentBox>
        </ContentBox>
      </Outside>
    </>
  );
};

export default BoardDetails;
