document.getElementById("registration").addEventListener("submit", function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("registration"));
    fetch("/register", {
        method: "POST",
        body: formData
    }).then(response => {
        console.log("POST success");
    }).catch(error => {
        console.error('POST error: ', error);
    });
        event.target.reset();
    });