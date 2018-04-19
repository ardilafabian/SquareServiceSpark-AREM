$("input").click(function(){
    $("#submit").attr("href", "http://localhost:4567/square?num="+$("#number").val());
});


