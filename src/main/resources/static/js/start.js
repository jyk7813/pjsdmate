var userstat = document.getElementById('userstat');
var logo = document.querySelector('.logo');
var loginbtn = document.querySelector('.loginbtn');
var checkbox = document.querySelector('.checkbox');
var centerText = document.querySelector('.text1');  // center 태그를 선택

checkbox.addEventListener('change', function() {
    if (checkbox.checked) {
        userstat.querySelector('#member').innerHTML = '플래너';
        userstat.querySelector('#member').style.color = '#4BA698';
        
        logo.classList.remove('member');
        logo.classList.add('planner');
        
        loginbtn.classList.remove('member');
        loginbtn.classList.add('planner');
        
        // centerText.classList.remove('text1');
        // centerText.classList.add('text2');
        centerText.innerHTML = `
            <p><span class="text2bold" >플래너 고객</span>을 위한 페이지 입니다.</p>
            <p>고객이 원하는 결혼을 보고 견적을 작성해 보세요</p>
            <p><span class="text2bold">많은 고객들</span>과 만날 수 있습니다.</p>
        `;

    } else {
        userstat.querySelector('#member').innerHTML = '일반인';
        userstat.querySelector('#member').style.color = '#F28585';
        
        logo.classList.remove('planner');
        logo.classList.add('member');
        
        loginbtn.classList.remove('planner');
        loginbtn.classList.add('member');
        
        // centerText.classList.remove('text2');
        // centerText.classList.add('text1');

        centerText.innerHTML = `
        <p><span class="text1bold" >일반인 고객</span>을 위한 페이지 입니다.</p>
        <p>간단한 질문들을 통하여 전문가에게</p>
        <p><span class="text1bold">다양한 견적</span>을 받아 보세요</p>
    `;
    }
});
