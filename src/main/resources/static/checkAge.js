const url = "http://localhost:8080";
// Функция для проверки возраста
async function checkAge() {
    const ageInput = document.querySelector("#ageInput");
    const ageTrueBlock = document.querySelector(".age-true-block");
    let search = {
        "age": ageInput.value,
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
        ageTrueBlock.style.display = "none";
        ageInput.classList.add("incorrect-block");
    } else {
        document.querySelector(".alert-danger").style.display = "none";
        document.querySelector(".mortgage-period-block").style.display = "block";
        ageTrueBlock.style.display = "block";
        ageInput.classList.remove("incorrect-block");
    }
}