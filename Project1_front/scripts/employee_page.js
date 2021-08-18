document.getElementById("submit_req").addEventListener("click", submitReimbursement);

function submitReimbursement() {

let amount = document.getElementById("r_amt").value;
let description = document.getElementById("r_desc").value;
let type = document.querySelector('input[name=r_type]:checked').value;
let author = 'no author yet';

console.log(`${amount}, ${description}, ${type}, ${author}`);

    // let xhr = new XMLHttpRequest();
    // xhr.open("POST", "http://localhost:8080/Project1/reimburse");

    // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // let requestBody = `______=${_____}&_____=${_____}`;
    // xhr.send(requestBody);
}
