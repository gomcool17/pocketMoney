/* eslint-disable jsx-a11y/img-redundant-alt */
import React from "react";
import styled from "styled-components";

const Outside = styled.div`
  display: inline-block;
  width: 680px;
  height: 400px;
`;
const ImgBox = styled.div`
  width: 400px;
  height: 400px;
  margin: 0 auto;
  //드래그 방지
  -ms-user-select: none;
  -moz-user-select: -moz-none;
  -khtml-user-select: none;
  -webkit-user-select: none;
  user-select: none;
`;

function DefaultRoom() {
  return (
    <Outside>
      <ImgBox>
        <img
          src="/testlogo.JPG"
          alt="my image"
          style={{
            width: "350px",
            height: "350px",
          }}
        />
      </ImgBox>
    </Outside>
  );
}

export default DefaultRoom;
