let pElement = document.getElementById("valueOfN");
let spanElement = document.getElementById("rateimg");
let businessName = document.getElementById("businessName");
let businessNum = document.getElementById("businessNum");
let recentTrade = document.getElementById("recentTrade");
let inputimg = document.getElementById("inputimg");



window.addEventListener("load", function () {
    console.log(planner);
    console.log(planner.id);
    businessName.innerText = planner.business_name;
    recentTrade.innerText = "최근 거래 : " + planner.dealCnt + "건";
    businessNum.innerText = "사업자 등록번호 : " + planner.business_no;
    pElement.innerText = planner.rating;
    pElement.style.color = "#F28585"
    fetch('/encodeImage',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: planner.id })  // 입력된 값을 JSON 형태로 전송합니다.
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
    spanElement.style.width = (planner.rating) * 20 + "%";
});


// 여기에 이 플래너에 가장 최신리뷰 상단2개를 호출해야함
// for문 2회돌려서 여기에 추가할것

fetch("src/main/resources/templates/memberReview.html")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("ReviewContainer");
        container.insertAdjacentHTML("afterbegin", body);
    });

// 여기는 리뷰더보기 < 를 눌렀을때 container를 호출해야함
let textReviewPlus = document.getElementById("textReviewPlus");
textReviewPlus.addEventListener("click", reviewMyfunc);
function reviewMyfunc(e) {
    fetch("src/main/resources/templates/memberReview.html")
        .then((resp) => resp.text())
        .then((body) => {
            let container = document.getElementById("ReviewContainer");
            container.insertAdjacentHTML("afterbegin", body);
        });
}

//////////////////포토리뷰///////////////////
for (let i = 0; i < 9; i++) {
    fetch("src/main/resources/templates/photoReview.html")
        .then((resp) => resp.text())
        .then((body) => {
            let container = document.getElementById("photoReviewContainer");
            container.insertAdjacentHTML("afterbegin", body);
        });
}

let photoReviewPlus = document.getElementById("photoReviewPlus");
photoReviewPlus.addEventListener("click", photoreviewMyfunc);
function photoreviewMyfunc(e) {
    for (let i = 0; i < 3; i++) {
        fetch("src/main/resources/templates/photoReview.html")
            .then((resp) => resp.text())
            .then((body) => {
                let container = document.getElementById("photoReviewContainer");
                container.insertAdjacentHTML("afterbegin", body);
            });
    }
}
