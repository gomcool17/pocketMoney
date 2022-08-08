import React from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import { useParams } from "react-router";
import Comments from "./Comments";
import BoardBody from "./BoardBody";

const Outside = styled.div`
  width: 1050px;
  margin: 10px auto;
  border: 5px solid blue;
`;
const ContentHeader = styled.div`
  margin-top: 10px;
  width: 1050px;
  height: 60px;
`;
const Title = styled.div`
  display: inline-block;
  width: 800px;
  height: 50px;
  padding-left: 30px;
  font-size: 30px;
  font-weight: 700;
`;
const ConnectButton = styled.div`
  display: inline-block;
  width: 150px;
  height: 50px;
  margin-left: 30px;
  line-height: 50px;
  font-size: 20px;
  background-color: lightGreen;
  text-align: center;
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
          <Title>강아지 산책하실분</Title>
          <ConnectButton onClick={match}>연락하기</ConnectButton>
        </ContentHeader>
        <ContentImg>이미지</ContentImg>
        <Writer>히히</Writer>
        <KindScore>100도 이미지</KindScore>
        <BoardBody />
        <Comments />
      </Outside>
    </>
  );
};

export default BoardDetails;
