import * as Yup from 'yup';
import {Form, Button, Container, Spinner} from "react-bootstrap";
import {Formik} from "formik";
import {toast} from "react-toastify"
import 'bootstrap/dist/css/bootstrap.css'

export const SubmitForm = () => {
    const forms = {
        name: "",
        email: "",
        phone: "",
        message: "",
    }

    const validForm = Yup.object({
        name: Yup.string()
            .required(' không được để trống'),
        email: Yup.string()
            .email(" phải đúng định dạng, VD: user@gmail.com")
            .required(" không được để trống"),
        phone: Yup.string()
            .matches(/^[0-9]{10}$/, "Số điện thoại phải gồm 10 chữ số")
            .required(" không được để trống"),
        message: Yup.string()
            .required(" không được để trống"),
    })

    const onSubmitForm = (values, form) => {
        setTimeout(() => {
            toast.success("Submit thành công!")
            form.setSubmitting(false)
        }, 3000);
    }

    return (
        <>
            <Container className={"mt-5"}>
                <h2 className={"mb-4"}>Contact Form</h2>
                <Formik initialValues={forms} onSubmit={onSubmitForm} validationSchema={validForm}>
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
                                <Form.Group>
                                    <Form.Label>Phone</Form.Label>
                                    {touched.phone && errors.phone && (
                                        <span className="text-danger">{errors.phone}</span>
                                    )}
                                    <Form.Control type="text"
                                                  name="phone"
                                                  onChange={handleChange}
                                                  onBlur={handleBlur}
                                                  value={values.phone}
                                                  isValid={touched.phone && errors.phone}/>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Message</Form.Label>
                                    {touched.message && errors.message && (
                                        <span className="text-danger">{errors.message}</span>
                                    )}
                                    <Form.Control as="textarea"
                                                  name="message"
                                                  onChange={handleChange}
                                                  onBlur={handleBlur}
                                                  value={values.message}
                                                  isValid={touched.message && errors.message}/>
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