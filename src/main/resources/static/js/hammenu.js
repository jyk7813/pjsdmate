


function goOut(){
    window.location.href="./logout";
}
var burger = $('.menu-trigger');

burger.each(function (index) {
    var $this = $(this);

    $this.on('click', function (e) {
        e.preventDefault();
        $(this).toggleClass('active-' + (index + 1));
    })
});

var h = 0;

$(burger).on("click", function () {
    if (h == 0) {
        $('.ham-con').animate({
            right: '0',
            opacity: 1
        }, 500);
        $(this).addClass('active-1');
        h++;
    } else if (h == 1) {
        $('.ham-con').animate({
            right: '-20%',
            opacity: 0
        }, 500);
        $(this).removeClass('active-1');
        h--;
    }
    $(window).scroll(function() {
        sct = $(window).scrollTop();
        if(sct>30){
            $('.ham-con').css({
                opacity: 0,
                right :'-20%'
            }, 500);
            $(burger).removeClass('active-1');
            h=0;
        }
    });
})