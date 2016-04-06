$(window).on('load', function () {
    // cover page
    $("#cover").fadeOut(200);
    // navigation control
    $(".btn-nav").on("click tap", function () {
        $(".nav-container").toggleClass("showNav hideNav").removeClass("hidden");
        $(this).toggleClass("animated");
    });

    jQuery(document).ready(function ($) {
        $(".scroll, .navbar li a, .footer li a").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
        });
    });
    // count down starts
    $("#countdown").countdown({
            date: "21 may 2016 11:18:00",
            format: "on"
        },

        function () {
            // callback function
        });
});
function newW() {
    $(window).load();
    /*    $(document).ready(function () {
     });*/
}
setTimeout(newW, 20000);