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
  cursor: pointer;
`;
const NextButton = styled.div`
  display: inline-block;
  width: 60px;
  height: 30px;
  margin: 5px;
  padding-top: 5px;
  border: 1px solid gray;
  cursor: pointer;
`;
const NumberButton = styled.div`
  display: inline-block;
  width: 30px;
  height: 30px;
  margin: 5px;
  padding-top: 5px;
  border: 1px solid gray;
  cursor: pointer;
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
        {props.prev ? (
          <PervButton
            onClick={() => {
              props.setNum(
                props.num % 10 === 0
                  ? props.num - 1
                  : parseInt(props.num / 10) - 1 === 0
                  ? 1
                  : (parseInt(props.num / 10) - 1) * 10 + 1
              );
            }}
          >
            〈 이전
          </PervButton>
        ) : (
          ""
        )}
        {range(props.start, props.end + 1).map((index) => {
          return (
            <NumberButton
              onClick={() => {
                props.setNum(index);
              }}
            >
              {index}
            </NumberButton>
          );
        })}
        {props.next ? (
          <NextButton
            onClick={() => {
              props.setNum(
                props.num % 10 === 0
                  ? props.num + 1
                  : (parseInt(props.num / 10) + 1) * 10 + 1
              );
            }}
          >
            다음 〉
          </NextButton>
        ) : (
          ""
        )}
      </Footer>
    </Outside>
  );
}

export default Numbers;
