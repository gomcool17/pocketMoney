import React, { useEffect } from "react";
import styled from "styled-components";
import CommentsNumbers from "./CommentsNumbers";
import CommentWrite from "./CommentWrite";
import deleteCommentApi from "./../../api/comment/DeleteCommentApi";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import findCommentApi from "./../../api/comment/FindCommentApi";
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
  const accesstoken = sessionStorage.getItem(ACCESS_TOKEN);
  function editComment(idx) {
    document.getElementById(idx).style.display = "none";
    document.getElementById("edit" + idx).style.display = "block";
  }
  function deleteComment(id) {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      deleteCommentApi(
        props.boardId,
        id,
        accesstoken,
        props.comments,
        props.setComments
      );
    }
  }

  return (
    <CommentBox>
      {props.comments
        ? props.comments.comments.map((comment, idx) => {
            let date = new Date(comment.timestamp);

            return (
              <Comment>
                <Header>
                  <Writer>작성자: {comment.nickName}</Writer>
                  {comment.state === "USER" ? (
                    <React.Fragment>
                      <EditButton onClick={() => editComment(idx)}>
                        수정
                      </EditButton>
                      <DeleteButton onClick={() => deleteComment(comment.id)}>
                        삭제
                      </DeleteButton>
                    </React.Fragment>
                  ) : (
                    ""
                  )}
                </Header>
                <Content id={idx}>
                  {comment.content.split("\n").map((line) => {
                    return (
                      <>
                        {line}
                        <br />
                      </>
                    );
                  })}
                </Content>
                <div
                  id={"edit" + idx}
                  style={{
                    display: "none",
                  }}
                >
                  <CommentWrite
                    edit={true}
                    editContent={comment.content}
                    boardId={props.boardId}
                    setComments={props.setComments}
                    commentId={comment.id}
                  />
                </div>
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
