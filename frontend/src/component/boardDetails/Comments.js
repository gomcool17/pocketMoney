import React from "react";
import styled from "styled-components";
import CommentsNumbers from "./CommentsNumbers";
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
const Header = styled.div``;
const Writer = styled.div`
  display: inline-block;
  font-size: 15px;
`;
const EditButton = styled.div`
  margin-left: 720px;
  display: inline-block;
  font-size: 15px;
  color: gray;
  cursor: pointer;
`;
const DeleteButton = styled.div`
  margin-left: 10px;
  display: inline-block;
  font-size: 15px;
  color: gray;
  cursor: pointer;
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
  console.log(props.comments);
  return (
    <CommentBox>
      {props.comments
        ? props.comments.comments.map((comment) => {
            let date = new Date(comment.timestamp);

            return (
              <Comment>
                <Header>
                  <Writer>작성자: {comment.nickName}</Writer>
                  {comment.state === "USER" ? (
                    <React.Fragment>
                      <EditButton>수정</EditButton>
                      <DeleteButton>삭제</DeleteButton>
                    </React.Fragment>
                  ) : (
                    ""
                  )}
                </Header>
                <Content>{comment.content}</Content>
                <CreatedDate>
                  {" "}
                  {date.getYear() + 1900}년 {date.getMonth()}월 {date.getDay()}
                  일 {date.getHours()}시 {date.getMinutes()}분
                </CreatedDate>
              </Comment>
            );
          })
        : "댓글이 없습니다!"}
      <CommentsNumbers
        commentPage={props.commentPage}
        setCommentPage={props.setCommentPage}
        start={props.comments.start}
        end={props.comments.end}
        prev={props.comments.prev}
        next={props.comments.next}
      />
    </CommentBox>
  );
}

export default Comments;
