let pElement = document.getElementById("valueOfN");
let spanElement = document.getElementById("rateimg");

let n = parseInt(pElement.innerText);
spanElement.style.width = n * 10 + "%";

// 여기에 이 플래너에 가장 최신리뷰 상단2개를 호출해야함
// for문 2회돌려서 여기에 추가할것
fetch("./memberReview.html")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("ReviewContainer");
        container.insertAdjacentHTML("afterbegin", body);
    });

// 여기는 리뷰더보기 < 를 눌렀을때 container를 호출해야함
let textReviewPlus = document.getElementById("textReviewPlus");
textReviewPlus.addEventListener("click", reviewMyfunc);
function reviewMyfunc(e) {
    fetch("./memberReview.html")
        .then((resp) => resp.text())
        .then((body) => {
            let container = document.getElementById("ReviewContainer");
            container.insertAdjacentHTML("afterbegin", body);
        });
}

//////////////////포토리뷰///////////////////
for (let i = 0; i < 9; i++) {
    fetch("./photoReview.html")
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
        fetch("./photoReview.html")
            .then((resp) => resp.text())
            .then((body) => {
                let container = document.getElementById("photoReviewContainer");
                container.insertAdjacentHTML("afterbegin", body);
            });
    }
}
