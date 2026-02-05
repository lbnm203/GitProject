import {Button, Container, Form, Spinner} from "react-bootstrap";
import {useNavigate, useParams} from "react-router-dom";
import {toast} from 'react-toastify';
import {Formik} from "formik";
import * as Yup from "yup";
import * as bookService from "../service/BookService.js";
import {useEffect, useState} from "react";

export const BookEdit = () => {
    const navigate = useNavigate();
    const { id } = useParams();
    const [book, setBook] = useState(null);
    
    useEffect(() => {
        loadBook();
    }, [id]);

    const loadBook = async () => {
        try {
            const data = await bookService.getBookById(id);
            setBook(data);
        } catch (error) {
            toast.error("Không thể tải thông tin sách");
            navigate("/books");
        }
    };

    const validBook = Yup.object({
        title: Yup.string().required("Please enter title"),
        quantity: Yup.number().required("Please enter quantity"),
    })

    const onUpdateBook = async (values, helper) => {
        const result = await bookService.updateBook(id, values);
        if (result) {
            toast.success("Book updated successfully.");
            navigate("/books");
        } else {
            toast.error("Book update failed.");
        }
        helper.setSubmitting(false);
    }

    if (!book) {
        return (
            <Container className="mt-5">
                <p className="text-danger">Không tìm thấy sách!</p>
            </Container>
        );
    }

    return (
        <>
            <Container className={"mt-5"}>
                <h2 className={"mb-4"}>Edit Book</h2>
                <Formik initialValues={book} onSubmit={onUpdateBook} validationSchema={validBook}>
                    {({handleSubmit, handleChange, handleBlur, isSubmitting, isValid, errors, touched, values}) => (
                        <Form onSubmit={handleSubmit}>
                            <Form.Group className={"mb-3"}>
                                <Form.Label>Title</Form.Label>
                                {touched.title && errors.title && (
                                    <span className="text-danger">{errors.title}</span>
                                )}
                                <Form.Control type="text"
                                              name="title"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.title}
                                              isInvalid={touched.title && errors.title}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Quantity</Form.Label>
                                {touched.quantity && errors.quantity && (
                                    <span className="text-danger">{errors.quantity}</span>
                                )}
                                <Form.Control type="number"
                                              name="quantity"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.quantity}
                                              isInvalid={touched.quantity && errors.quantity}/>
                            </Form.Group>
                            {isSubmitting
                                ? <Spinner className={"my-2"} animation={"border"} variant={"primary"}></Spinner>
                                : <Button className={"my-2"} disabled={!isValid} variant={"primary"} type={"submit"}> Update </Button>

                            }
                        </Form>
                    )}
                </Formik>
            </Container>
        </>
    )
}
