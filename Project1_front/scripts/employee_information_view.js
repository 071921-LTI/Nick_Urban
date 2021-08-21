
function displayEmployeeInfo(data) {

    console.log(data);

    let tbodyRef = document.getElementById('emp_info_table').getElementsByTagName('tbody')[0];
    // let tbodyRef = document.getElementById('emp_info_table_rows').getElementsByTagName('tbody');
    // for (let i = 0; i < data.length; i++) {



        let newRow = tbodyRef.insertRow();

        let c1 = newRow.insertCell();
        let username = document.createTextNode(data.userName);
        let c2 = newRow.insertCell();
        let password = document.createTextNode(data.passWord);
        let c3 = newRow.insertCell();
        let firstName = document.createTextNode(data.firstName);
        let c4 = newRow.insertCell();
        let lastName = document.createTextNode(data.lastName);
        let c5 = newRow.insertCell();
        let email = document.createTextNode(data.email);

        c1.appendChild(username);
        c2.appendChild(password);
        c3.appendChild(firstName);
        c4.appendChild(lastName);
        c5.appendChild(email);

    // }



} 


async function getEmployeeInfoJSON() {

    let authToken = sessionStorage.getItem("token");

    let authArr  = authToken.split(":");
    let userId = authArr[0];

    let appUrl = "http://localhost:8080/Project1/users/" + userId;

    let header = new Headers();
    header.append('Authorization', authToken);

    let response = await fetch(appUrl, {
        headers: {
            'Authorization': header
        }
    });

    if (response.status >= 200 && response.status < 300) {
        let data = await response.json();

        displayEmployeeInfo(data);

    }

}