// Функция для проверки срока ипотеки
async function checkMortgagePeriod() {
    const ageInput = document.querySelector("#ageInput");
    const mortgagePeriodInput = document.querySelector("#mortgagePeriodInput");
    const mortgagePeriodTrueBlock = document.querySelector(".mortgage-period-true-block");

    let search = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
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
        document.querySelector(".alert-success").style.display = "none";
        mortgagePeriodTrueBlock.style.display = "none";
        mortgagePeriodInput.classList.add("incorrect-block");
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        document.querySelector(".build-type-block").style.display = "block";
        mortgagePeriodTrueBlock.style.display = "block";
        mortgagePeriodInput.classList.remove("incorrect-block");
    }
}