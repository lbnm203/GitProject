import {Button, Container, Form, Spinner} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {toast} from 'react-toastify';
import {Formik} from "formik";
import * as Yup from "yup";
import * as bookService from "../service/BookService.js";

export const BookCreate = () => {
    const navigate = useNavigate();
    const books = {
        title: "",
        quantity: 1,
    }

    const validBook = Yup.object({
        title: Yup.string().required("Please enter title"),
        quantity: Yup.number().required("Please enter quantity"),
    })

    const onAddBook = async (values, helper) => {
        await bookService.addBook(values);
        toast.success("Book added successfully.");
        helper.setSubmitting(false);
        navigate("/books");
    }

    return (
        <>
            <Container className={"mt-5"}>
                <h2 className={"mb-4"}>Contact Form</h2>
                <Formik initialValues={books} onSubmit={onAddBook} validationSchema={validBook}>
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
                                              isValid={touched.title && errors.title}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Quantity</Form.Label>
                                {touched.quantity && errors.quantity && (
                                    <span className="text-danger">{errors.quantity}</span>
                                )}
                                <Form.Control type="text"
                                              name="quantity"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.quantity}
                                              isValid={touched.quantity && errors.quantity}/>
                            </Form.Group>
                            {isSubmitting
                                ? <Spinner className={"my-2"} animation={"border"} variant={"primary"}></Spinner>
                                : <Button className={"my-2"} disabled={!isValid} variant={"primary"} type={"submit"}> Submit </Button>

                            }
                        </Form>
                    )}
                </Formik>
            </Container>
        </>
    )
}