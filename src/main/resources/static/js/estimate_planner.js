fetch("/plannerInfo.html")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("plannerInfo");
        container.insertAdjacentHTML("afterbegin", body);
    });
fetch("/except")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("except");
        container.insertAdjacentHTML("afterbegin", body);
    });
