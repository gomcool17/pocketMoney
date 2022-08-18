import React from "react";
import styled from "styled-components";

const BoardList = styled.div`
  width: 1050px;
`;
const BoardBox = styled.div`
  display: inline-block;
  width: 300px;
  height: 365px;
  border: 5px solid black;
  margin: 20px;
`;
const ImgBox = styled.div`
  margin: 0 auto;
  margin-top: 15px;
  width: 250px;
  height: 200px;
  border: 5px solid blue;
`;
const BoardTitle = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`;
const Salary = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`;
const Location = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`;

function Boards(props) {
  return (
    <>
      <BoardList>
        {props.boards
          ? props.boards.map((board) => {
              let date = new Date(board.createTime);
              return (
                <BoardBox
                  onClick={() => {
                    props.navigate("/");
                  }}
                >
                  <ImgBox>이미지</ImgBox>
                  <BoardTitle>제목: {board.title}</BoardTitle>
                  <Salary>작성자: {board.nickName}</Salary>
                  <Location>
                    {date.getYear() + 1900}년 {date.getMonth()}월{" "}
                    {date.getDay()}일 {date.getHours()}시 {date.getMinutes()}분
                  </Location>
                </BoardBox>
              );
            })
          : ""}
      </BoardList>
    </>
  );
}

export default Boards;
