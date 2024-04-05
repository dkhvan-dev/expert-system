// Функция для проверки гражданства
function checkResident() {
    let isResident = document.querySelector("#residentSelect").value;
    const residentSelect = document.querySelector("#residentSelect");
    const ageBlock = document.querySelector(".age-block");
    const residentTrueBlock = document.querySelector(".resident-true-block");

    if (isResident !== "true") {
        document.querySelector(".alert-danger").style.display = "block";
        document.querySelector(".alert-success").style.display = "none";
        residentTrueBlock.style.display = "none";
        residentSelect.classList.add("incorrect-block");
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        ageBlock.style.display = "block";
        residentTrueBlock.style.display = "block";
        residentSelect.classList.remove("incorrect-block");
    }
}