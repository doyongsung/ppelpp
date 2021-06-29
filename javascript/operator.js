// 1. String concatenation
console.log('my' + ' cat');
console.log('1' +  2);
console.log(`string literals:

''''
1 + 2 = ${1 + 2}`);

console.log("ellie's \n\t book");

// 2. Numeric operators
console.log(1 +1);
console.log(1 -1);
console.log(1 /1);
console.log(1 *1);
console.log(5 %2);
console.log(2 **3);

// 3.Increment and decrement operators
let counter = 2;
const preIncrement = ++counter;
// counter = counter +1;
// preIncrement = counter;
console.log(`preIncrement: ${preIncrement}, counter: ${ counter}`);
const postIncrement = counter++;
// postIncrement = counter;
// counter = counter + 1;
console.log(`postIncrement: ${postIncrement}, counter: ${ counter}`);
const preDecrement = --counter;
console.log(`preDecrement: ${preDecrement}, counter: ${ counter}`);
const postDecrement = counter--;
console.log(`postDecrement: ${postDecrement}, counter: ${ counter}`);
console.log("================================");
// 4. Assignment operators
let x = 3;
let y = 6;
x += y; // x = x+y;
x -= y;
x *= y;
x /= y;
console.log("================================");
//5. Comparison operators
console.log(10 < 6);
console.log(10 <= 6);
console.log(10 > 6);
console.log(10 >= 6);
console.log("================================");
//6. Logical operators: || (or), && (and), ! (not)
const value1 = false;
const value2 = 4 <2;
console.log("================================");
// ||(or)
console.log(`or: ${value1 || value2 || check()}`); // check를 맨뒤에

function check() {
    for (let i = 0; i <10; i++){
        //wasting time
        console.log('');
    }
    return true;
}
console.log("================================");
// ! (not)
console.log(!value1);
console.log("================================");
// 7. Equlity
const stringFive = '5';
const numberFive = 5;
console.log("================================");
// == loose equality, with type conversion
console.log(stringFive == numberFive);
console.log(stringFive != numberFive);
console.log("================================");
// === strict equality, no type conversion //이거 사용
console.log(stringFive === numberFive);
console.log(stringFive !== numberFive);
console.log("================================");
// object equality by reference
const ellie1 = { name: 'ellie'};
const ellie2 = { name: 'ellie'};
const ellie3 = ellie1;
console.log(ellie1 == ellie2);
console.log(ellie1 == ellie2);
console.log(ellie1 == ellie3);
console.log("================================");
//equality - puzzler
console.log(0 == false);
console.log(0 === false);
console.log('' == false);
console.log('' === false);
console.log(null == undefined);
console.log(null === undefined);

// 8. Conditional operators: if
// if, else if, else
const name = 'ellie';
if (name === 'ellie'){
    console.log('Welcome, Ellie!');
}else if (name === 'coder'){
    console.log('You are amazing coder');
}else {
    console.log('unkwnon');
}

// 9.Ternary operator: ?
// condition ? value1 : value2;
console.log(name === 'ellie' ? 'yes' : 'no');

// for loop, for(begin; condition; step)
for (i = 3; i> 0; i--){
    console.log(`for: ${i}`);
}

for(let i = 3; i> 0; i =i -2){
    //inline variable declaration
    console.log(`inline variable for: ${i}`);
}

for(let i =0; i < 11; i++){
    if( i % 2 !== 0){
        continue;
    }
    console.log(`q1.${i}`);
}

for(let i =0; i< 10; i++){
    if(i >8){
        break;
    }
    console.log(`q2.${i}`);
}
