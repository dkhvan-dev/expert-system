// Функция для проверки размера первоначального взноса
async function checkContribution() {
    const contributionValueInput = document.querySelector("#contributionValueInput");
    const moneyIncomeInput = document.querySelector("#moneyIncomeInput");
    const buildTypeInput = document.querySelector("#buildTypeInput");
    const ageInput = document.querySelector("#ageInput");
    const mortgagePeriodInput = document.querySelector("#mortgagePeriodInput");
    const contributionTrueBlock = document.querySelector(".contribution-true-block");

    let search = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
        "buildTypeId": buildTypeInput.value,
        "moneyIncome": moneyIncomeInput.value,
        "contribution": contributionValueInput.value,
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

    if (rules.length !== 0) {
        document.querySelector(".alert-danger").style.display = "block";
        contributionTrueBlock.style.display = "none";
        contributionValueInput.classList.add("incorrect-block");
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        document.querySelector(".experience-block").style.display = "block";
        contributionTrueBlock.style.display = "block";
        contributionValueInput.classList.remove("incorrect-block");
    }


    if (ageInput.value >= 63 && ageInput.value <= 68) {
        var creditHistoryTypes = ["BAD", "GOOD", "EXCELLENT"];
        var creditObligationRandom = Math.floor(Math.random() * 100)
        var randomIndex = Math.floor(Math.random() * creditHistoryTypes.length);
        var creditHistoryRandom = creditHistoryTypes[randomIndex];
        const experienceTrueBlock = document.querySelector(".experience-true-block");
        var creditScore = Math.floor(Math.random() * (580));

        if (creditHistoryRandom === 'GOOD') {
            creditScore = Math.floor(Math.random() * (669 - 580 + 1)) + 580;
        } else if (creditHistoryRandom === 'EXCELLENT') {
            creditScore = Math.floor(Math.random() * (1001 - 670)) + 670;
        }

        let searchReject = {
            "age": ageInput.value,
            "mortgagePeriod": mortgagePeriodInput.value,
            "buildTypeId": buildTypeInput.value,
            "moneyIncome": moneyIncomeInput.value,
            "contribution": contributionValueInput.value,
            "creditHistory": creditHistoryRandom,
            "creditObligation": creditObligationRandom,
            "result": 'REJECT'
        }

        let searchApprove = {
            "age": ageInput.value,
            "mortgagePeriod": mortgagePeriodInput.value,
            "buildTypeId": buildTypeInput.value,
            "moneyIncome": moneyIncomeInput.value,
            "contribution": contributionValueInput.value,
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

        const KD = calculateCreditHistoryConfidence(creditScore);
        const MIN_KD = 0.5;

        if (rulesApprove.length !== 0) {
            document.querySelector(".alert-success").style.display = "block";
            experienceTrueBlock.style.display = "none";
        } else {
            document.querySelector(".alert-success").style.display = "none";

            if (rulesOld.length !== 0) {
                document.querySelector(".alert-danger").style.display = "block";
                document.querySelector(".alert-danger").innerText = "Отказано. Ваша кредитная история или кредитные обязательства не удовлетворяют."
                experienceTrueBlock.style.display = "none";
            } else if (KD < MIN_KD) {
                document.querySelector(".alert-danger").innerText = "Требуется дополнительная проверка менеджером банка.";
                document.querySelector(".alert-danger").style.display = "block";
                experienceTrueBlock.style.display = "none";
            } else {
                document.querySelector(".alert-danger").style.display = "none";
                document.querySelector(".ownership-block").style.display = "block";
                experienceTrueBlock.style.display = "block";
            }
        }

        document.querySelector(".experience-block").style.display = "none";
    }

}

// Функция расчета КД для кредитной истории
function calculateCreditHistoryConfidence(creditScore) {
    let KD = 0; // Коэффициент достоверности
    if (creditScore <= 579) {
        KD = (579 - creditScore) / 579;
    } else if (creditScore >= 580 && creditScore <= 669) {        // Расчет для хорошей кредитной истории
        KD = creditScore <= 624 ? (624 - creditScore) / 44 : (669 - creditScore) / 44;
    } else {
        KD = 1; // Максимальный КД для отличной кредитной истории
    }

    return KD;
}