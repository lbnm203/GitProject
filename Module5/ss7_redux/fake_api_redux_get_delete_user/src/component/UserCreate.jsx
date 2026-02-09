import {Button, Container, Form, Spinner} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import {toast} from 'react-toastify';
import {Formik} from "formik";
import * as Yup from "yup";
import * as userService from "../service/UserService.js";

export const UserCreate = () => {
    const navigate = useNavigate();
    const users = {
        name: "",
        email: "",
        website: ""
    }

    const validUser = Yup.object({
        name: Yup.string().required("Please enter name"),
        email: Yup.string().required("Please enter email").email("Please enter a valid email address"),
        website: Yup.string().required("Please enter link website")
    })

    const onAddUser = async (values, helper) => {
        await userService.addUser(values);
        toast.success("User added successfully.");
        helper.setSubmitting(false);
        navigate("/");
    }

    return (
        <>
            <Container className={"mt-5"}>
                <h2 className={"mb-4"}>Contact Form</h2>
                <Formik initialValues={users} onSubmit={onAddUser} validationSchema={validUser}>
                    {({handleSubmit, handleChange, handleBlur, isSubmitting, isValid, errors, touched, values}) => (
                        <Form onSubmit={handleSubmit}>
                            <Form.Group className={"mb-3"}>
                                <Form.Label>Name</Form.Label>
                                {touched.name && errors.name && (
                                    <span className="text-danger">{errors.name}</span>
                                )}
                                <Form.Control type="text"
                                              name="name"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.name}
                                              isValid={touched.name && errors.name}/>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Email</Form.Label>
                                {touched.email && errors.email && (
                                    <span className="text-danger">{errors.email}</span>
                                )}
                                <Form.Control type="text"
                                              name="email"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.email}
                                              isValid={touched.email && errors.email}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label>Website</Form.Label>
                                {touched.website && errors.website && (
                                    <span className="text-danger">{errors.website}</span>
                                )}
                                <Form.Control type="text"
                                              name="website"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.website}
                                              isValid={touched.website && errors.website}/>
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