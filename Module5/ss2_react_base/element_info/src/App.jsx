import React, { useState } from 'react'
import './App.css'
import ProductList from "./component/ProductList.jsx";

function App() {
    const [count, setCount] = useState(0)
    const products = [
        {
            id: 1,
            name: "Bàn phím cơ RK61",
            price: 890000,
            orderDate: new Date("2026-01-01"),
            description: "Bàn phím cơ 61 phím, switch đỏ, có LED RGB"
        },
        {
            id: 2,
            name: "Chuột Logitech G102",
            price: 350000,
            orderDate: new Date("2026-01-03"),
            description: "Chuột gaming giá rẻ, cảm biến quang học 8000 DPI"
        },
        {
            id: 3,
            name: "Tai nghe HyperX Cloud Stinger",
            price: 690000,
            orderDate: new Date("2026-01-05"),
            description: "Tai nghe chụp tai, âm thanh vòm 7.1"
        },
        {
            id: 4,
            name: "Màn hình Dell 24 inch",
            price: 3200000,
            orderDate: new Date("2026-01-07"),
            description: "Màn hình Full HD, tấm nền IPS, 75Hz"
        },
        {
            id: 5,
            name: "Laptop Asus Vivobook",
            price: 14500000,
            orderDate: new Date("2026-01-10"),
            description: "Laptop mỏng nhẹ cho sinh viên, CPU i5"
        },
        {
            id: 6,
            name: "Ổ cứng SSD 512GB",
            price: 1200000,
            orderDate: new Date("2026-01-12"),
            description: "SSD chuẩn NVMe, tốc độ đọc ghi cao"
        },
        {
            id: 7,
            name: "USB 64GB Kingston",
            price: 180000,
            orderDate: new Date("2026-01-15"),
            description: "USB 3.2, nhỏ gọn, tiện mang theo"
        },
        {
            id: 8,
            name: "Webcam Logitech C920",
            price: 2100000,
            orderDate: new Date("2026-01-18"),
            description: "Webcam Full HD 1080p cho học online, họp Zoom"
        },
        {
            id: 9,
            name: "Ghế công thái học",
            price: 2750000,
            orderDate: new Date("2026-01-20"),
            description: "Ghế xoay văn phòng, hỗ trợ lưng và cổ"
        },
        {
            id: 10,
            name: "Bàn làm việc gỗ MDF",
            price: 1500000,
            orderDate: new Date("2026-01-25"),
            description: "Bàn học và làm việc kích thước 120x60cm"
        }
    ];
    return (
        <>
            <ProductList products={products} />
        </>
    )
}

export default App
