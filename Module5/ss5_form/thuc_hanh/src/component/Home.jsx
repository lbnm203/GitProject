import React, { useState } from 'react';

export const Form = () => {
    const [state, setState] = useState({
        username: "",
        age: null,
        dob: null,
        errormessage: ""
    });

    const handleChange = (e) => {
        let name = e.target.name;
        let value = e.target.value;
        let errormessage = "";

        if (name === "age") {
            if (value !== "" && !Number(value)) {
                errormessage += "Please enter a age with number";
            }
        }
        setState({ ...state, [name]: value, errormessage: errormessage });
    }

    return (
        <>
            <form>
                <h1>
                    Hello {state.username} {state.age}
                </h1>
                <p>Enter your name:</p>
                <input type="text" name="username" onChange={handleChange} />
                <p>Enter your age:</p>
                <input type="text" name="age" onChange={handleChange} />
                {state.errormessage}
            </form>
        </>
    )
}
