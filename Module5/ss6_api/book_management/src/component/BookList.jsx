import React, {useState , useEffect} from 'react'

import * as bookService from "../service/BookService.js";
import {Button, Container, Table, Modal, Spinner} from "react-bootstrap";
import {Link} from "react-router-dom";
import {toast} from "react-toastify";
import {BookDelete} from "./BookDelete.jsx";

export const BookList = () => {
    const id = 1;

    const [books, setBooks] = useState([])
    const [showModal, setShowModal] = useState(false);
    const [selectedBook, setSelectedBook] = useState(null);
    const [deleting, setDeleting] = useState(false);

    useEffect(() => {
        getAll()
    }, [])

    const getAll = async () => {
        const temp = await bookService.getAllBooks();
        setBooks(temp);
    }

    const handleShowDeleteModal = (book) => {
        setSelectedBook(book);
        setShowModal(true);
    }

    const handleCloseModal = () => {
        setShowModal(false);
        setSelectedBook(null);
    }

    const handleDelete = async () => {
        setDeleting(true);
        const result = await bookService.deleteBook(selectedBook.id);
        if (result) {
            toast.success("Xóa sách thành công!");
            setShowModal(false);
            setSelectedBook(null);
            await getAll();
        } else {
            toast.error("Xóa sách thất bại!");
        }
        setDeleting(false);
    }

    return (
        <>
            <Container className="mt-5">
                <Button variant={"primary"}><Link className={"text-decoration-none fw-bold text-white"} to="/books/create"> Create</Link></Button>
                <Table className="mt-4">
                    <thead>
                    <tr className={"text-center"}>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {books.length === 0 ?
                        <tr>
                            <td colSpan="4" className="text-center">Không có dữ liệu</td>
                        </tr> :
                        books.map((book) => (
                            <tr key={book.id} className={"text-center"}>
                                <td>{book.id}</td>
                                <td>{book.title}</td>
                                <td>{book.quantity}</td>
                                <td className={"d-flex gap-2 justify-content-center"}>
                                    <Button variant={"success"}><Link className={"text-decoration-none fw-bold text-white"} to={`/books/edit/${book.id}`}> Edit </Link></Button>
                                    <Button variant={"danger"} onClick={() => handleShowDeleteModal(book)}> Delete </Button>
                                </td>
                            </tr>
                        ))
                    }
                    </tbody>
                </Table>
            </Container>
            <BookDelete show={showModal} handleClose={handleCloseModal} handleDelete={handleDelete} book={selectedBook} deleting={deleting}/>
        </>
    )
}
