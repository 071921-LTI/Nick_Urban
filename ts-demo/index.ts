console.log('Hello World!');

//let myVar = 'my Var!';

// reassignment will cause an ERROR when "tsc index.ts" command is run in bash...
//myVar = true;

// 
let myNum: number =5;

interface myInterface {
    myVar: string;
}

class myClass implements myInterface {
    private _myVar: string;

    constructor(someVar: string) {
        this._myVar = someVar;
    }

    get myVar() {
        return this._myVar;
    }
}