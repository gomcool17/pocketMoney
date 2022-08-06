import React, { useState } from "react";
import styled from "styled-components";
const OutLine = styled.div`
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
function ContentBox() {
  const [content, setContent] = useState("");
  return (
    <OutLine>
      <NewContentTextarea
        value={content}
        onChange={(e) => setContent(e.target.value)}
        placeholder={"내용"}
      />
    </OutLine>
  );
}

export default ContentBox;
