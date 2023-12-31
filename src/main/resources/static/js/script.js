var pageUrls = ['page1.html', 'page2.html', 'page3.html', 'page4.html', 'page5.html', 'page6.html', 'page7.html'];
var pageContent = {};
let label;
let clickLabel;
let handleSelect;
let question = {};


$(document).ready(function () {
  // 페이지 내용 미리 로드
  var promises = pageUrls.map(function(url, index) {
    return $.get(url, function(data) {
      pageContent['page' + (index + 1)] = data; // HTML 저장
    });
  });

  // 모든 페이지가 로드된 후 초기 페이지 설정
  $.when.apply($, promises).then(function() {
    var currentPage = 1;
    navigateToPage(currentPage);

    // 다음/이전 버튼 클릭 이벤트
    $(".next").on("click", function () {
      if (currentPage < 7) {
        currentPage++;
        navigateToPage(currentPage);
        console.log(question);
      } else if (currentPage == 7) {
        let data = JSON.stringify(question); // JSON 형식으로 변환
        console.log(data);
        $.ajax({
          url: "./saveq", // 클라이언트가 서버로 보낼 HTTP 요청의 URL 주소
          type: "POST", // HTTP 요청 방식(GET, POST)
          data: data, // 서버로 보낼 데이터
          contentType: "application/json", // 보낼 데이터의 타입
          success: function (data) { // 요청이 성공하면 서버에서 전달된 데이터가 처리됨
            console.log(data); // {name: "홍길동", age: 20}
            completeAndRedirect();
          },
          error: function (request, status, error) {
            console.log(error);
            alert("기입하지 않은 항목이 있습니다.");
          }
        });
      }
    });



    $(".previous").on("click", function () {
      if (currentPage > 1) {
        currentPage--;
        navigateToPage(currentPage);
      }
    });
  });
});
function completeAndRedirect() {
  // 페이지 이동
  window.location.href = "/member/main";
}

function navigateToPage(pageNumber) {
  // 컨테이너에 미리 로드된 HTML 삽입
  $("#container").html(pageContent['page' + pageNumber]);

  // 페이지 지시자 업데이트
  $(".page-indicator").removeClass("active");
  $("#page" + pageNumber).addClass("active");

  // 현재 페이지 번호 및 질문 업데이트
  $("#curruntpage").text(pageNumber + " / 7");
  $("#question").text(getQuestionForPage(pageNumber));
}

function getQuestionForPage(pageNumber) {
  var questions = [
    "결혼장소 견적을 위한 질문입니다.",
    "본식 의상 견적을 위한 질문입니다.",
    "본식 부모님 의상 견적을 위한 질문입니다.",
    "본식 촬영 견적을 위한 질문입니다.",
    "스튜디오 촬영 견적을 위한 질문입니다.",
    "스냅촬영 견적을 위한 질문입니다.",
    "생각하시는 예산은 어느정도인가요?",
  ];

  return questions[pageNumber - 1];
}
