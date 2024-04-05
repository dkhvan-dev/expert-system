// Функция для проверки наличия имущества
async function checkIsOwnership() {
    const ownershipValueSelect = document.querySelector("#ownershipValueSelect");

    if (ownershipValueSelect.value !== 'true') {
        document.querySelector(".alert-danger").style.display = "block";
        document.querySelector(".alert-success").style.display = "none";
    } else {
        document.querySelector(".alert-success").style.display = "block";
        document.querySelector(".alert-danger").style.display = "none";
    }
}