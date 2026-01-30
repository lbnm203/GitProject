const sv1 = {
    firstName: 'James',
    gender: 'male',
    english: 'English',
    degree: 'Bachelor'
}

const sv2 = {
    name: 'Mary',
    gender: 'female',
    english: 'French',
    degree: 'PHDs'
}

const getInfo = ({ firstName = 'Quan', degree = 'NA' } = {}) => {
    document.getElementById('result3').innerHTML = `
        <strong>Thông tin</strong><br>
        First Name: ${firstName}<br>
        Degree: ${degree}
    `;
}
