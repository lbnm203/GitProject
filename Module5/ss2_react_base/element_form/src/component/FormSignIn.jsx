import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import React from 'react';

export function SignInForm () {
    return (
        <>
            <div className="container mt-4">
                <div className="row justify-content-center align-items-center">
                    <div className="col-md-4 border p-5 shadow rounded-3">
                        <div className="text-center mb-4">
                            <img 
                                src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/2560px-Bootstrap_logo.svg.png" 
                                alt="Bootstrap Logo" 
                                width="72" 
                                height="57" 
                            />
                            <h3 className="mt-3">Please Sign In</h3>
                        </div>

                        <Form>
                            <Form.Group className="mb-3" controlId="formEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control 
                                    type="email" 
                                    placeholder="Enter email" 
                                    required 
                                />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control 
                                    type="password" 
                                    placeholder="Password" 
                                    required 
                                />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formCheckbox">
                                <Form.Check type="checkbox" label="Remember me" />
                            </Form.Group>

                            <Button variant="primary" type="submit" className="w-100">
                                Sign In
                            </Button>
                        </Form>
                        </div>
                    </div>
                </div>

            {/* CÁCH 2: Sử dụng HTML thuần với Bootstrap classes */}
            {/*
            <div className="container d-flex align-items-center text-center">
                <div className="form-signin">
                    <form onSubmit={handleSubmit}>
                        <img className="mb-4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/2560px-Bootstrap_logo.svg.png" alt="" width="72" height="57" />
                        <h3 className="mb-5">Please Sign In</h3>

                        <label htmlFor="email" className="visually-hidden">Email</label>
                        <input type="email" id="email" className="form-control" placeholder="Email address" required />

                        <label htmlFor="password" className="visually-hidden">Password</label>
                        <input type="password" id="password" className="form-control" placeholder="Password" required />

                        <button className="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
            */}
        </>
    );
}

export default SignInForm;
