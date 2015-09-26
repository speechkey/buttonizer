/**
 * Created by agrebenkin on 26.9.15.
 */

$(document).ready(function() {
    $.getJSON('_ah/api/buttonizer/v0.0.0.1/channel', function(data) {
        channel = new goog.appengine.Channel(data.token);
        socket = channel.open();

        socket.onopen = function() { console.log("DEBUG: Cannel buttonizer-client is connected.")};
        socket.onmessage = function(message) {
            console.log('Button received: ' + message);

            $("#button").removeClass("btn-danger");
            $("#button").addClass("btn-success");
            $("#button").html($("#button").data("msg-change") + message.data);
            $("#step2").removeClass("hidden");
        };
        socket.onerror = function() { console.log("ERROR: An error in channel occurs."); };
        socket.onclose = function() { console.log("DEBUG: Channel connection is closed."); };
    });

    var pair = function(data) {
        $.ajax({
            type: "POST",
            url: '_ah/api/buttonizer/v0.0.0.1/pair',
            data: data,
            success: function(data){ console.info("DEBUG: button was successfully paired: " + data);},
            failure: function(msg) { console.info("ERROR: unable to pair the button " + data + ", an error occures " + msg);},
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        });
    }
});