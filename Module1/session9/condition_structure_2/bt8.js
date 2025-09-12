function swapCtoF() {
    let doC = parseInt(document.getElementById('doC').value);
    swap = (9 * doC) / 5 + 32
    document.getElementById('b1_result').innerHTML = `Độ F = ${swap}`;
}

function swapMtoFeet() {
    let m = parseFloat(document.getElementById('m').value);
    if (m < 0) {
        document.getElementById('b2_result').innerHTML = 'Vui lòng nhập số mét > 0';
    } else {
        ft = m * 3.2808;
        document.getElementById('b2_result').innerHTML = `Kết quả: ${ft.toFixed(2)} ft`;
    }
}

function areaOfSquares() {
    let a = parseFloat(document.getElementById('a-hv').value);
    if (a < 1) {
        document.getElementById('b3_result').innerHTML = "Hãy nhập độ dài > 0";
    } else {
        s = a * a;
        document.getElementById('b3_result').innerHTML = `Diện tích hình vuông: ${s} cm2`;
    }

}

function areaOfRectangle() {
    let a = parseFloat(document.getElementById('a-hcn').value);
    let b = parseFloat(document.getElementById('b-hcn').value);
    if (b < 1 || a < 1) {
        document.getElementById('b4_result').innerHTML = "Hãy nhập độ dài cạnh > 0"
    } else {
        s = a * b;
        document.getElementById('b4_result').innerHTML = `Diện tích hình chữ nhật: ${s} cm2`
    }
}

function areaOfTriangle() {
    let a = parseFloat(document.getElementById('a-tgv').value);
    let b = parseFloat(document.getElementById('b-tgv').value);
    if (b < 1 || a < 1) {
        document.getElementById('b5_result').innerHTML = "Hãy nhập cạnh > 0";
    } else {
        s = (a / 2) * b;
            document.getElementById('b5_result').innerHTML = `Diện tích tam giác vuông: ${s}cm2` ;
    }
}

function linearEquation() {
    let a = parseInt(document.getElementById('a-b1').value);
    let b = parseFloat(document.getElementById('b-b1').value);

    if (a === 0) {
        if (b === 0) {
            document.getElementById('b6_result').innerHTML = "Phương trình vô số nghiệm";
        } else {
            document.getElementById('b6_result').innerHTML = "Phương trình vô nghiệm";
        }
    } else {
        x = -(b / a);
        document.getElementById('b6_result').innerHTML = `x = ${x}`;

    }
}

function quadraticEquation() {
    let a = parseInt(document.getElementById('a-b2').value);
    let b = parseFloat(document.getElementById('b-b2').value);
    let c = parseFloat(document.getElementById('c-b2').value);
    let delta = b**2 - 4*a*c;

    if (delta === 0) {
        x = -b / 2*a;
        document.getElementById('b7_result').innerHTML = `x = ${x}`;
    } else if (delta > 0) {
        x1 = (-b - Math.sqrt(delta)) / 2*a;
        x2 = (-b + Math.sqrt(delta)) / 2*c;
        document.getElementById('b7_result').innerHTML = `x1 = ${x1} <br> x2 = ${x2}`;
    } else {
        document.getElementById('b7_result').innerHTML = "Phương trình vô nghiệm";
    }
}

function checkAge() {
    let age = parseInt(document.getElementById('age').value);
    if (age > 0 && age < 120) {
        document.getElementById('b8_result').innerHTML = "Là tuổi người";
    } else {
        document.getElementById('b8_result').innerHTML = "Không phải tuổi người";
    }
}

function checkTriangle() {
    let a = parseFloat(document.getElementById('a-tg').value);
    let b = parseFloat(document.getElementById('b-tg').value);
    let c = parseFloat(document.getElementById('c-tg').value);

    if (a <= 0 || b <= 0 || c <= 0) {
        document.getElementById('b9_result').innerHTML = '3 số phải > 0';
    } else if (a + b > c && a + c > b && b + c > a) {
        document.getElementById('b9_result').innerHTML = '3 số là cạnh của một tam giác';
    } else {
        document.getElementById('b9_result').innerHTML = '3 số không phải là cạnh của một tam giác';
    }
}

function costElectric() {
    let soKW = parseInt(document.getElementById('sokw').value);
    let soTien = 0

    if (soKW <= 0) {
        document.getElementById('b10_result').innerHTML = 'Số KW phải > 0'
    } else if (soKW <= 50) {
        soTien = soKW * 1678;
    } else if (soKW <= 100) {
        soTien = 50 * 1678 + (soKW - 50) * 1734;
    } else if (soKW <= 200) {
        soTien = 50 * 1678 + 50 * 1734 + (soKW - 100) * 2014;
    } else if (soKW <= 300) {
        soTien = 50 * 1678 + 50 * 1734 + 100 * 2014 + (soKW - 200) * 2536;
    } else if (soKW <= 400) {
        soTien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + (soKW - 300) * 2834;
    } else {
        soTien = 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 * 2536 + 100 * 2834 + (soKW - 400) * 2927;
    }
    document.getElementById('b10_result').innerHTML = ` Số tiền điện phải trả: ${soTien}`;
}

function taxIncome() {
    let message = ''
    let thuNhap = parseInt(document.getElementById('thu-nhap').value);
    let phuThuoc = parseInt(document.getElementById("phu-thuoc").value) || 0;

    let giamTruBanThan = 11000000;
    let giamTruNguoiPT = phuThuoc * 4400000;

    let thuNhapTinhThue = thuNhap - giamTruBanThan - giamTruNguoiPT;
    if (thuNhapTinhThue <= 0) {
        message += "Không phải nộp Thuế";
    } else if (thuNhapTinhThue <= 5) {
        thueTNCN = thuNhapTinhThue * 0.05;
    } else if (thuNhapTinhThue <= 10) {
        thueTNCN = thuNhapTinhThue * 0.1;
    } else if (thuNhapTinhThue <= 18) {
        thueTNCN = thuNhapTinhThue * 0.15;
    } else if (thuNhapTinhThue <= 32) {
        thueTNCN = thuNhapTinhThue * 0.2;
    } else if (thuNhapTinhThue <= 52) {
        thueTNCN = thuNhapTinhThue * 0.25;
    } else if (thuNhapTinhThue <= 80) {
        thueTNCN = thuNhapTinhThue * 0.3;
    } else {
        thueTNCN = thuNhapTinhThue * 0.35;
    }

    if (message !== "") {
        document.getElementById('b11_result').innerHTML = message;
    } else {
        document.getElementById('b11_result').innerHTML = `Thuế thu nhập cá nhân: ${thueTNCN.toFixed(2)}`;
    }
}

function bankInterest() {
    let tienGoc = parseInt(document.getElementById('tiengoc').value);
    let soThangVay = parseInt(document.getElementById('sothangvay').value);
    let laiXuatHangThang = parseFloat(document.getElementById('lxthang').value);
    let tongTien = tienGoc * Math.pow(1 + (laiXuatHangThang / 100), soThangVay)
    let tienLai = tongTien - tienGoc

    if (tienGoc <= 0 || soThangVay <= 0 || laiXuatHangThang <= 0) {
        document.getElementById('b12_result').innerHTML = "Hãy nhập giá trị > 0";
    } else {
        document.getElementById('b12_result').innerHTML = `Số tiền lãi thu được: ${tienLai.toLocaleString()} VND`
    }
}