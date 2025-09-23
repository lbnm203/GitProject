const createEmptyTable = (rows, cols) => {
    let table = []
    for (let i = 0; i < rows; i++) {
        table[i] = [];
        for (let j = 0; j < cols; j++) {
            table[i][j] = '';
        }
    }
    return table;
}

const drawTable = (matrix) => {
    let table = "<table border='1px' cellpadding='10px' cellspacing='0'>"
    for (let i = 0; i < matrix.length; i++) {
        table += "<tr>";
        for (let j = 0; j < matrix[i].length; j++) {
            table += `<td onclick="handleClick(${i}, ${j})">${matrix[i][j]}</td>`;
        }
        table += "</tr>";
    }
    table += "</table>";
    return document.getElementById('caro-board').innerHTML = table;
}

const isWin = (matrix, row, col, currentPlayer) => {
    let directs = [
        [0, 1],
        [1, 0],
        [1, 1],
        [1, -1]
    ]

    for (const [dx, dy] of directs) {
        let count = 1;
        let rows = row + dx;
        let cols = col + dy;

        while (rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[0].length && matrix[rows][cols] === currentPlayer) {
            count++;
            rows += dx;
            cols += dy;
        }

        rows = row - dx;
        cols = col - dy;
        while (rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[0].length && matrix[rows][cols] === currentPlayer) {
            count++;
            rows -= dx;
            cols -= dy;
        }

        if (count >= 5) {
            return true;
        }
    }
    return false;
}


let currentPlayer = 'X';
let endGame = false;
const handleClick = (row, col) => {
    if (endGame || matrix[row][col] !== '') {
        return;
    }
    matrix[row][col] = currentPlayer;
    drawTable(matrix);
    if (isWin(matrix, row, col, currentPlayer)) {
        document.getElementById('winner').innerHTML = 'Player ' + currentPlayer + ' Win';
        document.getElementById('alert-turn').hidden = true;
        endGame = true;
        return;
    }
    document.getElementById('alert-turn').innerHTML = 'Player ' + currentPlayer + ' turn';
    document.getElementById('alert-turn').hidden = false;

    currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
}


const resetGame = () => {
    matrix = createEmptyTable(size, size);
    currentPlayer = 'X';
    drawTable(matrix);
    document.getElementById('alert-turn').innerHTML = currentPlayer + ' turn';
    document.getElementById('winner').hidden = false;
    endGame = false;
}

let size = 10;
matrix = createEmptyTable(size, size)
drawTable(matrix)


