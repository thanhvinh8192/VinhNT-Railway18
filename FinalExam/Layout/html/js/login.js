

function login(){
    //get username & password
     var username = document.getElementById("username").value
     var password = document.getElementById("password").value
    //TODO validate
    // validate
    if (!username) {
        showNameErrorMessage("Please input username!");
        return
    }

    if (!password) {
        showNameErrorMessage("Please input password!");
        return
    }


    // validate username 6 -> 30 characters
    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 50) {
        // show error message
        showNameErrorMessage("Login fail!")
        return
    }

    //call API
    $.ajax({
        url: 'http://localhost:8888/api/login',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
        },
        success: function (data, textStatus, xhr) {
            //console.log(data)
            // save data to storage
            // https://www.w3schools.com/html/html5_webstorage.asp
             localStorage.setItem("Username", username);
             localStorage.setItem("FULL_NAME", data.firstName + " " + data.lastName);+
             localStorage.setItem("Password", password);

            // redirect to home page
            // https://www.w3schools.com/howto/howto_js_redirect_webpage.asp
            window.location.replace("http://127.0.0.1:5501/html/index.html");
        },
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                showNameErrorMessage("Login fail!");
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        } 
    })
}

function showNameErrorMessage(message) {
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = message;
}

function hideNameErrorMessage() {
    document.getElementById("nameErrorMessage").style.display = "none"
}