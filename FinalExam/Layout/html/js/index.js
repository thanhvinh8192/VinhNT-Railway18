$(document).ready(function () {
    let menuList = document.getElementsByClassName('sidebar-link')
    // Lặp qua từng phần tử trong kết quả và gán sự kiện
    menuList[1].onclick = function(){
        $('.content').load('home.html')
        loadHome()
    }
    menuList[2].onclick = function(){
        $('.content').load('accounts.html')
        loadAccount()
    }
    menuList[3].onclick = function(){
        $('.content').load('department.html')
        loadDepartment()
    }
})

$(function () {
    if (!isLogin()) {
        window.location.replace("http://127.0.0.1:5501/html/login.html")
    }
    document.getElementById("user").innerHTML = localStorage.getItem("FULL_NAME")
    document.getElementById("sidebar-user").innerHTML = localStorage.getItem("FULL_NAME")
    $('.content').load('home.html', function(){
        document.getElementById("home-user").innerHTML = localStorage.getItem("FULL_NAME")
    }) 
})

function isLogin() {
    if (localStorage.getItem("Username")) {
        return true;
    }
    return false;
}

//logout
function logout(){
    localStorage.removeItem("Username")
    localStorage.removeItem("Password")

    window.location.replace("http://127.0.0.1:5501/html/login.html")
}