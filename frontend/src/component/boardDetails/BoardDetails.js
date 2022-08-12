import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import styled from "styled-components";
import MainHeader from "../MainHeader";
import { useParams } from "react-router";
import Comments from "./Comments";
import BoardBody from "./BoardBody";
import findBoardApi from "../../api/board/FindBoardApi";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import deleteBoardApi from "../../api/board/DeleteBoardApi";

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
  const navigate = useNavigate();
  const accessToken = localStorage.getItem(ACCESS_TOKEN);
  const match = () => {
    alert("매칭테스트 성공");
  };
  const params = useParams();
  const boardId = params.boardId;
  const [data, setDate] = useState();

  useEffect(() => {
    findBoardApi(accessToken, boardId, navigate).then((dataPromise) => {
      if (dataPromise === null) {
        alert("존재하지 않는 구인 글 입니다!!!!");
        navigate("/");
      }
      setDate(dataPromise);
    });
  }, []);

  const onDeleteButtonClicked = () => {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      deleteBoardApi(boardId, accessToken, navigate);
    }
  };

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
                <DeleteButton onClick={onDeleteButtonClicked}>
                  삭제
                </DeleteButton>
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
