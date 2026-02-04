import { useState } from 'react'

import {MedicalForm} from "./component/MedicalForm.jsx";
import {ToastContainer} from "react-toastify";

function App() {

  return (
    <>
      <MedicalForm></MedicalForm>
        <ToastContainer></ToastContainer>
    </>
  )
}

export default App
