document.getElementById("submit_req").addEventListener("click", submitReimbursement);

function submitReimbursement() {

let amount = document.getElementById("r_amt").value;
let description = document.getElementById("r_desc").value;
let type = document.querySelector('input[name=r_type]:checked').value;

//maybe not use this here
// let authArr  = authToken.split(":");
// let userId = authArr[0];
      
    

//console.log(`${amount}, ${description}, ${type}, ${author}`);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/Project1/reimburse");


    xhr.setRequestHeader("Content-Type", "application/json");
    let reimbursement = {
        amount: amount,
        description: description,
        type: type,
        id: null
    }
    //xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //let requestBody = `amount=${amount}&description=${description}&type=${type}&author=${author}`;
    // json.stringify

    console.log(JSON.stringify(reimbursement));

    let token = sessionStorage.getItem("token");
    xhr.setRequestHeader("Authorization", token);
    xhr.send(JSON.stringify(reimbursement));
}
