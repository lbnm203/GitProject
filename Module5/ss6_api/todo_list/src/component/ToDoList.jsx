import React, {useEffect, useState} from "react";
import { toast } from "react-toastify";
import axios from "axios";
import {Container, ListGroup, Form, Button, Card} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css'

export const ToDoList = () => {
    const [todos, setTodos] = useState([]);
    const [newTodos, setNewTodos] = useState("");

    useEffect(() => {
        axios
            .get("http://localhost:8080/todos")
            .then((res) => {
                setTodos(res.data);
            })
            .catch((err) => {
                toast.error(err.message);
            });
    }, []);

    const handleAddTodo = () => {
        if (newTodos.trim()) {
            const todo = { text: newTodos };
            axios.post("http://localhost:8080/todos", todo)
                .then((res) => {
                    setTodos([...todos, res.data]);
                    setNewTodos("");
                    toast.success("Added successfully!");
                })
                .catch((err) => {
                    toast.error("Failed to add todo: " + err.message);
                });
        }
    };

    const handleDeleteTodo = (id) => {
        axios.delete(`http://localhost:8080/todos/${id}`)
            .then(() => {
                setTodos(todos.filter(todo => todo.id !== id));
                toast.success("Deleted successfully!");
            })
            .catch((err) => {
                toast.error("Failed to delete todo: " + err.message);
            });
    };

    return (
        <>
            <Container className="d-flex flex-column align-items-center mt-5">
                <Card style={{ width: "400px" }} className="p-3 shadow">
                    <h1>ToDo List</h1>
                    <div className="d-flex mb-3 gap-2">
                        <Form.Control
                            type="text"
                            value={newTodos}
                            onChange={(e) => setNewTodos(e.target.value)}/>

                        <Button variant="primary" onClick={handleAddTodo}> Submit </Button>
                    </div>
                    <ListGroup>
                        {todos.map(todo => (
                            <ListGroup.Item key={todo.id} className={"mb-2 border-2 rounded-3 d-flex justify-content-between"}>
                                {todo.text}
                                <Button variant={"danger"} size={"sm"} onClick={() => handleDeleteTodo(todo.id)}> Delete </Button>
                            </ListGroup.Item>
                        ))}
                    </ListGroup>
                </Card>
            </Container>
        </>
    )
}