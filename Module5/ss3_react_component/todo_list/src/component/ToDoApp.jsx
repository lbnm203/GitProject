import { useState } from "react";

export const ToDoApp = () => {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState("");

    const handleAddTodo = () => {
        if (newTodo.trim()) {
            setTodos([...todos, { id: Date.now(), text: newTodo }]);
            setNewTodo("");
        }
    };

    const handleDeleteTodo = (id) => {
        setTodos(todos.filter(todo => todo.id !== id));
    };

    return (
        <>
            <div className="container justify-content-center align-items-center ">
                <h1>ToDo List</h1>
                <div className={"d-flex gap-3"}>
                    <input type="text" value={newTodo} onChange={(e) => setNewTodo(e.target.value)} />
                    <button onClick={handleAddTodo}> Add </button>
                </div>
                <ul>
                    {todos.map(todo => (
                        <>
                            <div className={"d-flex gap-3 py-2"}>
                                <li key={todo.id}>
                                    {todo.text}
                                </li>
                                <button onClick={() => handleDeleteTodo(todo.id)}> Delete </button>
                            </div>
                        </>
                    ))}
                </ul>
            </div>
        </>
    );
}