function displayEmployeeInfo(data) {

    //console.log(data);

    let tbodyRef = document.getElementById('emp_info_table').getElementsByTagName('tbody')[0];
    // let tbodyRef = document.getElementById('emp_info_table_rows').getElementsByTagName('tbody');
    for (let i = 0; i < data.length; i++) {
        //console.log(data[i]);

        if(data[i].userRole.userRole === 'employee') {

            let newRow = tbodyRef.insertRow();
    
            let c1 = newRow.insertCell();
            let username = document.createTextNode(data[i].userName);
            let c2 = newRow.insertCell();
            let password = document.createTextNode(data[i].passWord);
            let c3 = newRow.insertCell();
            let firstName = document.createTextNode(data[i].firstName);
            let c4 = newRow.insertCell();
            let lastName = document.createTextNode(data[i].lastName);
            let c5 = newRow.insertCell();
            let email = document.createTextNode(data[i].email);
            let c6 = newRow.insertCell();
            let empId = document.createTextNode(data[i].id);
    
            c1.appendChild(username);
            c2.appendChild(password);
            c3.appendChild(firstName);
            c4.appendChild(lastName);
            c5.appendChild(email);
            c6.appendChild(empId);
        }


    }



} 

async function getEmployeeInfoJSON() {

    let authToken = sessionStorage.getItem("token");

    let authArr  = authToken.split(":");
    let userId = authArr[0];

    let appUrl = "http://localhost:8080/Project1/users";

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













// functions for displaying one employees requests
document.getElementById("view_reimbursements").addEventListener("click", getReimbursementsJSON);

function displayReimbursements(data) {

   
    console.log(data);
    // console.log(data.id);

    
    let tbodyRef = document.getElementById('emp_table').getElementsByTagName('tbody')[0];
    
    let userId = document.getElementById('emp_id').value;

    console.log(userId);
    for (let i = 0; i < data.length; i++) {
        
        if (data[i].author.id == userId) {

            console.log('inside of the if statement')

            let resolverField;
            
            if(data[i].resolver === null) {
                resolverField = "none";
            } else {
                resolverField = data[i].resolver.userName;
            }
                
            
            
            let newRow = tbodyRef.insertRow();
            
            let c1 = newRow.insertCell();
            let amount = document.createTextNode(data[i].amount);
            let c2 = newRow.insertCell();
            let subDate = document.createTextNode(data[i].submitDate);
            let c3 = newRow.insertCell();
            let resDate = document.createTextNode(data[i].resolveDate);
            let c4 = newRow.insertCell();
            let desc = document.createTextNode(data[i].description);
            let c5 = newRow.insertCell();
            let author = document.createTextNode(data[i].author.userName);
            let c6 = newRow.insertCell();
            let resolver = document.createTextNode(resolverField);
            let c7 = newRow.insertCell();
            let status = document.createTextNode(data[i].status.status);
            let c8 = newRow.insertCell();
            let type = document.createTextNode(data[i].type.type);
            
            c1.appendChild(amount);
            c2.appendChild(subDate);
            c3.appendChild(resDate);
            c4.appendChild(desc);
            c5.appendChild(author);
            c6.appendChild(resolver);
            c7.appendChild(status);
            c8.appendChild(type);





        }

    
    
    
    
    }
    
    




}



async function getReimbursementsJSON() {

   

    let authToken = sessionStorage.getItem("token");

    // let authArr  = authToken.split(":");
    // let userId = authArr[0];
    //console.log('user ID: ' + userId);

    

    
    let appUrl = "http://localhost:8080/Project1/reimburse";


    let header = new Headers();
    header.append('Authorization', authToken);

    let response = await fetch(appUrl, {
        headers: {
            'Authorization': header
        }
    });

    if (response.status >= 200 && response.status < 300) {
        let data = await response.json();
        //let reimbJSON = fetch(data);
        


        displayReimbursements(data);


    }

}