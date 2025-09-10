const result = document.getElementById("result");
const buttons = document.querySelectorAll("button");
let total = "";

// Gắn sự kiện click cho từng nút
buttons.forEach(button => {
    button.addEventListener("click", () => {
        const value = button.textContent;

        if (value === "C") {
            total = "";
            result.value = "";
        }
        else if (value === "=") {
            try {
                total = eval(total).toString();
                result.value = total;
            } catch (e) {
                result.value = "Error";
                total = "";
            }
        }
        else {
            total += value;
            result.value = total;
        }
    });
});