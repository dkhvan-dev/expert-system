// Функция для проверки стажа работы
async function checkExperience() {
    const experienceValueInput = document.querySelector("#experienceValueInput");
    const contributionValueInput = document.querySelector("#contributionValueInput");
    const moneyIncomeInput = document.querySelector("#moneyIncomeInput");
    const buildTypeInput = document.querySelector("#buildTypeInput");
    const ageInput = document.querySelector("#ageInput");
    const mortgagePeriodInput = document.querySelector("#mortgagePeriodInput");
    const experienceTrueBlock = document.querySelector(".experience-true-block");
    const totalCostInput = document.querySelector("#totalCostInput");
    const contributionValue = Math.round((contributionValueInput.value * 100) / totalCostInput.value);

    var creditHistoryTypes = ["BAD", "GOOD", "EXCELLENT"];
    var creditHistoryValues = ["Плохая", "Хорошая", "Отличная"];
    var creditObligationRandom = Math.floor(Math.random() * 100)
    var randomIndex = Math.floor(Math.random() * creditHistoryTypes.length);
    var creditHistoryRandom = creditHistoryTypes[randomIndex];

    let searchReject = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
        "buildTypeId": buildTypeInput.value,
        "moneyIncome": moneyIncomeInput.value,
        "contribution": contributionValue,
        "experience": experienceValueInput.value,
        "creditHistory": creditHistoryRandom,
        "creditObligation": creditObligationRandom,
        "result": 'REJECT'
    }

    let searchApprove = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
        "buildTypeId": buildTypeInput.value,
        "moneyIncome": moneyIncomeInput.value,
        "contribution": contributionValue,
        "experience": experienceValueInput.value,
        "creditHistory": creditHistoryRandom,
        "creditObligation": creditObligationRandom,
        "result": 'APPROVE'
    }
    var rulesOld = []
    var rulesApprove = []
    try {
        const response = await fetch(url + "/rules/search", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(searchReject)
        });

        const dataArrayOld = await response.json(); // Массив объектов данных
        rulesOld = dataArrayOld.map(data => ({
            "minAge": data.minAge,
            "maxAge": data.maxAge,
            "result": data.result
        }));

        // Ищем одобренные правила
        const responseApprove = await fetch(url + "/rules/search", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(searchApprove)
        });

        const dataArrayApprove = await responseApprove.json(); // Массив объектов данных
        rulesApprove = dataArrayApprove.map(data => ({
            "minAge": data.minAge,
            "maxAge": data.maxAge,
            "result": data.result
        }));
    } catch (error) {
        console.error("Ошибка при получении", error);
        throw error;
    }

    document.querySelector(".credit-history-value").innerText = creditHistoryValues[randomIndex]
    document.querySelector(".credit-obligation-value").innerText = creditObligationRandom

    var creditScore = Math.floor(Math.random() * (580));

    if (creditHistoryRandom === 'GOOD') {
        creditScore = Math.floor(Math.random() * (669 - 580 + 1)) + 580;
    } else if (creditHistoryRandom === 'EXCELLENT') {
        creditScore = Math.floor(Math.random() * (1001 - 670)) + 670;
    }

    const KD = calculateCreditHistoryConfidence(creditScore);
    const MIN_KD = 0.5;

    if (rulesApprove.length !== 0) {
        document.querySelector(".alert-success").style.display = "block";
        experienceTrueBlock.style.display = "none";
    } else {
        document.querySelector(".alert-success").style.display = "none";
        if (rulesOld.length !== 0) {
            document.querySelector(".alert-danger").style.display = "block";
            experienceTrueBlock.style.display = "none";
            experienceValueInput.classList.add("incorrect-block");
        } else if (KD < MIN_KD) {
            document.querySelector(".alert-danger").innerText = "Требуется дополнительная проверка менеджером банка.";
            document.querySelector(".alert-danger").style.display = "block";
            experienceTrueBlock.style.display = "none";
        } else {
            document.querySelector(".alert-danger").style.display = "none";
            document.querySelector(".ownership-block").style.display = "block";
            experienceTrueBlock.style.display = "block";
            experienceValueInput.classList.remove("incorrect-block");
        }
    }
}