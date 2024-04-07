// Функция для проверки размера дохода
async function checkMoneyIncome() {
    const moneyIncomeInput = document.querySelector("#moneyIncomeInput");
    const buildTypeInput = document.querySelector("#buildTypeInput");
    const ageInput = document.querySelector("#ageInput");
    const mortgagePeriodInput = document.querySelector("#mortgagePeriodInput");
    const moneyIncomeTrueBlock = document.querySelector(".money-income-true-block");

    let search = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
        "buildTypeId": buildTypeInput.value,
        "moneyIncome": moneyIncomeInput.value,
        "result": 'REJECT'
    }
    var rules = []
    try {
        const response = await fetch(url + "/rules/search", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(search)
        });

        const dataArray = await response.json(); // Массив объектов данных
        rules = dataArray.map(data => ({
            "minAge": data.minAge,
            "maxAge": data.maxAge,
            "result": data.result
        }));
    } catch (error) {
        console.error("Ошибка при получении", error);
        throw error;
    }

    const KD = calculateIncomeConfidence(parseInt(moneyIncomeInput.value));
    const MIN_KD = 0.5;

    if (rules.length !== 0) {
        document.querySelector(".alert-danger").style.display = "block";
        document.querySelector(".alert-success").style.display = "none";
        moneyIncomeTrueBlock.style.display = "none";
        moneyIncomeInput.classList.add("incorrect-block");
    } else if (KD < MIN_KD) {
        document.querySelector(".alert-danger").innerText = "Требуется дополнительная проверка дохода. Пожалуйста, предоставьте дополнительные документы.";
        document.querySelector(".alert-danger").style.display = "block";
        document.querySelector(".alert-success").style.display = "none";
        moneyIncomeTrueBlock.style.display = "none";
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        document.querySelector(".contribution-block").style.display = "block";
        moneyIncomeTrueBlock.style.display = "block";
        moneyIncomeInput.classList.remove("incorrect-block");
    }
}

// Функция расчета КД для дохода
function calculateIncomeConfidence(moneyIncome) {
    let KD = 0; // Коэффициент достоверности
    if (moneyIncome <= 250000) {
        KD = (250000 - moneyIncome) / 250000;
    } else if (moneyIncome > 250000 && moneyIncome <= 375000) {
        KD = (375000 - moneyIncome) / 125000;
    } else if (moneyIncome > 375000 && moneyIncome <= 500000) {
        KD = (500000 - moneyIncome) / 125000;
    } else {
        KD = 1; // Максимальный КД для высокого дохода
    }

    return KD;
}