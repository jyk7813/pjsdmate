let id = document.querySelector('#id') ; // 아이디
let id_check = document.querySelector('.id_check_btn') ; // 아이디 중복 확인
let password = document.querySelector('#password') ;// 비밀번호
let passwordCheck = document.querySelector('#pwcheck') ;// 비밀번호 확인
let duplicateCheck = false; // 아이디 중복 체크 여부
let joinBtn = document.querySelector('.join_btn') ; // 회원가입 버튼
let pwcheckerror = document.querySelector('#pwcheckerror') ; // 비밀번호 확인 에러 메시지
function extracted(e) {
    if (password.value != passwordCheck.value) {
        console.log(password.value, passwordCheck.value);
        pwcheckerror.innerHTML = '비밀번호가 일치하지 않습니다.';
    } else {
        passwordCheck.setCustomValidity('');
        pwcheckerror.innerHTML = '';
    }
}

passwordCheck.addEventListener('keyup', function(e) {
    extracted(e);
}) ;

id_check.onclick = function idCheck() {
    let idValue = id.value ;
    if(idValue == '') {
        id.setCustomValidity('아이디를 입력해주세요.') ;
        return ;
    }
    fetch('/member/idCheck', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({id: idValue}),
    })
    .then(response => response.json())
    .then(data => {
        if(data.result == 'success') {
            id_check.style.backgroundColor = 'green' ;
            id_check.innerHTML = '확인 완료' ;
            id_check.disabled = true ; // 버튼 비활성화
            duplicateCheck = true ;
        } else {
            alert('이미 사용중인 아이디입니다.') ;
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
//id에 있는 값이 바뀌면 버튼을 원래대로 돌려놓는다.

id.addEventListener('keydown', function(e) {
    id_check.style.backgroundColor = "rgba(242, 133, 133, 1)";
    id_check.innerHTML = '중복확인' ;
    id_check.disabled = false ; // 버튼 활성화
    duplicateCheck = false ;
});

// 회원가입 버튼 클릭 시 실행
joinBtn.addEventListener('click', function(e) {
    if (!duplicateCheck) {
        alert('아이디 중복 확인을 해주세요.');
        e.preventDefault();
    }
}) ;

