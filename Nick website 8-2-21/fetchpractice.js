document.getElementById('getQuote').addEventListener("click", getData);

let apiURL = 'https://breaking-bad-quotes.herokuapp.com/v1/quotes';

async function getData() {
    
    let response = await fetch(apiURL);
    
    if (response.status >= 200 && response.status < 300) {
        let data = await response.json();
        populateData(data);
    } else {
        console.log('unable to retrieve data');
    }

}


function populateData(response) {
    console.log(response);

    let dataSection = document.getElementById('data');

    dataSection.innerHTML = '';

    let showQuote = document.createElement('h1');
    let showAuther = document.createElement('h3');
    
    showQuote.innerHTML = response[0].quote;
    showAuther.innerHTML = response[0].author;


    dataSection.appendChild(showQuote);
    dataSection.appendChild(showAuther);

}