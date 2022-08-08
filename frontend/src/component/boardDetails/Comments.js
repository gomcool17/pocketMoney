import React from "react";
import styled from "styled-components";
const CommentBox = styled.div`
  width: 1050px;
  height: 400px;
  overflow: auto;
  border: 5px solid green;
`;

const Comment = styled.div`
  display: flex;
  flex-direction: column;
  margin: 20px auto;
  width: 900px;
  min-height: 100px;
  overflow: auto;
  border: 5px solid green;
`;
const Writer = styled.div`
  font-size: 20px;
`;
const Content = styled.div`
  font-size: 30px;
`;
const CreatedDate = styled.div`
  margin-right: 20px;
  margin-left: auto;
  font-size: 15px;
  color: gray;
`;

function Comments() {
  return (
    <CommentBox>
      <Comment>
        <Writer>작성자</Writer>
        <Content>
          안녕하세요안녕안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요하세요안녕하세요안녕하세요
        </Content>
        <CreatedDate>시간</CreatedDate>
      </Comment>
      <Comment>
        <Writer>작성자</Writer>
        <Content>안녕하세요</Content>
        <CreatedDate>시간</CreatedDate>
      </Comment>
    </CommentBox>
  );
}

export default Comments;
