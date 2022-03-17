function showAlert() {
    document.getElementsByClassName("blackWindow")[0].style.display = "block";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "block";    
    console.log(this);
}


function closeAlert() {
    document.getElementsByClassName("blackWindow")[0].style.display = "none";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "none";
}

