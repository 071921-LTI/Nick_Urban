window.addEventListener('load', displayReimbursements);



function displayReimbursements() {


   
    
    
    let data = getReimbursementsJSON();
    // data.then((response) => response.json())
    // .then((reimbs) => {
    //     console.log(reimbs);
    // });
    console.log(data);
    
    // for (let i = 0; i < data.length; i++) {
    //     console.log(data[i]);
    // }
    
    


    let tbodyRef = document.getElementById('emp_table').getElementsByTagName('tbody')[0];
    
    let newRow = tbodyRef.insertRow();
    
    let c1 = newRow.insertCell();
    let amount = document.createTextNode('amount');
    let c2 = newRow.insertCell();
    let subDate = document.createTextNode('subDate');
    let c3 = newRow.insertCell();
    let resDate = document.createTextNode('resDate');
    let c4 = newRow.insertCell();
    let desc = document.createTextNode('desc');
    let c5 = newRow.insertCell();
    let author = document.createTextNode('author');
    let c6 = newRow.insertCell();
    let resolver = document.createTextNode('resolver');
    let c7 = newRow.insertCell();
    let status = document.createTextNode('status');
    
    
    c1.appendChild(amount);
    c2.appendChild(subDate);
    c3.appendChild(resDate);
    c4.appendChild(desc);
    c5.appendChild(author);
    c6.appendChild(resolver);
    c7.appendChild(status);


}



async function getReimbursementsJSON() {

   

    let authToken = sessionStorage.getItem("token");

    let authArr  = authToken.split(":");
    let userId = authArr[0];
    //console.log('user ID: ' + userId);


    
    let appUrl = "http://localhost:8080/Project1/reimburse/" + userId;


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
        
        return data;

    
    }

}