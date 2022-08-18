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

function Numbers(props) {
  function range(start, end) {
    let array = [];
    for (let i = start; i < end; ++i) {
      array.push(i);
    }
    return array;
  }
  return (
    <Outside>
      <Footer>
        {props.prev ? <PervButton>〈 이전</PervButton> : ""}
        {range(props.start, props.end + 1).map((index) => {
          return <NumberButton>1</NumberButton>;
        })}
        {props.next ? <NextButton>다음 〉</NextButton> : ""}
      </Footer>
    </Outside>
  );
}

export default Numbers;
