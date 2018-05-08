$(document).ready(function() {
    $.ajax(
                {
                    type: "GET",
                    url: 'http://localhost:8080/BabyLoggerWeb/webresources/com.stevenhampton.babyloggerweb.rest.event',
                    data: "{1}",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {

                        alert('success');
                        $.each(data, function (i, theItem) {
                            var combo = document.getElementById("cboFastBikes");
                            var option = document.createElement("option");
                            option.text = theItem.toString();
                            option.value = theItem.toString();
                            try {
                                //alert('success add combo');
                                combo.add(option, null); // Other browsers
                            }
                            catch (error) {
                                alert('error found');
                                combo.add(option); // really old browser
                            }

                        });
                    },
                    error: function (msg, url, line) {
                        alert('error trapped in error: function(msg, url, line)');
                        alert('msg = ' + msg + ', url = ' + url + ', line = ' + line);

                    }
                });
});