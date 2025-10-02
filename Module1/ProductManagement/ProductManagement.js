class ProductManagement {
    constructor(arr) {
        this.products = arr;
    }

    showList() {
        let table = '';
        for (let i = 0; i < this.products.length; i++) {
            table += '<tr>';
            table += '<td>' + this.products[i].id + '</td>';
            table += '<td>' + this.products[i].name + '</td>';
            table += '<td>' + this.products[i].price + '</td>';
            table += '<td>' + this.products[i].quantity + '</td>';
            table += '<td>' + this.products[i].status + '</td>';
            table +=
                `<td>
                    <div class="action-buttons">
                        <button onclick="addToCart(${i})">Thêm vào giỏ</button>
                        <button onclick="editProduct(${i})">Chỉnh sửa</button>
                        <button onclick="deleteProduct(${i})">Xóa</button>
                    </div>
                </td>`
        }
        document.getElementById('list-product').innerHTML = table;
    }

    add(product) {
        this.products.push(product);
    }

    delete(id) {
        this.products.splice(id, 1);
    }

    findProduct(id) {
        return this.products[id]
    }

    edit(index, id, name, price, quantity, status) {
        this.products[index].edit(id, name, price, quantity, status);
    }


    checkDuplicate(id) {
        for (let i = 0; i < this.products.length; i++) {
            if (this.products[i].id === id) {
                return true;
            }
        }
        return false;
    }

    checkDuplicateName(name) {
        for (let i = 0; i < this.products.length; i++) {
            if (this.products[i].name === name) {
                return true;
            }
        }
        return false;
    }

    checkNumber(num) {
        if(isNaN(num)) {
            return false;
        } else if (num === '') {
            return false;
        } else {
            return true;
        }
    }

}