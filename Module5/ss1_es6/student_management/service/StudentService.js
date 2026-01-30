import Student from "../entity/Student.js";
import StudentRepository from "../repository/StudentRepository.js";
import { checkNumber, checkString } from "../common/valid.js";

export default class StudentService {
    constructor() {
        this.studentRepository = new StudentRepository();
    }

    getAllStudents () {
        return this.studentRepository.findAll();
    }

    // addStudent (name, age, score, image) {
    //     if (!name || age <= 0 || score < 0 || score > 10 || !image) {
    //
    //     }
    // }


}