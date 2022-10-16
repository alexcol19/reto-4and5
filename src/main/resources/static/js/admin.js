function traerAdmins(){
    $ajax({
        url: "http//localhost:8080/api/Admin/all",
        type: "GET",
        dataType: 'json',
        success: function(respuesta){
            pintarAdmins(respuesta);
        },
        error: function(respuesta, xhr){
            alert("error de peticion");
        } 
    });
}

function pintarAdmins(datos){
    let html = "";
    html += "<thead>";
    html += "<tr>";
    html += "<th>Nombre</th>";
    html += "<th>Correo</th>";
    html += "<th>Accion</th>";
    html += "</tr>";
    html += "</thead>";

    html += "<tbody"

    for(datos of datos){
        html += "<tr>"
        html += "<td>"+datos.name+"</td>";
        html += "<td>"+datos.email+"</td>";
        html += "<td><button class='btn btn-danger' onclick='eliminarAdmin("+datos.idAdmin+")'>Eliminar</button></td>";
        html += "<tr>"
    }

    html += "</tbody"

    $("#tablaAdmins").html(html);

}

function guardarAdmin(){
    let datos={
        name:$("#nombre").val(),
        mail:$("#email").val(),
        password:$("#password").val(),
    }

    let dataToSend = JSON.stringify(datos);

    $ajax({
        url: "http//localhost:8080/api/Admin/save",
        type: "POST",
        dataType: 'json',
        contentType: 'application/jason',
        data: dataToSend,
        success: function(respuesta){
            $("#nombre").val("");
            $("#email").val("");
            $("#password").val("");
            traerAdmins();
        },
        error: function(respuesta, xhr){
            alert("error de peticion");
        } 
    });

}

function eliminarAdmin(idAdmin){
    $ajax({
        url: "http//localhost:8080/api/Admin/"+idAdmin,
        type: "DELETE",
        success: function(respuesta){
            traerAdmins();
        },
        error: function(respuesta, xhr){
            alert("error de peticion");
        } 
    });


}