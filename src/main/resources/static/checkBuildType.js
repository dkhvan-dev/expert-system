// Функция для проверки типа постройки
async function checkBuildType() {
    const buildTypeInput = document.querySelector("#buildTypeInput");
    const ageInput = document.querySelector("#ageInput");
    const mortgagePeriodInput = document.querySelector("#mortgagePeriodInput");
    const buildTypeTrueBlock = document.querySelector(".build-type-true-block");

    let search = {
        "age": ageInput.value,
        "mortgagePeriod": mortgagePeriodInput.value,
        "buildTypeId": buildTypeInput.value,
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
        buildTypeTrueBlock.style.display = "none";
        buildTypeInput.classList.add("incorrect-block");
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        document.querySelector(".money-income-block").style.display = "block";
        buildTypeTrueBlock.style.display = "block";
        buildTypeInput.classList.remove("incorrect-block");
    }
}