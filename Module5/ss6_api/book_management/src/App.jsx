import { useState } from 'react'
import {BookList} from "./component/BookList.jsx";
import {ToastContainer} from "react-toastify";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css'
import {BookCreate} from "./component/BookCreate.jsx";
import {BookEdit} from "./component/BookEdit.jsx";

function App() {

  return (
    <>
        <BrowserRouter>
            <Routes>
                <Route path="/books" element={<BookList />} />
                <Route path="/books/create" element={<BookCreate />} />
                <Route path="/books/edit/:id" element={<BookEdit />} />
            </Routes>
        </BrowserRouter>
        <ToastContainer />
    </>
  )
}

export default App
