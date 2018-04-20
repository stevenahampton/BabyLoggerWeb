$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/BabyLoggerWeb/webresources/com.stevenhampton.babyloggerweb.rest.event"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});