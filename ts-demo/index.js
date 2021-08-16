console.log('Hello World!');
//let myVar = 'my Var!';
// reassignment will cause an ERROR when "tsc index.ts" command is run in bash...
//myVar = true;
// 
var myNum = 5;
var myClass = /** @class */ (function () {
    function myClass(someVar) {
        this._myVar = someVar;
    }
    Object.defineProperty(myClass.prototype, "myVar", {
        get: function () {
            return this._myVar;
        },
        enumerable: false,
        configurable: true
    });
    return myClass;
}());
