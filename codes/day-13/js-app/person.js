class Person {
    constructor(id, name, salary) {
        this.personId = id
        this.personName = name
        this.personSalary = salary
    }
    get id() {
        return this.personId
    }
    set id(id) {
        this.id = id
    }
    show() {
        return `${this.personId}, ${this.personName}, ${this.personSalary}`
    }
}

class Trainer extends Person {
    constructor(id, name, salary, subject) {
        super(id, name, salary)
        this.trainerSubject = subject
    }
    show() {
        return `${super.show()}, ${this.trainerSubject}`
    }
}

const anilObj = new Trainer(1, 'anil', 1000, 'JavaScript')
console.log(anilObj.show())
// anilObj.id = 2
// console.log(anilObj.id)
// console.log(anilObj.personId)