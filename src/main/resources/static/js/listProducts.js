function showAlert(id) {
    document.getElementsByClassName("blackWindow")[0].style.display = "block";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "block";    

    var btnDelete = document.getElementById("btnDelete");
    btnDelete.setAttribute("href", "/products/delete/" + id);
}



function closeAlert() {
    document.getElementsByClassName("blackWindow")[0].style.display = "none";
    document.getElementsByClassName("jumbotronArea")[0].style.display = "none";
}



window.onload = function() {
    var searchBar = window.location.search;
    if (searchBar) {
        var mensage = searchBar.slice(1, searchBar.length);
        var msgBody = mensage.split("=");
        var alert = document.getElementsByClassName("alert")[0];

        switch (msgBody[0]) {
            case "save": alert.className = "alert alert-success"; break;
            case "update": alert.className = "alert alert-warning"; break;
            case "delete": alert.className = "alert alert-danger"; break;
            default: console.log("Fudeu!"); break;
        }

        alert.innerHTML = msgBody[1].replaceAll("+", " ");
        var alertArea = document.getElementsByClassName("alertArea")[0];
        alertArea.removeAttribute("hidden");
        setTimeout(function() {
            alertArea.setAttribute("hidden", "true");
        }, 3000);
    }
}


