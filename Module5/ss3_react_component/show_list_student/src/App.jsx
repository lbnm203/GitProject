import { useState } from 'react'
import StudentList from "./component/StudentList.jsx";


function App() {
  const students = [
      {
          id: 1,
          name: 'Nguyễn Bá An',
          age: 18,
          address: 'Hà Nội'
      },
      {
          id: 2,
          name: 'Lê Nhật Tiến',
          age: 16,
          address: 'Hồ Chí Minh'
      },
      {
          id: 3,
          name: 'Lê Nhật Quân',
          age: 21,
          address: 'Hồ Chí Minh'
      }
  ]

  return (
    <>
        <StudentList students={students}></StudentList>
    </>
  )
}

export default App
