import React, { useState } from "react";
import styled from "styled-components";

const DayDiv = styled.div`
  display: inline-block;
  width: 30px;
  height: 30px;
  font-size: 25px;
`;
const DayInput = styled.input`
  display: inline-block;
  font-size: 20px;
  width: 30px;
  height: 30px;
  margin-right:30px;
  border: 1px solid gray;
  &:focus {
    outline: 2px solid rgb(90, 155, 213);
    border: 1px solid rgb(90, 155, 213);
`;

function DayOfWeek({ dayOfWeek, setDayOfWeek }) {
  const checkedItemHandler = (checked, item) => {
    if (checked) {
      setDayOfWeek([...dayOfWeek, item]);
    } else if (!checked) {
      setDayOfWeek(dayOfWeek.filter((e) => e !== item));
    }
  };
  const DaYOFWEEK_LIST = [
    { id: "0", date: "월" },
    { id: "1", date: "화" },
    { id: "2", date: "수" },
    { id: "3", date: "목" },
    { id: "4", date: "금" },
    { id: "5", date: "토" },
    { id: "6", date: "일" },
  ];
  return (
    <>
      {DaYOFWEEK_LIST.map((item) => {
        return (
          <>
            <DayDiv>{item.date}</DayDiv>
            <label key={item.id} className="innerBox">
              <DayInput
                type="checkbox"
                value={item.id}
                onChange={(e) =>
                  checkedItemHandler(e.target.checked, e.target.value)
                }
                checked={dayOfWeek.includes(item.id) ? true : false}
              />
            </label>
          </>
        );
      })}
    </>
  );
}

export default DayOfWeek;
