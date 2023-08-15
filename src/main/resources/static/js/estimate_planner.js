fetch("/userInfo")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("userInfo");
        container.insertAdjacentHTML("afterbegin", body);

        let userName = document.getElementById("userName");
        let userArea = document.getElementById("userArea");

        let infoName =document.getElementById("infoName");
        let infoArea = document.getElementById("InfoArea");

        let memberId = document.getElementById("memberId").value;

        let inputimg = document.querySelector(".inputimg");

        infoName.innerText=userName.value;
        infoArea.innerText=userArea.value;

        fetch('/encodeImage2',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ id: memberId })  // 입력된 값을 JSON 형태로 전송합니다.
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                inputimg.src = "data:image/jpeg;base64," + data.image;
            })
            .catch(error => {
                console.error('Error:', error);
                if(error.message === "Network response was not ok"){
                    alert("입력하신 정보가 올바르지 않습니다.");
                }
            });

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
function CreateObj(value,ValueName) {
        let inputValue = value.replace(/[^0-9]/g, ''); // 숫자 이외의 문자 제거
        let num = parseInt(inputValue);
        if (!(Object.is(num, NaN))) {
           specification.ValueName = num;
        }
    }






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

}
let specification = {};





let sendBtn = document.getElementById("sendRequest");
sendBtn.addEventListener("click",save);

function save(){
    let wedding_hall_price = document.getElementById("wedding_hall_price");
    let cloth = document.getElementById("cloth_price");
    let parents_cloth = document.getElementById("parents_cloth_price");
    let shot = document.getElementById("shot");
    let studio = document.getElementById("studio");
    let snap_shot = document.getElementById("snap_shot");
    var currentURL = window.location.href;

    var urlWithoutParams = currentURL.split("requirement=")[1];



        specification.weddinghall= parseToInt(wedding_hall_price.value);
        specification.dress = parseToInt(cloth.value);
        specification.parentsdress =parseToInt(parents_cloth.value);
        specification.photo = parseToInt(shot.value);
        specification.studio = parseToInt(studio.value);
        specification.snap = parseToInt(snap_shot.value);
        specification.requirement_no = urlWithoutParams;
        specification.state = 0;

    $.ajax({
        type: "POST",
        url: "/saveSpecification",
        data: JSON.stringify(specification),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
          console.log(response.ok);

        }
    });
}
function link(){
    window.location.href="/planner/main";
}
function parseToInt(x){
    let inputValue = x.replace(/[^0-9]/g, '');
    return parseInt(inputValue);
}

