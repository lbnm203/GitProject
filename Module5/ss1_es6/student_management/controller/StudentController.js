import StudentView from "../view/StudentView.js";
import StudentService from "../service/StudentService.js";

export default class StudentController {
    constructor() {
        this.service = new StudentService();
        this.view = new StudentView();
        this.view.render(this.service.getAllStudents());
    }
}