document.getElementById("login_button").addEventListener("click", login);


//console.log("outside login");
function login() {
    
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    
    //console.log(`${username}, ${password}`);
    

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/Project1/auth"); // should this link "go" here? use POST method ??

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 && xhr.status === 200) {
            let authToken = xhr.getResponseHeader("Authorization");

            sessionStorage.setItem("token", authToken);

            let authArr  = authToken.split(":");
            let userType = authArr[1];
            //sessionStorage.setItem("user", username);


            //
            console.log(authArr);

            if(userType.includes('employee')) {
                window.location.href="employee_page.html";
                
                
            } else if (userType.includes('manager')) {
                window.location.href="manager_page.html";
            }

           
        } else if (xhr.readyState === 4){
            console.log('Incorrect username/password or error occured...');
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let requestBody = `username=${username}&password=${password}`;
    xhr.send(requestBody);

}