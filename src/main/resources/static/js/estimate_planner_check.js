/*
fetch("/userInfo")
    .then((resp) => resp.text())
    .then((body) => {
        let container = document.getElementById("userInfo");
        container.insertAdjacentHTML("afterbegin", body);
    });

*/

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

let CommentButton = document.querySelector(".Comment1");
CommentButton.addEventListener("click", function () {
    console.log("채팅방 이동")
});

let chatBtn = document.getElementById("hrefChat");

chatBtn.addEventListener("click",link);
function link(){
    let mnoText = document.getElementById("mno").textContent;
    let pnoText = document.getElementById("pno").textContent;
    let mno = "memberNo="+mnoText;
    let pno = "plannerNo="+pnoText;
    console.log(mno);
    window.location.href="/plannerChat?" + mno + "&" + pno;

}