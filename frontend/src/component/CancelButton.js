import React from "react";
import styled from "styled-components";

const StyledCancelButton = styled.div`
  position: absolute;
  top: -10px;
  right: 0px;
  width: 50px;
  height: 50px;
  color: #446677;
  font-size: 50px;
  font-weight: bold;
  cursor: pointer;
`;

const CancelButton = (props) => {
  return (
    <div
      style={{
        position: "relative",
        width: "100%",
        height: "50px",
        zIndex: "1",
      }}
    >
      <StyledCancelButton
        onClick={() => {
          props.navigate("/");
        }}
      >
        x
      </StyledCancelButton>
    </div>
  );
};

export default CancelButton;
