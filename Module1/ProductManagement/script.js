let product1 = new Product('1', "ZFold", '1200', '15','Còn Hàng');
let product2 = new Product('2','Iphone 12','1500','20', 'Còn Hàng');
let product3 = new Product('3','ROG Phone','2000','25','Còn Hàng');
let arr =[product1, product2, product3];
let manage = new ProductManagement(arr);

function addProduct() {
    let id = document.getElementById('id').value;
    let name = document.getElementById('name').value;
    let price = document.getElementById('price').value;
    let quantity = document.getElementById('quantity').value;
    // let status = document.getElementById('status').value;
    let status;

    if (!manage.checkNumber(price) || !manage.checkNumber(quantity)) {
        alert('Hãy nhập đúng định dạng số')
        return;
    }

    if (price < 1 || quantity < 1) {
        alert('Hãy nhập giá trị lớn hơn 0')
        return;
    }

    if(manage.checkDuplicate(id)) {
        alert('ID đã tồn tại, hãy nhập ID khác')
        return;
    }

    if(manage.checkDuplicateName(name)) {
        alert('Tên mặt hàng đã tồn tại, hãy nhập tên mặt hàng khác')
        return;
    }

    if (id.trim() === '' ||
        name.trim() === '' ||
        price.trim() === '' ||
        quantity.trim() === ''
        // status.trim() === 'status'
    ) {
        alert('Vui lòng nhập hết giá trị, không bỏ trống!')
        return;
    }

    status = (parseInt(quantity) === 0) ? "Hết hàng" : "Còn hàng";
    document.getElementById('status').value = status;

    let product = new Product(id, name, price, quantity, status);

    manage.add(product);
    clear();
    productID = -1;
    manage.showList();
}

function clear() {
    document.getElementById('id').value = '';
    document.getElementById('name').value = '';
    document.getElementById('price').value = '';
    document.getElementById('quantity').value = '';
    document.getElementById('status').value = '';

    document.getElementById('btn-add').style.display = 'inline-block';
    document.getElementById('btn-update').style.display = 'none';
    document.getElementById('id').disabled = false;
}

let productID = -1;
function editProduct(id) {
    let product = manage.findProduct(id);
    document.getElementById('id').value = product.id;
    document.getElementById('name').value = product.name;
    document.getElementById('price').value = product.price;
    document.getElementById('quantity').value = product.quantity;
    document.getElementById('status').value = product.status;
    productID = id;

    document.getElementById('btn-add').style.display = 'none';
    document.getElementById('btn-update').style.display = 'inline-block';
    document.getElementById('id').disabled = true;
}

let deleteIndex = -1;
function deleteProduct(id) {
    deleteIndex = id;
    let product = manage.findProduct(id);
    document.getElementById("confirm-message").innerText =
        `Bạn có chắc muốn xóa sản phẩm "${product.name}" không?`;
    document.querySelector(".dialog-confirm").style.display = "flex";
}

function confirmDelete() {
    if (deleteIndex !== -1) {
        manage.delete(deleteIndex);
        manage.showList();
        deleteIndex = -1;
    }
    document.querySelector(".dialog-confirm").style.display = "none";
}

function cancelDelete() {
    deleteIndex = -1;
    document.querySelector(".dialog-confirm").style.display = "none";
}

function updateProduct() {
    let index = productID;
    let id = document.getElementById('id').value;
    let name = document.getElementById('name').value;
    let price = document.getElementById('price').value;
    let quantity = document.getElementById('quantity').value;
    // let status = document.getElementById('status').value;
    let status;

    if (productID === -1) {
        alert('Bạn chưa chọn mặt hàng để chỉnh sửa')
        return;
    }

    if (!manage.checkNumber(price) || !manage.checkNumber(quantity)) {
        alert('Hãy nhập đúng định dạng số')
        return;
    }

    if (price < 1) {
        alert('Hãy nhập giá trị lớn hơn 0')
        return;
    }

    if (quantity < 0) {
        alert('Số lượng phải >= 0')
        return;
    }

    status = (parseInt(quantity) === 0) ? 'Hết Hàng' : 'Còn Hàng';
    document.getElementById('status').value = status;

    manage.edit(index, id, name, price, quantity, status);
    clear()
    productID = -1;
    manage.showList();
}

function goToCart() {
    window.location.href = 'paying.html';
}

let cart = JSON.parse(localStorage.getItem("cart")) || [];

function addToCart(index) {
    let product = manage.findProduct(index);
    if (product.status === 'Hết Hàng'){
        alert('Mặt hàng này đã hết, hãy chọn mặt hàng khác')
        return;
    }

    let itemExist = cart.find(item => item.id === product.id);
    if (itemExist) {
        if (itemExist.quantity < itemExist.stock) {
            itemExist.quantity++;
        } else {
            alert('đã hết số lượng mặt hàng')
        }
    } else {
        cart.push({...product, quantity: 1, stock: product.quantity});
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    alert("Đã thêm vào giỏ hàng!");
}

manage.showList(arr)
document.getElementById('btn-update').style.display = 'none';
document.getElementById('status').style.display = 'none';

