import React from 'react';
import styles from './list.module.css';

function ProductList({ products }) {
    const formatPrice = (price) => {
        return new Intl.NumberFormat('vi-VN', {
            style: 'currency',
            currency: 'VND'
        }).format(price);
    };

    const formatDate = (date) => {
        return new Intl.DateTimeFormat('vi-VN', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        }).format(date);
    };

    return (
        <>
            <div className="product-list">
                <h1>Danh Sách Sản Phẩm</h1>
                <table className={styles.table}>
                    <thead>
                    <tr className={styles.tr}>
                        <th className={styles.th}>ID</th>
                        <th className={styles.th}>Tên</th>
                        <th className={styles.th}>Giá</th>
                        <th className={styles.th}>Ngày đặt</th>
                        <th className={styles.th}>Mô tả</th>
                    </tr>
                    </thead>
                    <tbody>
                    {products.map((product) => (
                        <tr key={product.id}>
                            <td className={styles.td}>{product.id}</td>
                            <td className={styles.td}>{product.name}</td>
                            <td className={styles.td}>{formatPrice(product.price)}</td>
                            <td className={styles.td}>{formatDate(product.orderDate)}</td>
                            <td className={styles.td}>{product.description}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default ProductList;