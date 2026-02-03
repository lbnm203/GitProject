import {useIncrement} from "./useIncrement.jsx";

export const Counter2 = () => {
    const [count, setCount] = useIncrement(2);

    return (
        <>
            <div className="counter">
                <h3>Counter + 2: {count}</h3>
                <button onClick={setCount}> + 2 </button>
            </div>
        </>
    )
}