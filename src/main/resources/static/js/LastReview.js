fetch("/reviewCenter")
.then((resp) => resp.text())
.then((body) => {
  let container = document.getElementById("reviewCenter");
  container.insertAdjacentHTML("afterbegin",body);
});

function changeFlower(event) {
    const clickedId = parseInt(event.target.id);
    const images = document.getElementsByClassName("flower");

    for (let i = 0; i < images.length; i++) {
        const currentId = parseInt(images[i].id);
        images[i].src = currentId <= clickedId ? "images/smallLogo.png" : "images/grayStar.png";
    }

    document.getElementById("checkCount").textContent = clickedId + "/5";

}
// 버튼 클릭 시 체크된 문구들을 가져오는 함수
document.getElementById("sendRequest").addEventListener("click", function () {
    const checkboxes = document.querySelectorAll('.margindiv input[type="checkbox"]');
    const selectedReviews = [];
  
    checkboxes.forEach(checkbox => {
      if (checkbox.checked) {
        const reviewText = checkbox.nextElementSibling.nextElementSibling.textContent;
        selectedReviews.push(reviewText);
      }
    });

    let need = {};

    var currentURL = window.location.href;

    var urlWithoutParams = currentURL.split("specification=")[1];


    const images = document.getElementsByClassName("flower");
    let currentId;
    for (let i = 0; i < images.length; i++) {
        currentId = parseInt(images[i].id);
    }
    need.rating=currentId;
    need.specification = urlWithoutParams;
    let json = JSON.stringify(need);
    $.ajax({
        url: "/sendLastReview", // 클라이언트가 서버로 보낼 HTTP 요청의 URL 주소
        type: "POST", // HTTP 요청 방식(GET, POST)
        data: json, // 서버로 보낼 데이터
        contentType: "application/json", // 보낼 데이터의 타입
        success: function (json) { // 요청이 성공하면 서버에서 전달된 데이터가 처리됨
            console.log(json); // {name: "홍길동", age: 20}
            link()
        },
        error: function (request, status, error) {
            console.log(error);
            link()
        }
    });
    function link(){
        window.location.href="/sendLastReview"
    }
  });
