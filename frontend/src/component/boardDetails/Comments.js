import React from "react";
import styled from "styled-components";
const CommentBox = styled.div`
  margin: 10px auto;
  width: 1000px;
  height: 400px;
  overflow: auto;
  border: 5px solid blue;
`;

const Comment = styled.div`
  display: flex;
  flex-direction: column;
  margin: 20px auto;
  width: 900px;
  min-height: 100px;
  overflow: auto;
  border: 5px solid blue;
`;
const Writer = styled.div`
  font-size: 15px;
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

function Comments(props) {
  return (
    <CommentBox>
      {props.comments
        ? props.comments.comments.map((comment) => {
            let date = new Date(comment.timestamp);

            return (
              <Comment>
                <Writer>작성자: {comment.nickName}</Writer>
                <Content>{comment.content}</Content>
                <CreatedDate>
                  {" "}
                  {date.getYear() + 1900}년 {date.getMonth()}월 {date.getDay()}
                  일 {date.getHours()}시 {date.getMinutes()}분
                </CreatedDate>
              </Comment>
            );
          })
        : ""}
    </CommentBox>
  );
}

export default Comments;
