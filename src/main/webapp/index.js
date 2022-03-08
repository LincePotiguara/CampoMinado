function loadDoc() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.responseText;
    }
    xhttp.open("GET", "./api/hello?value=1", true);
    xhttp.send();
}

function ApiResponse(action)
{
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        document.getElementById("messenger").innerHTML = this.responseText;
    }
    apiRedirect = "./api/hello?value=1";
    switch (action)
    {
        case "novo jogo":   {apiRedirect = "./api/novo-jogo"} break;
        case "continuar":   {apiRedirect = "./api/continuar"} break;
        case "dificuldade": {apiRedirect = "./api/dificuldade"} break;
        case "creditos":    {apiRedirect = "./api/creditos"} break;
    }
    console.log(apiRedirect);
    xhttp.open("GET", apiRedirect, true);
    xhttp.send();
}
function toggleNav()
{
    if(document.getElementById("menu").getBoundingClientRect().width !== 0)
    {
        closeNav()
    } else {
        openNav()
    }
}
function openNav()
{
    document.getElementById("menu").style.width = "320px";
    document.getElementById("menu").style.padding = "0 0 0 10px"
    document.getElementById("etc").style.marginLeft = "330px";
}

function closeNav()
{
    document.getElementById("menu").style.width = "0";
    document.getElementById("menu").style.padding = "0"
    document.getElementById("etc").style.marginLeft= "0";
}
