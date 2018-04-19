/*$("button").click(function(){
    $("#submit").attr("href", "http://localhost:4567/square?num="+$("#number").val());
});*/

$('button').click(function(){
    console.log("aaaaa");
   window.location.href='http://localhost:4567/square?num='+$('#number').val();
})


