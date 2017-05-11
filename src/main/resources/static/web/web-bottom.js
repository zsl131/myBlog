$(function() {
    $(".read-count").each(function() {
        var thisObj = $(this);
        $.get("/public/articleReadCount", {}, function(res) {
            $(thisObj).find("b").html(res);
        });
    });
});