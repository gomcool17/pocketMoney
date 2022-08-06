import React, { useState } from "react";
import styled from "styled-components";
import MainHeader from "./../MainHeader";
import CancelButton from "./../CancelButton";

const Outside = styled.div`
  width: 800px;
  margin: 0 auto;
  border: 1px solid blue;
`;
const TitleBlock = styled.div`
  width: 800px;
  height: 70px;
  line-height: 150px;
  border-top: 1px solid blue;
  border-bottom: 1px solid blue;
`;
const TitleInput = styled.input`
  display: block;
  font-size: 50px;
  width: 770px;
  background-color: #00000000;
  padding: 10px;
  height: 50px;
  border: none;
  &:focus {
    outline: none;
    border: none;
  }
`;
const InfBox = styled.div`
  width: 800px;
  height: 210px;
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
  border: 1px solid gray;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;
const UploadButton = styled.div`
  width: 150px;
  height: 50px;
  line-height: 50px;
  font-size: 20px;
  text-align: center;
  margin-right: 40px;
  margin-left: auto;
  cursor: pointer;
  background-color: lightGreen;
`;
const ContentBox = styled.div`
  border-top: 1px solid blue;
`;
const NewContentTextarea = styled.textarea`
  font-family: "Gowun Dodum", sans-serif;
  font-size: 20px;
  margin: 10px;
  width: 95%;
  resize: none;
  padding: 10px;
  height: 300px;
  border: 1px solid gray;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;

function BoardWrite() {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState("");
  const [time, setTime] = useState("");
  const [content, setContent] = useState("");
  return (
    <>
      <MainHeader />
      <Outside>
        <CancelButton />
        <TitleBlock>
          <TitleInput
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder={"제목"}
          />
        </TitleBlock>
        <InfBox>
          <InfBlock>
            <StyledDiv>시급:</StyledDiv>
            <StyledInput
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </InfBlock>
          <InfBlock>
            <StyledDiv>시간:</StyledDiv>
            <StyledInput
              value={time}
              onChange={(e) => setTime(e.target.value)}
            />
          </InfBlock>
          <InfBlock>
            <UploadButton>사진 업로드</UploadButton>
          </InfBlock>
        </InfBox>
        <ContentBox>
          <NewContentTextarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            placeholder={"내용"}
          />
        </ContentBox>
      </Outside>
    </>
  );
}

export default BoardWrite;
