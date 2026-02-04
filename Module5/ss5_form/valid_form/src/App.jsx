import { useState } from 'react'

// import './App.css'
import {SubmitForm} from "./component/SubmitForm.jsx";
import { ToastContainer } from 'react-toastify';

function App() {

  return (
    <>
      <SubmitForm></SubmitForm>
        <ToastContainer />
    </>
  )
}

export default App
