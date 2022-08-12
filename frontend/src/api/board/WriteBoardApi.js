import { BACKEND_ADDRESS } from "../../constant/ADDRESS";
import axios from "axios";

function writeBoardApi(
  title,
  content,
  area,
  dayOfWeek,
  year,
  month,
  day,
  hour,
  minute,
  pay,
  accessToken,
  navigate
) {
  const config = {
    headers: {
      "X-AUTH-TOKEN": accessToken,
    },
  };
  const body = {
    title: title,
    content: content,
    area: area,
    dayOfWeek: dayOfWeek,
    date: [year, month, day, hour, minute],
    pay: pay,
  };
  return axios
    .post(BACKEND_ADDRESS + "/boards/", body, config)
    .then((response) => {
      if (response.status === 200) {
        alert("작성이 완료되었습니다");
        navigate("/");
      }
    })
    .catch((error) => {
      if (error.response.status === 401 || error.response.status === 403) {
        alert("로그인이 만료되었습니다. 다시 로그인해주세요.");
        navigate("/login");
        return Promise.reject();
      } else {
        alert("이유가 뭔지 모르겠지만 작성 실패했음.");
        navigate("/");
      }
    });
}

export default writeBoardApi;
