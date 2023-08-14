fetch("/userInfo")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("userInfo");
        container.insertAdjacentHTML("afterbegin", body);
    });
let specification = {};
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
function CreateObj(value,ValueName) {
        let inputValue = value.replace(/[^0-9]/g, ''); // 숫자 이외의 문자 제거
        let num = parseInt(inputValue);
        if (!(Object.is(num, NaN))) {
           specification.ValueName = num;
        }
    }



// 견적 보내기

let sendReq = document.getElementById("sendRequest");
sendReq.addEventListener("click",function(){


});




function validateNumberInput(event){
    let inputElement = document.getElementById(event.target.id);
    let inputValue = inputElement.value.replace(/[^0-9]/g, ''); // 숫자 이외의 문자 제거
    let formattedValue = inputValue.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    if (parseInt(inputValue) > 10000000) {
        formattedValue = '10,000,000';
    }

        inputElement.value = formattedValue;


    setTimeout(checkSum,1000);

}



function checkSum() {
    let inputElements = document.getElementsByClassName('price');
    let total = document.getElementById("sum");
    var sum = 0;
    for (const inputElement of inputElements) {
        let inputValue = inputElement.value.replace(/[^0-9]/g, ''); // 숫자 이외의 문자 제거
        let num = parseInt(inputValue);
        if (!(Object.is(num, NaN))) {
            sum = sum + num;
        }
    }

    let formattedValue = sum.toLocaleString();
    total.innerText = formattedValue + " 원";


    /*        $(sendRequest).on("click", function () {*/

    // 버튼 클릭 시 AJAX POST 요청 보내기



    function link() {
        window.location.href = "/planner/main";
    }
}
