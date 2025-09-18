let products = []
let deleteIndex = -1;

updateProductCount();

function addProduct() {
    let input = document.getElementById('add-product');
    let nameProduct = input.value.trim();
    if (!nameProduct) {
        alert('Name product cant be empty');
        return;
    }
    products.push(nameProduct);
    input.value = '';

    displayProduct();
    updateProductCount();
}

function displayProduct() {
    let list = document.getElementById('list-product');
    if (products.length === 0) {
        list.innerHTML = '<div class="empty-state">No products added yet</div>';
        return;
    }

    list.innerHTML = '';

    products.forEach((product, index) => {
        list.innerHTML += `
                <div class="product-item">
                    <p>${product}</p>
                    <div class="product-actions">
                        <button class="edit" onclick="editProduct(${index})">Edit</button>
                        <button class="delete" onclick="deleteProduct(${index})">Delete</button>
                    </div>
                </div>
            `
    });
}

function editProduct(index) {
    let newNameProduct = prompt('Nhập tên mới', products[index]);
    if (newNameProduct && newNameProduct !== '') {
        products[index] = newNameProduct.trim();
        displayProduct();
    }
}

function deleteProduct(index) {
    deleteIndex = index;
    document.getElementById('confirm-message').textContent = `Do you really want to delete ${products[index]}?`;
    document.getElementById('confirmation-dialog').style.display = 'flex';
}

function confirmDelete() {
    if (deleteIndex !== -1) {
        products.splice(deleteIndex, 1);
        deleteIndex = -1;
        displayProduct();
        updateProductCount();
    }
    hideDeleteConfirmation();
}

function cancelDelete() {
    deleteIndex = -1;
    hideDeleteConfirmation()
}

function hideDeleteConfirmation() {
    document.getElementById('confirmation-dialog').style.display = 'none';
}

function updateProductCount() {
    document.getElementById('num-of-product').textContent = products.length === 1 ? '1 Product' : `${products.length} Products`;
}

document.getElementById('confirmation-dialog').addEventListener('click', function (e) {
    if (e.target === this) {
        cancelDelete();
    }
});