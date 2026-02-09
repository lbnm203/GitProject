import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Container, Table, Spinner } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { getUsers, deleteUser } from '../redux/action';
import {DeleteModal} from "./DeleteModal.jsx";

export const UserList = () => {
    const dispatch = useDispatch();
    
    // Lấy data từ Redux store
    const { users, loading, deleting } = useSelector(state => state.userState);
    
    const [showModal, setShowModal] = useState(false);
    const [selectedUser, setSelectedUser] = useState(null);

    // Handler for Get Users button
    const handleGetUsers = () => {
        dispatch(getUsers());
    };

    const handleShowDeleteModal = (user) => {
        setSelectedUser(user);
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
        setSelectedUser(null);
    };

    const handleDelete = () => {
        // Dispatch action DELETE_USER
        dispatch(deleteUser(selectedUser.id));
        setShowModal(false);
        setSelectedUser(null);
    };

    return (
        <>
            <Container className="mt-5">
                <h1 className="mb-4">Quản lý User</h1>
                
                <div className="mb-3">
                    <Button 
                        variant="success" 
                        className="me-2"
                        onClick={handleGetUsers}
                        disabled={loading}
                    >
                        {loading ? 'Loading...' : 'Get users'}
                    </Button>
                    <Button variant="primary">
                        <Link className="text-decoration-none fw-bold text-white" to="/create">
                            Create
                        </Link>
                    </Button>
                </div>
                
                {loading ? (
                    <div className="text-center mt-5">
                        <Spinner animation="border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </Spinner>
                    </div>
                ) : (
                    <Table className="mt-4" striped bordered hover>
                        <thead>
                            <tr className="text-center">
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Website</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {users.length === 0 ? (
                                <tr>
                                    <td colSpan="5" className="text-center">
                                        Không có dữ liệu
                                    </td>
                                </tr>
                            ) : (
                                users.map((user) => (
                                    <tr key={user.id} className="text-center">
                                        <td>{user.id}</td>
                                        <td>{user.name}</td>
                                        <td>{user.email}</td>
                                        <td>{user.website}</td>
                                        <td>
                                            <Button
                                                variant="danger"
                                                onClick={() => handleShowDeleteModal(user)}
                                                disabled={deleting}
                                            >
                                                {deleting ? 'Deleting...' : 'Delete'}
                                            </Button>
                                        </td>
                                    </tr>
                                ))
                            )}
                        </tbody>
                    </Table>
                )}
            </Container>
            
            <DeleteModal
                show={showModal}
                handleClose={handleCloseModal}
                handleDelete={handleDelete}
                infoUser={selectedUser}
                deleting={deleting}
            />
        </>
    );
};
