
// const name = 'ellie';
// const age = 4;
// print(name,age);
// function print(name, age){
//     console.log(name);
//     console.log(age);
// }

//object = { key : value}; 키와 벨류의 집합체
const obj1 = {}; //오브젝트 리터럴
const obj2 = new Object(); //오브젝트 콘스트럭터

function print(person){
    console.log(person.name);
    console.log(person.age);
}
              // key  : value, key : value
const ellie = { name: 'ellie', age :4};
print(ellie);

ellie.hasJob = true;
console.log(ellie.hasJob);


//삭제 
delete ellie.hasJob;
console.log(ellie.hasJob);


//2. Computed properties
// String 타입으로 해야함 'name'
// 우리가 정확히 어떤키가 필요한지 모를때
console.log(ellie.name);
console.log(ellie['name']);
// 변경도 가능
ellie['hasJob'] = true;
console.log(ellie.hasJob);

function printValue(obj, key){
    console.log(obj[key]);
}
printValue(ellie,'name');
printValue(ellie,'age');

//3. property value shorthand
const person1 = { name: 'bob', age : 2};
const person2 = { name: 'steve', age : 3};
const person3 = { name: 'dave', age : 4};
const person4 = new Person('elile',30);
console.log(person4);

//4. Constuctor function
function Person(name,age){
   // return {
        //키와 벨류가 같다면 생략가능 
        // name: name,
        // age: age,


        //this = {};
        this.name = name;
        this.age = age;
        //return this;
    };
//}

//5. in operator // 안에 키가있느지 확인
console.log('name' in ellie)
console.log('age' in ellie)
console.log('random' in ellie)
console.log(ellie.random);

//6. for..in vs for..of
// for(key in obj)
// 키 삭제

console.clear();
// 모든 키 출력
for (key in ellie){
    console.log(key);
}

//for (value of iterable)
const array = [1,2,4,5];
for(let i =0; i <array.length; i++){
    console.log(array[i]);
}
// 보다 쉽게
for(value of array){
    console.log(value);
}

//7.Fun cloning
//Object.assign(dest, [obj1, obj2, obj3...])
const user = { name: 'ellie', age: '20'};
const user2 = user;
user2.name ='coder';
console.log(user);

//old way
const user3 ={};
for (key in user){
    user3[key] = user[key];
}
console.clear();
console.log(user3);

//const user4 ={};
//Object.assign(user4, user);

const user4 = Object.assign({},user);
console.log(user4);


//another example
const fruit1 = { color: 'red'};
const fruit2 = { color: 'blue', size: 'big'};

// 계속 덮어 씌움
const mixed = Object.assign({}, fruit1, fruit2);
console.log(mixed.color);
console.log(mixed.size);