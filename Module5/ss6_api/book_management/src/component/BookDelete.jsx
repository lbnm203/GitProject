import React from 'react';
import { Modal, Button, Spinner } from 'react-bootstrap';

export const BookDelete = ({ show, handleClose, handleDelete, book, deleting }) => {
    return (
        <Modal show={show} onHide={handleClose} centered>
            <Modal.Header closeButton>
                <Modal.Title>Xác nhận xóa sách</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {book && (
                    <div>
                        <p>Bạn có chắc chắn muốn xóa sách này?</p>
                        <div className="mt-3">
                            <strong>Tiêu đề:</strong> {book.title}<br />
                            <strong>Số lượng:</strong> {book.quantity}
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
                    disabled={deleting || !book}
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
