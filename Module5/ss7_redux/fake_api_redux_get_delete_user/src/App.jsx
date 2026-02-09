import { useState } from 'react'
import {ToastContainer} from "react-toastify";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {UserList} from "./component/UserList.jsx";
import 'bootstrap/dist/css/bootstrap.css'
import {UserCreate} from "./component/UserCreate.jsx";


function App() {


  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<UserList />} />
                <Route path="/create" element={<UserCreate />} />
            </Routes>
        </BrowserRouter>
        <ToastContainer />
    </>
  )
}

export default App
