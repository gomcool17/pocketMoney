import React from "react";
import styled from "styled-components";

const Outside = styled.div`
  text-align: center;
  width: 1050px;
  height: 40px;
`;

const Footer = styled.div`
  display: inline-block;
  margin: 0 auto;
  height: 40px;
`;

const PervButton = styled.div`
  display: inline-block;
  width: 60px;
  height: 30px;
  margin: 5px;
  padding-top: 5px;
  border: 1px solid gray;
`;
const NextButton = styled.div`
  display: inline-block;
  width: 60px;
  height: 30px;
  margin: 5px;
  padding-top: 5px;
  border: 1px solid gray;
`;
const NumberButton = styled.div`
  display: inline-block;
  width: 30px;
  height: 30px;
  margin: 5px;
  padding-top: 5px;
  border: 1px solid gray;
`;

function Numbers() {
  return (
    <Outside>
      <Footer>
        <PervButton>〈 이전</PervButton>
        <NumberButton>1</NumberButton>
        <NumberButton>2</NumberButton>
        <NumberButton>3</NumberButton>
        <NumberButton>4</NumberButton>
        <NumberButton>5</NumberButton>
        <NumberButton>6</NumberButton>
        <NumberButton>7</NumberButton>
        <NumberButton>8</NumberButton>
        <NumberButton>9</NumberButton>
        <NumberButton>10</NumberButton>
        <NextButton>다음 〉</NextButton>
      </Footer>
    </Outside>
  );
}

export default Numbers;
