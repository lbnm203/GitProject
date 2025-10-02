let cart = JSON.parse(localStorage.getItem("cart")) || [];

function showListCart() {
    let cartBody = document.getElementById('cart-body');
    let total = 0;
    cartBody.innerHTML = '';

    cart.forEach((item, index) => {
        let itemTotal = item.price * item.quantity;
        total += itemTotal;

        cartBody.innerHTML += `
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${itemTotal}</td>
                <td>
                    <div class="add-sub-item">
                      <button onclick="subItem(${index})">-</button>
                      <button onclick="addItem(${index})">+</button>   
                    </div>
                </td>
            </tr>
        `;
    });

    document.getElementById('cart-total').innerText = total;
}

function checkOut() {
    let name = document.getElementById('customer-name').value;
    let address = document.getElementById('customer-address').value;
    let phone = document.getElementById('customer-phone').value;

    if (!name || !address || !phone) {
        alert('Hãy nhập đầy đủ thông tin')
        return;
    }

    alert(`Thanh toán thành công, Cảm ơn \`${name}\` đã mua hàng`);
    localStorage.removeItem('cart');
    window.location.href = 'index.html';
}

function returnPage() {
    window.location.href = 'index.html';
}

function addItem(index) {
    if (cart[index].quantity < cart[index].stock) {
        cart[index].quantity++;
        localStorage.setItem("cart", JSON.stringify(cart));
    } else {
        alert('Đã hết số lượng mặt hàng')
    }
    showListCart();
}

function subItem(index) {
    if (cart[index].quantity > 1) {
        cart[index].quantity--;
    } else {
        cart.splice(index, 1);
    }
    localStorage.setItem("cart", JSON.stringify(cart));
    showListCart();
}

showListCart();