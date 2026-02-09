import React from 'react';
import { Modal, Button, Spinner } from 'react-bootstrap';

export const DeleteModal = ({ show, handleClose, handleDelete, infoUser, deleting }) => {
    return (
        <Modal show={show} onHide={handleClose} centered>
            <Modal.Header closeButton>
                <Modal.Title>Xác nhận xóa người dùng</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {infoUser && (
                    <div>
                        <p>Bạn có chắc chắn muốn xóa người dùng sau?  sau?</p>
                        <div className="mt-3">
                            <strong>ID </strong> {infoUser.id}<br />
                            <strong>Tên </strong> {infoUser.name}
                        </div>
                    </div>
                )}
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose} disabled={deleting}>
                    Hủy
                </Button>
                <Button
                    variant="danger"
                    onClick={handleDelete}
                    disabled={deleting || !infoUser}
                >
                    {deleting ? (
                        <>
                            <Spinner
                                as="span"
                                animation="border"
                                size="sm"
                                role="status"
                                aria-hidden="true"
                                className="me-2"
                            />
                            Đang xóa...
                        </>
                    ) : (
                        'Xóa'
                    )}
                </Button>
            </Modal.Footer>
        </Modal>
    );
}
