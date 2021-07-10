let target = document.querySelector("#dynamic");
//배열 변수
let stringArr = [
  "learn to HTML",
  "learn to CSS",
  "learn to Javascript",
  "learn to Python",
  "learn to Ruby",
];

//랜덤 문자 만들기
let selectString = stringArr[Math.floor(Math.random() * stringArr.length)];

// 해당 문자열을 "" 기준을 이용해서 배열을 분리시킨다 -> 글자 하나씩 배열로나옴
let selectStringArr = selectString.split("");

function dynamic(randomArr) {
  if (randomArr.length > 0) {
    target.textContent += randomArr.shift();
  }
}

dynamic(selectStringArr);
// console.log(selectStringArr);
// console.log(selectString);
// console.log([Math.floor(Math.random() * stringArr.length)]);

function blink() {
  // 커서가 깜빡임 효과
  // active 클래스가 추가 삭제 반복
  // target.classList.toggle("active");
}

// 0.5초간격으로 추가 삭제 반복
setInterval(blink, 500);
