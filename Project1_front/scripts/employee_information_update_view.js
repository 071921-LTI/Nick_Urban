document.getElementById("submit_update").addEventListener("click", updateUserInfo);
 
 function updateUserInfo() { // needs to be async??

    let userName = document.getElementById("new_username").value;
    let passWord = document.getElementById("new_password").value;
    let firstName = document.getElementById("new_firstname").value;
    let lastName = document.getElementById("new_lastname").value;
    let email = document.getElementById("new_email").value;


    
    let authToken = sessionStorage.getItem("token");
    
    let authArr  = authToken.split(":");
    let userId = authArr[0];
    
    // let appUrl = "http://localhost:8080/Project1/users/" + userId;
    
    // let header = new Headers();
    // header.append('Authorization', authToken);
    
    // let response = await fetch(appUrl, {
    //     headers: {
    //         'Authorization': header
    //     }
    // });
    
    // if (response.status >= 200 && response.status < 300) {
    //     let data = await response.json();
        
    // }
    
    let xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/Project1/users"); // need an extra slash at end?

    xhr.setRequestHeader("Content-Type", "application/json");
    let updatedEmployee = {
        id: userId, 
        userName: userName,
        passWord: passWord,
        firstName: firstName,
        lastName: lastName,
        email: email
    }

    console.log(updatedEmployee);

    // uncomment this when ready
    //
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", authToken);
    xhr.send(JSON.stringify(updatedEmployee));
}




// old original (doesnt work tho,  just a back-up)

// function updateUserInfo(data) {

//     let userName = document.getElementById("new_username").value;
//     let passWord = document.getElementById("new_password").value;
//     let firstName = document.getElementById("new_firstname").value;
//     let lastName = document.getElementById("new_lastname").value;
//     let email = document.getElementById("new_email").value;


//     let xhr = new XMLHttpRequest();
//     xhr.open("PUT", "http://localhost:8080/Project1/users"); // need an extra slash at end?

//     xhr.setRequestHeader("Content-Type", "application/json");
//     let updatedEmployee = {
//         id: ______, // what to do with id ??
//         userName: userName,
//         passWord: passWord,
//         firstName: firstName,
//         lastName: lastName,
//         email: email
//     }
// }

// async function getEmployeeInfoJSON() {

//     let authToken = sessionStorage.getItem("token");

//     let authArr  = authToken.split(":");
//     let userId = authArr[0];

//     let appUrl = "http://localhost:8080/Project1/users/" + userId;

//     let header = new Headers();
//     header.append('Authorization', authToken);

//     let response = await fetch(appUrl, {
//         headers: {
//             'Authorization': header
//         }
//     });

//     if (response.status >= 200 && response.status < 300) {
//         let data = await response.json();

//         updateUserInfo(data);

//     }

// }