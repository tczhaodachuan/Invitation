$(window).on('load', function () {
    // cover page
    $("#cover").fadeOut(200);
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