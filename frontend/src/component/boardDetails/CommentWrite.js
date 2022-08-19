import React, { useCallback, useRef, useState } from "react";
import styled from "styled-components";
import createCommentApi from "../../api/comment/CreateCommentApi";
import { ACCESS_TOKEN } from "./../../constant/LocalStorage";
import findCommentApi from "./../../api/comment/FindCommentApi";
import editCommentApi from "./../../api/comment/EditCommentApi";
import { useNavigate } from "react-router";

const Outside = styled.div`
  margin: 10px auto;
  width: 1000px;
  padding: 10px;
  display: flex;
  flex-direction: row;
  align-items: center;
`;

const StyledTextarea = styled.textarea`
  font-family: "Gowun Dodum", sans-serif;
  font-size: 30px;
  background-color: #00000000;
  padding: 3px 10px 10px 10px;
  height: 40px;
  max-height: 120px;
  width: 80%;
  resize: none;
`;

const CommentWritingButton = styled.button`
  height: 50px;
  width: 60px;
  margin-left: 5px;
  padding: 7px;
  background: #333333;
  color: #cccccc;
  font-family: "Gowun Dodum", sans-serif;
  border-radius: 5px;
`;

const CommentWrite = ({
  edit,
  editContent,
  boardId,
  setComments,
  commentId,
}) => {
  const accesstoken = sessionStorage.getItem(ACCESS_TOKEN);
  const [inputValue, setInputValue] = useState(edit ? editContent : "");
  const writingRef = useRef();
  const navigate = useNavigate();

  const handleResizeHeight = useCallback(() => {
    if (writingRef === null || writingRef.current === null) return;
    if (writingRef.current.style.height === "20px") {
      writingRef.current.style.overflow = "hidden";
    } else {
      writingRef.current.style.overflow = "";
    }
    writingRef.current.style.height = "20px";
    writingRef.current.style.height =
      writingRef.current.scrollHeight - 18 + "px";
  }, []);

  return (
    <Outside>
      <StyledTextarea
        ref={writingRef}
        value={inputValue}
        onChange={(e) => {
          setInputValue(e.target.value);
          handleResizeHeight();
        }}
        placeholder="댓글을 입력해주세요 :)"
        style={{}}
      />
      <CommentWritingButton
        onClick={() => {
          if (inputValue.length === 0) alert("댓글을 채워주세요!");
          else {
            setInputValue("");
            if (!edit) {
              createCommentApi(boardId, inputValue, accesstoken).then(
                (response) => {
                  findCommentApi(accesstoken, boardId, 1).then(
                    (dataPromise) => {
                      setComments(dataPromise);
                    }
                  );
                }
              );
            } else {
              editCommentApi(boardId, commentId, inputValue, accesstoken).then(
                (response) => {
                  window.location.href = "/board/" + boardId;
                }
              );
            }
          }
        }}
      >
        등록
      </CommentWritingButton>
    </Outside>
  );
};

export default CommentWrite;
