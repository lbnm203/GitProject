const courses = [
    {
        id: 1,
        title: "ReactJS Tutorial",
        rating: 4.2,
    },
    {
        id: 2,
        title: "Angular Tutorial",
        rating: 2.5,
    },
    {
        id: 3,
        title: "VueJS Tutorial",
        rating: 3.8,
    },
    {
        id: 4,
        title: "Java Tutorial",
        rating: 4,
    },
    {
        id: 5,
        title: "JavaScript Tutorial",
        rating: 3.5,
    },
];

let addedCourses = [
    {
        id: 6,
        title: "PHP Tutorial",
        rating: 3,
    },
    {
        id: 7,
        title: "C# Tutorial",
        rating: 2,
    },
    {
        id: 8,
        title: "Docker Tutorial",
        rating: 3.8,
    }
];

const showPostRating = () => {
    const html = courses.filter(course => course.rating >= 4).map(({ title, rating }) =>  `
        <br>
        <strong>Thông tin Post</strong><br>
        Title: ${title}<br>
        Rating: ${rating}<br>
        -----------------------------------<br>
    `);

    document.getElementById('result4').innerHTML = html || `<p> Không có Post nào có rating > 4 </p>`;
}

const showPostRatingLower = () => {
    const posts = courses.filter(course => course.rating < 4).map(({ id, title, rating }) => `${id} - ${title} - ${rating}<br>`).join('');
    document.getElementById('result5').innerHTML = posts || `<p> Không có Post nào có rating < 4 </p>`;
}

const concatArray = () => {
    const groupArray = [...courses, ...addedCourses]
    console.log(groupArray)
    let html = groupArray.filter((course => course)).map(({id, title, rating}) => `
        <br>
        <strong>Thông tin Post</strong><br>
        ID: ${id}<br>
        Title: ${title}<br>
        Rating: ${rating}<br>
        -----------------------------------<br>
    `).join('');

    document.getElementById('result6').innerHTML = html;
}