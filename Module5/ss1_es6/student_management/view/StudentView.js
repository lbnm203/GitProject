export default class StudentView {
    constructor() {
        this.tableBody = document.getElementById('studentTableBody');
    }

    render(students) {
        this.tableBody.innerHTML = students.map(student => `
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.score}</td>
                <td style="text-align: center"><img src="${student.image}" alt="${student.name}" width="50" height="50"></td>
                <td>
                    <button data-id="${student.id}" class="edit">Sửa</button>
                    <button data-id="${student.id}" class="delete">Xóa</button>
                </td>
            </tr>         
        `).join('');
    }
}