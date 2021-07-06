
//1. Class declarations
class Person{
    // contructor
    constructor(name, age){
        //fields
        this.name = name;
        this.age = age;
    }

    // methods
    speak(){
        console.log(`${this.name}: hello`);
    }
}

const ellie = new Person('ellie',20);
console.log(ellie.name);
console.log(ellie.age);
ellie.speak();

//2. Getter and setters

class User{
    constructor(firstName,lastNmae, age){
        this.firstName = firstName;
        this.lastNmae =lastNmae;
        this.age = age;
    }
    get age(){
        return this._age;
    }
    set age(value){
        // if(value <0){
        // throw Error('age can not be negative');
        this._age = value <0 ? 0 :value;
        }
    }
    // set age(value){
    //     this._age = value;
    // }
const user1 = new User('Steve', 'Job', -1);
console.log(user1.age);

// 3. Fields (public,private)

class Experiment{
    publicField = 2;
    //클래스 내부에서만 값이 보여지고 변경할수없음
    #privateField = 0;
}
const experiment = new Experiment();
console.log(experiment.publicField);
console.log(experiment.privateField);

// 4. Static properties and methods
class Article{
    static publisher = 'Dream Coding';
    constructor(ArticleNumber){
        this.ArticleNumber = ArticleNumber
    }

    static printPublisher(){
        console.log(Article.publisher);
    }
}

const article1 = new Article(1);
const article2 = new Article(2);
console.log(Article.publisher);
Article.printPublisher();

// 5. Ingeritance
class Shape {
    constructor(width,height,color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    drew(){
        console.log(`drawing ${this.color} color of`);
    }

    getArea(){
        return this.width * this.height; 
    }
}

class Rectangle extends Shape {}
class Triangle extends Shape {

drew(){
    super.drew();
    console.log('★');
}
getArea(){
    return (this.width * this.height) /2; 
}

toString(){
    return `Triangle : color : ${this.color}`;
}
}

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.drew();
console.log(rectangle.getArea());
const triangle = new Triangle(20, 20, 'red');
triangle.drew();
console.log(triangle.getArea());


//6. class cehcking: instanceOf
console.log(rectangle instanceof Rectangle);
console.log(triangle instanceof Rectangle);
console.log(triangle instanceof Triangle);
console.log(triangle instanceof Shape);
console.log(triangle instanceof Object);
console.log(triangle.toString());


function calculate (command, a, b){
    switch(command){
        case 'add':
            return a + b;
        case 'substract':
            return a - b;
        case 'divide':
            return a / b;
        case 'multiply' :
            return a * b;
        case 'remainder':
            return a % b;
        default:
            throw Error('unkonwn command');

    }
}
console.log(calculate('add', 2, 3,));
console.log(calculate('substract', 5, 3,));
console.log(calculate('divide', 5, 3,));
console.log(calculate('multiply', 6, 3,));
console.log(calculate('remainder', 7, 3,));
console.log(calculate('fdfd', 5, 3,));