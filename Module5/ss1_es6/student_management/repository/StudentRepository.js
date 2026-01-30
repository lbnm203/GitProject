import Student from "../entity/Student.js";

export default class StudentRepository {
    constructor() {
        this.students = [
            new Student(1, "Sinh", 23, 8, "https://img.freepik.com/free-vector/smiling-young-man-illustration_1308-174669.jpg?semt=ais_hybrid&w=740&q=80"),
            new Student(2, "Tri", 23, 8, "https://img.freepik.com/free-vector/smiling-young-man-illustration_1308-174669.jpg?semt=ais_hybrid&w=740&q=80"),
            new Student(3, "Nguyen", 27, 8, "https://img.freepik.com/free-vector/smiling-young-man-illustration_1308-174669.jpg?semt=ais_hybrid&w=740&q=80"),
            new Student(4, "Minh", 22, 8, "https://img.freepik.com/free-vector/smiling-young-man-illustration_1308-174669.jpg?semt=ais_hybrid&w=740&q=80")
        ];
    }

    findAll() {
        return this.students;
    }

    save(student) {
        this.students.push(student);
    }

    delete(id) {
        this.students = this.students.filter(student => student.id !== id);
    }

    findById(id) {
        this.students = this.students.find(student => student.id === id);
    }

    update(student) {
        this.students = this.students.map(student => student.id === id ? {...student, ...newStudent } : student);
    }


}