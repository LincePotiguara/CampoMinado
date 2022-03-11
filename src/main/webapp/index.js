
function ApiResponse(action, param_tam, param_dif, param_lin, param_col)
{
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function()
    {
        document.getElementById("messenger").innerHTML = this.responseText;
    }
    apiRedirect = "./api/hello?value=1";
    switch (action)
    {
        case "novo jogo":   {apiRedirect = "./api/tamanho"} break;
        case "reset":       {apiRedirect = "./api/continuar?tamanho=" + param_tam + "&dificuldade=" + param_dif} break;
        case "continuar":   {apiRedirect = "./api/continuar?tamanho=" + param_tam + "&dificuldade=" + param_dif + "&linha=" + param_lin + "&coluna=" + param_col} break;
        case "dificuldade": {apiRedirect = "./api/dificuldade?tamanho=" + param_tam} break;
        case "tamanho":     {apiRedirect = "./api/tamanho"} break;
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
