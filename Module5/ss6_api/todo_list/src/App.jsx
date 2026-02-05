import { useState } from 'react'
import {ToDoList} from "./component/ToDoList.jsx";
import {ToastContainer} from "react-toastify";

function App() {
  return (
    <>
      <ToDoList></ToDoList>
        <ToastContainer></ToastContainer>
    </>
  )
}

export default App
