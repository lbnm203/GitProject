export const checkNumber = value => {
    return value !== null && value !== "" && !Number.isNaN(Number(value));
}

export const checkString = value => {
    return typeof value === 'string' && value.trim() !== "";
}