import React from "react";
import styled from "styled-components";

const Outside = styled.div`
  display: inline-block;
  width: 350px;
  height: 400px;
  border-right: 5px solid blue;
`;

function AllMessage() {
  return <Outside></Outside>;
}

export default AllMessage;
