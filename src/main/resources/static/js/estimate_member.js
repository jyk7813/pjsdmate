fetch("/plannerInfo")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("plannerInfo");

        let name = document.getElementById("name").value;
        let dealCnt = document.getElementById("dealCnt").value;
        let rating =document.getElementById("rating").value;
        container.insertAdjacentHTML("afterbegin", body);


        let BsName = document.getElementById("plannerBsName");
        let ratingAndDealCnt = document.getElementById("ratingAndDealCnt");
        BsName.innerText= name;
        let text = "평점"+rating+"/"+"최근 거래"+dealCnt+"건";
        ratingAndDealCnt.innerText = text;

    });


let showAButton = document.getElementById("showA");
let aaDiv = document.getElementById("A");
showAButton.addEventListener("click", function () {
    aaDiv.classList.toggle("visible");
});

let showBButton = document.getElementById("showB");
let bbDiv = document.getElementById("B");
showBButton.addEventListener("click", function () {
    bbDiv.classList.toggle("visible");
});

let showCButton = document.getElementById("showC");
let ccDiv = document.getElementById("C");
showCButton.addEventListener("click", function () {
    ccDiv.classList.toggle("visible");
});

let showDButton = document.getElementById("showD");
let ddDiv = document.getElementById("D");
showDButton.addEventListener("click", function () {
    ddDiv.classList.toggle("visible");
});

let showEButton = document.getElementById("showE");
let eeDiv = document.getElementById("E");
showEButton.addEventListener("click", function () {
    eeDiv.classList.toggle("visible");
});

let showFButton = document.getElementById("showF");
let ffDiv = document.getElementById("F");
showFButton.addEventListener("click", function () {
    ffDiv.classList.toggle("visible");
});
