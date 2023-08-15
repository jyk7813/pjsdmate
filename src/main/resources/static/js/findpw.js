let okbtn = document.querySelector("#okbtn");
let inputdata = document.querySelector(".input");
let inputname;
let userstat;
let member;

okbtn.addEventListener("click", () => {
    checkUserStat();

    inputname = document.querySelector(".input").getAttribute("name");
    var url = "/api/"+userstat+"/find"+inputname;



    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ [inputname]: inputdata.value })  // 입력된 값을 JSON 형태로 전송합니다.
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        return response.json();
    })
    .then(data => {
        console.log(data)
        // 서버로부터의 응답을 여기에서 처리할 수 있습니다.

        if (inputname == "id") {
            // convert id to email
            member = data;
            convertEmailPage();

        } else if (inputname == "email") {
            console.log(member);
            console.log(data);
            // convert email to pw
            if (member.email == data.email) {
                alert("회원님의 비밀번호는 " + data.pwd+ " 입니다.");
                window.location.href = "/"+userstat+"/login";
            }
        }
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

function convertEmailPage (){
    var description = document.querySelector(".Description");
    description.innerHTML = "찾고자 하는 계정의 이메일을 <br> 입력해주세요.";
    inputdata.setAttribute("name", "email");
    inputdata.setAttribute("placeholder", "E-MAIL");
    inputdata.value = "";

}

