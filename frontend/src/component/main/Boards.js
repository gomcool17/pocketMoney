import React from 'react'
import styled from 'styled-components';

const BoardList = styled.div`
  width: 1050px;
`
const BoardBox = styled.div`
  display: inline-block;
  width: 300px;
  height: 365px;
  border: 5px solid black;
  margin: 20px;
`
const ImgBox = styled.div`
  margin: 0 auto;
  margin-top: 15px;
  width: 250px;
  height: 200px;
  border: 5px solid blue;
`
const BoardTitle = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`
const Salary = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`
const Location = styled.div`
  margin: 0 auto;
  margin-top: 3px;
  width: 250px;
  height: 30px;
  text-align: center;
  border: 5px solid blue;
`

function Boards() {
    return <>
    <BoardList>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
        <BoardBox>
          <ImgBox>이미dddd지</ImgBox>
          <BoardTitle>제목</BoardTitle>
          <Salary>급여</Salary>
          <Location>위치</Location>
        </BoardBox>
      </BoardList>
    </>
}

export default Boards
