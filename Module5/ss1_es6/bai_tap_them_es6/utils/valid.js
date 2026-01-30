export const checkNumber = value => {
    return value !== null && value !== "" && !Number.isNaN(Number(value));
};

export const checkPrimeNumber = value => {
    if (value < 2) return false;

    for (let i = 2; i <= Math.sqrt(value); i++) {
        if (value % i === 0) {
            return false;
        }
    }
    return true;
}

export const checkFibonacci = value => {
    if (value <= 1) return value;

    let cur = 0
    let value1 = 0;
    let value2 = 1;

    for (let i = 2; i < value; i++) {
        cur = value1 + value2;
        value1 = cur;
        value2 = value1;
    }
    return cur;
}