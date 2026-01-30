const person = {
    firstName: 'John',
    lastName: 'Doe',
    age: 25,
    gender: 'male',
    occupation: 'developer',
    nationality: 'America',
    city: 'France',
    hobbies: ['reading', 'writing', 'photography'],
    languages: ['English', 'Japanese'],
    education: {
        degree: 'Bachelor',
        major: 'Computer Science',
        university: 'Stanford University',
    }
};

// const {firstName, gender, education: { degree }, languages} = person;
//
// const showStudent = () => {
//     document.getElementById('result2').innerHTML = `
//         <strong>Thông tin sinh viên:</strong><br>
//         Name: ${firstName}<br>
//         Gender: ${gender}<br>
//         Degree: ${degree}<br>
//         Language: ${languages[0]}
//     `;
// }

const showStudent = ({firstName, gender, education: { degree }, languages}) => {
        document.getElementById('result2').innerHTML = `
        <strong>Thông tin sinh viên:</strong><br>
        Name: ${firstName}<br>
        Gender: ${gender}<br>
        Degree: ${degree}<br>
        Language: ${languages[0]}
    `;
}