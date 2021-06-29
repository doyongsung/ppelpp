//JavaScript is very flexible
// flexible === dangerous 유연하게 하는것은 좋지만 위험
// added ECMAScript 5
'use strict';
// 2. Variable 
// let (added in ES6)
let globalName = 'global name';
{
let name = 'ellie';
console.log(name);
name = 'hello';
console.log(name);
}
console.log(name);
console.log(globalName);

//3 constants 
//선언과 동시에 변경이 불가능
//값을 할당한다음 다시는 변경되지않을 데이터타입을이용
// - 보안상
// - 쓰레드는 동시에 값을 변경할수있는데 const써서 막음
const daysInWeek = 7;
const maxNumber = 5;

//4. Variable types
// 더이상작은 단위로 나눌수없는 타입 : number, String,booleanm,null,undefiedn,symbol
// object, box container 싱글아이템들을 한단위로 묶어서 관리 
// function, first - class function 펑션도 다른데이터타입처럼 변수에 할당가능 , 함수에 파라미터 인자로 전달되고, 함수의  리턴타입으로 funtion으로 가능

//number 하나로 숫자 변수선언
const count = 17; //integer
const size = 17.1; //decimal number
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);

// string
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello ' + brendan;
console.log(`value: ${greeting}, type ${typeof greeting}`);
const helloBob = `hi ${brendan}!`; //template literals(string)
console.log(`value: ${helloBob}, type ${typeof helloBob}`);

//boolean
//false :0, null, undefined, NaN, ''
// true :any other value
const canRead = true;
const test = 3 <1; // false
console.log(`value:${canRead}, type ${typeof canRead}`);
console.log(`value:${test}, type ${typeof test}`);

// null
let nothing = null;
console.log(`value:${nothing}, type ${typeof nothing}`);

//undefined
let x = undefined;
console.log(`value:${x}, type ${typeof x}`);

//symbol, create unique identifiers for objects
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2);
console.log(`value:${symbol1.description}, type ${typeof symbol2.description}`);


// object, real-life ojbect, data structure
// 일상생활에서 볼수있는 물건과 물체들을 대표할 수있는 박스 형태 
const ellie = { name: 'ellie', age: 20};
ellie.age = 21;



//5. Dynamic typing : dynamically typed language
// 내가 좋은 아이디어가있을때 프로토타입
// 다수 엔지니어 ,규모있는곳 x

let text = 'hello';
console.log(text.charAt(0));
console.log(`value:${text}, type ${typeof text}`);
text = 1;
console.log(`value:${text}, type ${typeof text}`);
text = '7' +5;
console.log(`value:${text}, type ${typeof text}`); //스트링으로 변환댐
text = '8' / '2';
console.log(`value:${text}, type ${typeof text}`); //number 변환

