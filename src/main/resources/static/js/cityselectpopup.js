function showPopup() {
    var popup = document.getElementById("cityPopup");
    var areaLink = document.querySelector(".area a");

    popup.style.display = "block";

    document.addEventListener("click", function closePopupOutside(e) {
        if (!popup.contains(e.target) && e.target !== areaLink) {
            hidePopup();
            document.removeEventListener("click", closePopupOutside);
        }
    });
}

function hidePopup() {
    var popup = document.getElementById("cityPopup");
    popup.style.display = "none";
}

function changeCity(city) {
    var selectedCity = document.querySelector(".area a");
    selectedCity.innerHTML = city;
    hidePopup();
}