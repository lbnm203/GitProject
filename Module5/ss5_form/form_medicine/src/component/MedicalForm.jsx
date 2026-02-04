import * as Yup from 'yup';
import { toast } from 'react-toastify';
import {Formik} from "formik";
import {Button, Container, Form, Spinner} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.css'

export const MedicalForm = () => {
    const medicalInfo = {
        name: "",
        identity: "",
        yob: 0,
        gender: false,
        national: "",
        posBusiness: "",
        department: "",
        isHaveIsurance: false,
        country: "",
        district: "",
        ward: "",
        address: "",
        phone: "",
        email: "",
    }

    const validMedicalInfo = Yup.object({
        name: Yup.string()
            .required(" không được để trống"),
        identity: Yup.string()
            .required(" không được để trống"),
        yob: Yup.number()
            .typeError(" phải là số")
            .required(" không được để trống")
            .min(1901, " phải lớn hơn 1900")
            .max(new Date().getFullYear(), " không hợp lệ"),
        national: Yup.string()
            .required(" không được để trống"),
        country: Yup.string()
            .required(" không được để trống"),
        district: Yup.string()
            .required(" không được để trống"),
        ward: Yup.string()
            .required(" không được để trống"),
        address: Yup.string()
            .required(" không được để trống"),
        phone: Yup.string()
            .required(" không được để trống"),
        email: Yup.string()
            .email(" phải đúng định dạng, VD: user@gmail.com")
            .required(" không được để trống"),
    })

    const onSubmitMedical = (values, helper) => {
        setTimeout(() => {
            toast.success(" Submit thành công!")
            helper.setSubmitting(false);
        }, 3000)
    }

    return (
        <>
            <Container className={"mt-5"}>
                <Formik  initialValues={medicalInfo} onSubmit={onSubmitMedical} validationSchema={validMedicalInfo}>
                    {({handleSubmit, handleChange, handleBlur, isSubmitting, isValid, errors, touched, values}) => (
                        <Form onSubmit={handleSubmit}>
                            <h3 className={"mb-4"}> Tờ khai y tế </h3>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Họ tên</Form.Label>
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
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Số hộ chiếu / CMND</Form.Label>
                                {touched.identity && errors.identity && (
                                    <span className="text-danger">{errors.identity}</span>
                                )}
                                <Form.Control type="text"
                                              name="identity"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.identity}
                                              isValid={touched.identity && errors.identity}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Năm sinh</Form.Label>
                                {touched.yob && errors.yob && (
                                    <span className="text-danger">{errors.yob}</span>
                                )}
                                <Form.Control type="text"
                                              name="yob"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.yob}
                                              isValid={touched.yob && errors.yob}/>
                            </Form.Group>
                            <Form.Group className={"mb-3 d-flex gap-3 py-2"}>
                                <Form.Label className={"fw-bold"}>Giới tính</Form.Label>
                                <Form.Check
                                    type="radio"
                                    label="Nam"
                                    name="gender"
                                    value="male"
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                    checked={values.gender === "male"}
                                />

                                <Form.Check
                                    type="radio"
                                    label="Nữ"
                                    name="gender"
                                    value="female"
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                    checked={values.gender === "female"}
                                />
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Quốc tịch</Form.Label>
                                {touched.national && errors.national && (
                                    <span className="text-danger">{errors.national}</span>
                                )}
                                <Form.Control type="text"
                                              name="national"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.national}
                                              isValid={touched.national && errors.national}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Công ty làm việc</Form.Label>
                                <Form.Control type="text"
                                              name="posBusiness"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.posBusiness}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Bộ phận làm việc</Form.Label>
                                <Form.Control type="text"
                                              name="department"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.department}/>
                            </Form.Group>
                            <Form.Group className={"mb-3 d-flex gap-3 py-2"}>
                                <Form.Label className={"fw-bold"}>Có thẻ bảo hiểm y tế </Form.Label>
                                <Form.Check
                                    type="checkbox"
                                    name="isHaveIsurance"
                                    value="isHaveIsurance"
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />
                            </Form.Group>

                            <h3 className={"mb-4"}> Địa chỉ liên lạc tại Việt Nam </h3>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Tỉnh thành</Form.Label>
                                {touched.country && errors.country && (
                                    <span className="text-danger">{errors.country}</span>
                                )}
                                <Form.Control type="text"
                                              name="country"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.country}
                                              isValid={touched.country && errors.country}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Quận / Huyện</Form.Label>
                                {touched.district && errors.district && (
                                    <span className="text-danger">{errors.district}</span>
                                )}
                                <Form.Control type="text"
                                              name="district"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.district}
                                              isValid={touched.district && errors.district}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Phường / Xã</Form.Label>
                                {touched.ward && errors.ward && (
                                    <span className="text-danger">{errors.ward}</span>
                                )}
                                <Form.Control type="text"
                                              name="ward"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.ward}
                                              isValid={touched.ward && errors.ward}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Số nhà, phố, tổ dân phố / thôn / đội</Form.Label>
                                {touched.address && errors.address && (
                                    <span className="text-danger">{errors.address}</span>
                                )}
                                <Form.Control type="text"
                                              name="address"
                                              onChange={handleChange}
                                              onBlur={handleBlur}
                                              value={values.address}
                                              isValid={touched.address && errors.address}/>
                            </Form.Group>
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Số điện thoại</Form.Label>
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
                            <Form.Group className={"mb-3"}>
                                <Form.Label className={"fw-bold"}>Email</Form.Label>
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
                                <Form.Label className={"fw-bold"}>Trong vòng 14 ngày qua, Anh/Chị có đến quốc gia/vùng lãnh thổ nào (Có thể đi qua nhiều quốc gia)</Form.Label>
                                <Form.Control as="textarea"
                                              name="country"/>
                            </Form.Group>
                            <Form.Group className={"mb-3 py-2"}>
                                <Form.Label className={"fw-bold"}>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?</Form.Label>
                                <Form.Check
                                    type="checkbox"
                                    label="Sốt"
                                    onChange={handleChange}
                                />
                                <Form.Check
                                    type="checkbox"
                                    label="Ho"
                                    onChange={handleChange}
                                />
                                <Form.Check
                                    type="checkbox"
                                    label="Khó thở"
                                    onChange={handleChange}
                                />
                                <Form.Check
                                    type="checkbox"
                                    label="Viêm phổi"
                                    onChange={handleChange}
                                />
                                <Form.Check
                                    type="checkbox"
                                    label="Đau họng"
                                    onChange={handleChange}
                                />
                                <Form.Check
                                    type="checkbox"
                                    label="Mệt mỏi"
                                    onChange={handleChange}
                                />
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