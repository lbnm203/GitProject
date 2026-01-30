import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'
import SignInForm from "./component/FormSignIn.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
        <SignInForm />
    </>
  )
}

export default App
