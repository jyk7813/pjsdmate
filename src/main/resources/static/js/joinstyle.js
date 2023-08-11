const labels = document.querySelectorAll('label');

labels.forEach(label => {
    const textLength = label.innerText.length;
    if (textLength > 1) {
        const spacing = (114 - (textLength * 14)) / (textLength - 1); // 14는 평균 글자 너비로 추정한 값입니다. 조정이 필요할 수 있습니다.
        label.style.letterSpacing = `${spacing}px`;
    }
});