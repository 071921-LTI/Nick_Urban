// and an event listener up here **

function displayReimbursements(data) {








    let tbodyRef = document.getElementById('pending_reimb_table').getElementsByTagName('tbody')[0];


    for (let i = 0; i < data.length; i++) {

        if (data[i].status.status === "pending") {

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
            let c9 = newRow.insertCell();
            let reimbId = document.createTextNode(data[i].id);
            
            c1.appendChild(amount);
            c2.appendChild(subDate);
            c3.appendChild(resDate);
            c4.appendChild(desc);
            c5.appendChild(author);
            c6.appendChild(resolver);
            c7.appendChild(status);
            c8.appendChild(type);
            c9.appendChild(reimbId);
        }



    }





}


async function getPendingReimbursementsJSON() {

   

    let authToken = sessionStorage.getItem("token");

    let authArr  = authToken.split(":");
    //let userId = authArr[0];
    //console.log('user ID: ' + userId);


    
    let appUrl = "http://localhost:8080/Project1/reimburse"; // need an extra slash here?


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
        
        console.log(data);

        

        displayReimbursements(data);


    }

}

document.getElementById("submit_update").addEventListener("click", submitUpdate);

function submitUpdate() {

    let updateReimbId = document.getElementById("update_reimb_id").value;
    let udateStatus = document.querySelector('input[name=update_status]:checked').value;


    let authToken = sessionStorage.getItem("token");
    
    let authArr  = authToken.split(":");
    let resolverId = authArr[0]; // need to find a way to send the resolver information...


    let xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/Project1/reimburse");

    xhr.setRequestHeader("Content-Type", "application/json");
    let reimbursement = {
        id: updateReimbId,
        status: udateStatus
    }

    console.log(reimbursement);


    // uncomment this when ready
    //
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.setRequestHeader("Authorization", authToken);
    xhr.send(JSON.stringify(reimbursement));
}

