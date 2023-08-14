let okbtn = document.querySelector("#okbtn");
let inputdata = document.querySelector(".input");

let userstat;
let member;

okbtn.addEventListener("click", () => {
    checkUserStat();
    var url = "/api/"+userstat+"/findemail";

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: inputdata.value })  // 입력된 값을 JSON 형태로 전송합니다.
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
        alert("회원님의 아이디" + data.id+ " 입니다.");
        window.location.href = "/"+userstat+"/login";

    })
    .catch(error => {
        console.error('Error:', error);
        if(error.message === "Network response was not ok"){
            alert("입력하신 정보가 올바르지 않습니다.");
        }
    });

});

function checkUserStat(){
    if(okbtn.getAttribute("class").includes("member")){
        userstat = "member";
    }
    if(okbtn.getAttribute("class").includes("planner")){
        userstat = "planner";
    }
}
