console.log('welcome to JS')
//number, object, boolean, string

//var or const or let
function foo() {
    let x = 10
    console.log(x)//10
    for (let i = 0; i < 1; i++) {
        let x = 20
        console.log(x)//20
    }
    console.log(x)//20

    const y = 20
    //y = 30
    console.log(y)
}
foo()

function add(a, b) {
    return a + b
}

const anilObject = {
    //value property
    id: 1,
    name: 'anil',
    salary: 1000,
    //functional property
    print: function () {
        return `${this.id}, ${this.name}, ${this.salary}`
    }
}

console.log(anilObject.name)
console.log(anilObject.print())
console.log(anilObject['salary'])

anilObject.location = 'Mysore'
anilObject.sayHi = function () {
    console.log(`${this.name} said Hi...`)
}

anilObject.sayHi()

for (const propName in anilObject) {
    const propValue = anilObject[propName]
    console.log(`${propName}:${propValue}`)
}
