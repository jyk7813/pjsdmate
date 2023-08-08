fetch('https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000') // API URL
    .then(response => response.json()) // response를 json으로 변환
    .then(data => {
        const regionList = document.getElementById('regionList'); // ul 요소 선택
        data.regcodes.forEach(item => {
            const key = item.code.substring(0, 2); // code의 앞 두 자리
            const value = item.name; // name

            // 새로운 li 요소 생성
            const li = document.createElement('li');
            li.textContent = `${value}`; // 텍스트 설정
            // add class = optionItem
            li.classList.add('optionItem');
            // add data-value = key
            li.setAttribute('data-value', key);
            regionList.appendChild(li); // ul에 li 추가
        });
    })
    .catch(error => console.error('Error:', error)); // 에러 처리
// 첫 번째 콤보 박스에서 항목을 선택했을 때의 이벤트 핸들러 설정
document.getElementById('regionList').addEventListener('click', function(event) {
    // 클릭된 항목이 li 요소인 경우
    if (event.target.tagName.toLowerCase() === 'li') {
      const cityCode = event.target.getAttribute('data-value'); // 선택된 항목의 data-value 속성 값 가져오기
  
      // 두 번째 콤보 박스의 목록 업데이트
      fetch(`https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=${cityCode}*0000`) // API URL
        .then(response => response.json()) // response를 json으로 변환
        .then(data => {
          const cityList = document.getElementById('cityList'); // 두 번째 콤보 박스의 ul 요소 선택
          cityList.innerHTML = ''; // 기존 항목들을 모두 삭제
          data.regcodes.forEach(item => {
            const key = item.code.substring(2, 5); // code의 세 번째 자리부터 다섯 번째 자리까지
            if (key === '000') return; // 000은 제외
            const value = item.name.substring(item.name.indexOf(' '), item.name.length); // name에서 첫 번째 공백 이후의 문자열
  
            // 새로운 li 요소 생성
            const li = document.createElement('li');
            li.textContent = `${value}`; // 텍스트 설정
            // add class = optionItem
            li.classList.add('optionItem');
            // add data-value = key
            li.setAttribute('data-value', key);
            cityList.appendChild(li); // ul에 li 추가
          });
        })
        .catch(error => console.error('Error:', error)); // 에러 처리 
    }
  });

    // ${key}: