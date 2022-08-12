import React, { useState, useEffect } from "react";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import { useParams } from "react-router";
import Comments from "./Comments";
import BoardBody from "./BoardBody";
import findBoardApi from "../../api/board/FindBoardApi";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";

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
  font-weight: 1000;
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
const DeleteButton = styled.div`
  display: inline-block;
  width: 75px;
  height: 50px;
  margin-left: 10px;
  line-height: 50px;
  font-size: 20px;
  background-color: lightGreen;
  text-align: center;
  cursor: pointer;
`;
const EditButton = styled.div`
  display: inline-block;
  width: 75px;
  height: 50px;
  margin-left: 30px;
  line-height: 50px;
  font-size: 20px;
  background-color: lightGreen;
  text-align: center;
  cursor: pointer;
`;
const ContentImg = styled.div`
  margin: 0 auto;
  width: 1000px;
  height: 400px;
  border: 5px solid blue;
`;

const BoardDetails = () => {
  const accessToken = localStorage.getItem(ACCESS_TOKEN);
  const match = () => {
    alert("매칭테스트 성공");
  };
  const params = useParams();
  const boardId = params.boardId;
  const [data, setDate] = useState();
  useEffect(() => {
    findBoardApi(accessToken, boardId).then((dataPromise) => {
      setDate(dataPromise);
    });
  }, []);
  console.log(data);
  return (
    <>
      <MainHeader />
      <Outside>
        <ContentHeader>
          <Title>{data ? data.title : ""}</Title>
          {data ? (
            data.isUser === 2 ? (
              <>
                <EditButton>수정</EditButton>
                <DeleteButton>삭제</DeleteButton>
              </>
            ) : data.isUser === 1 ? (
              <ConnectButton onClick={match}>연락하기</ConnectButton>
            ) : (
              ""
            )
          ) : (
            ""
          )}
        </ContentHeader>
        <ContentImg>이미지</ContentImg>
        <BoardBody data={data} />
        <Comments />
      </Outside>
    </>
  );
};

export default BoardDetails;
