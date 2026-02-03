import React, { useState } from "react";

export const Counter = () => {
    const [count, setCount] = useState(0);
    const [count2, setCount2] = useState(0);

    const increment = () => {
        setCount(prev => prev + 1);
    }

    const increment2 = () => {
        setCount2(prev => prev + 2);
    }

    return (
        <>
            <div className="counter">
                <h3>Counter + 1: {count}</h3>
                <button onClick={increment}> + 1 </button>
                <br/><br/>
                <h3>Counter + 2: {count2}</h3>
                <button onClick={increment2}> + 2 </button>
            </div>
        </>
    )
}