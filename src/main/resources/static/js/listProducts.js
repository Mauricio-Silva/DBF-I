function showAlert() {
    document.getElementsByClassName("blackWindow")[0].style.display = "block";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "block";    
}


function closeAlert() {
    document.getElementsByClassName("blackWindow")[0].style.display = "none";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "none";
}


function sendForm(self) {
    console.log('evento: ' + self.type);
    console.log('componente: ' + self.target);
    console.log('componente: ' + this);

    this.children[0].submit();
}

window.onload = setTimeout(function() {
    var deleteUser = document.querySelectorAll(".deleteProduct");
    console.log(deleteUser);
    deleteUser.forEach(function(deleteItem) {
        deleteItem.addEventListener("click", sendForm);
    });
}, 1000);