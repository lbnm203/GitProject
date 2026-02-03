import {useIncrement} from "./useIncrement.jsx";

export const Counter1 = () => {
    const [count, setCount] = useIncrement(1);

    return (
        <>
            <div className="counter">
                <h3>Counter + 1: {count}</h3>
                <button onClick={setCount}> + 1 </button>
                <br/><br/>
            </div>
        </>
    )

}