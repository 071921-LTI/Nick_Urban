function displayReimbursements(data) {








    let tbodyRef = document.getElementById('all_reimb_table').getElementsByTagName('tbody')[0];


    for (let i = 0; i < data.length; i++) {


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


async function getReimbursementsJSON() {

   

    let authToken = sessionStorage.getItem("token");

    let authArr  = authToken.split(":");
    //let userId = authArr[0];
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