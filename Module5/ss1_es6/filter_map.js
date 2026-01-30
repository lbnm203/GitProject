import { checkNumber, checkPrimeNumber } from './utils/valid.js';

export const primeNumber = () => {
    const numbers = parseInt(document.getElementById("numberInput").value);

    if (!checkNumber(numbers)) {
        document.getElementById('result').innerHTML = "Nhập đúng định dạng số"
    } else if (!checkPrimeNumber(numbers)) {
        document.getElementById('result').innerHTML = `${numbers} không phải là số nguyên tố`;
    } else {
        document.getElementById('result').innerHTML = `${numbers} là số nguyên tố`
    }
}

export const filterPrimeNumberInArray = () => {
    const numbers = document.getElementById("arrayInput").value.trim().split(/\s+/);

    const primeNumber = numbers.map(Number).filter(n => checkNumber(n) && checkPrimeNumber(n));

    document.getElementById('result2').innerHTML =
        primeNumber.length > 0
            ? `Các số nguyên tố: ${primeNumber.join(", ")}` : `Không có số nguyên tố nào`;
}

