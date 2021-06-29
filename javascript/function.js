//Function
//서브프로그램이라고 불리며 여러번 재사용이 가능
//한가지의 테스크나 어떤 점을 개선하기 위한

// 1. Function declaration
// function name(param1, param2) { body ... return;}
// one function === one thing
// naming: doSomethong, command, verb
// e.g. createCardAndPoint -> createCare, createPoint
// function is object in JS
function printHello(){
    console.log('Hello');
}
printHello();

function log(message){
    console.log(message);
}
log('Hello@');
log(1234);

//2. Parameters
// premitive parameters : passed by value
// object parameters: passed by reference

//changeName의 펑션을 전달된 오브젝트 이름을 코드로 무조건변경시키는 함수
function changeName(obj){ 
    obj.name = 'coder';
}
const ellie = {name: 'ellie'};
changeName(ellie);
console.log(ellie);

//3. Default parameters (added in ES6)
function showMessage(message, from = 'unknown'){
    console.log(`${message} by ${from}`);
}
showMessage('Hi!');

// Rest parameters (added in ES6)
function printAll(...args){
    for (let i =0; i < args.length; i++){
        console.log(args[i]);
    }
}
printAll('dream', 'coding', 'ellie');