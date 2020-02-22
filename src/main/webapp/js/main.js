let btn = document.getElementById("btn");
let info = document.getElementById("data-info");
let submit = document.getElementById("submit");
let rlt = document.getElementById("result");
let send = document.getElementById("send");
let progress = document.getElementById("progress");
let future = document.getElementById("future");
let history = document.getElementById("history");
let listUser = document.getElementById("listUser");

listUser.addEventListener("click", function(){
    let ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8181/user');
    ourRequest.onload = function(){
        console.log(ourRequest.responseText);
        let ourData = JSON.parse(ourRequest.responseText);
        listUsers(ourData);
    };
    ourRequest.send();
})

send.addEventListener("click", function(){
    let obj = {
        "login": "mojombo",
        "id": 1,
        "type": "User"
    };
    let json = JSON.stringify(obj);
    let ourRequest = new XMLHttpRequest();
    ourRequest.open('PUT', 'http://localhost:8181/send/');
    ourRequest.setRequestHeader('Content-type','application/json; charset=utf-8');
    ourRequest.onload = function(){
        console.log(ourRequest.responseText);
    };
    ourRequest.send(json);
})

submit.addEventListener("click", function(){
    let ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8181/login');
    ourRequest.onload = function(){
        console.log(ourRequest.responseText);
        let ourData = JSON.parse(ourRequest.responseText);
        validateForm(ourData);
    };
    ourRequest.send();
});

btn.addEventListener("click", function(){
    let ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'http://localhost:8181/greeting');
    ourRequest.onload = function(){
        let ourData = JSON.parse(ourRequest.responseText);
        renderHTML(ourData);
    };
    ourRequest.send();
});

function listUsers(data){
    let li = document.createElement("li");
    for(let i = 0; i < data["history"].length; i++){
        li.appendChild(document.createTextNode(data["history"][i].userName));
        history.appendChild(li);
        li = document.createElement("li");
    }
    for(let i = 0; i < data["future"].length; i++){
        li.appendChild(document.createTextNode(data["future"][i].userName));
        future.appendChild(li);
        li = document.createElement("li");
    }
    for(let i = 0; i < data["progress"].length; i++){
        li.appendChild(document.createTextNode(data["progress"][i].userName));
        progress.appendChild(li);
        li = document.createElement("li");
    }
}

function validateForm(data){
    let result = "LogIn Failed";
    let userName = document.getElementById("userName").value;
    let userPassword = document.getElementById("userPassword").value;
    for(let i = 0; i < data.length; i++){
        if(data[i].userName === userName && data[i].userPassword === userPassword){
            result = "LogIn Success";
            break;
        }
    }
    rlt.innerHTML = result;
}

function renderHTML(data){
    let htmlStr = "";
    for(let i = 0; i < data.length; i++){
        htmlStr += "<p>" + data[i].id + ": " + data[i].content +"</p>";
    }
    info.insertAdjacentHTML('beforeend', htmlStr);
}

