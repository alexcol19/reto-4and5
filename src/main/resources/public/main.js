



//FUNCIONES CATEGORIA
function leerCategory(){
    //Funcion GET
    $.ajax({
        url : 'https://150.230.25.129api/Category/all',
        type : 'GET',
        dataType : 'json',

        success : function(disfraces){
            let items=disfraces.items;
            $("#TbodyCategory").empty();
            for(let i=0; i < items.length ; i++) {
                let tableDisfraz = document.createElement("tr")
                tableDisfraz.innerHTML += "<td><center>"+items[i].name+"</center></td>";
                tableDisfraz.innerHTML += "<td><center>"+items[i].description+"</center></td>";
                
                tableDisfraz.innerHTML += "<td><button onclick='borrarDisfraz(" + items[i].id + ")'>Borrar</button></tr>";

                $("#TbodyCategory").append(tableDisfraz);
            }
        }

    });
}


function guardarCategory(){
    let nombreDisfrazCategory=$('#nombreDisfrazcatgory').val();
    let descripcionDisfrazCategory=$('#descripcionDisfrazCategory').val();
    

    let data={
        name:nombreDisfrazCategory,
        description:descripcionDisfrazCategory,
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://150.230.25.129api/Category/save',
        type : 'POST',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(){
            $('#nombreDisfrazCategory').val("");
            $('#descripcionDisfrazCategory').val("");
        },
        complete : function(){
            leerCategory();
        }
    });
}


function editarCategory(){
    let nombreDisfrazCategory=$('#nombreDisfrazcatgory').val();
    let descripcionDisfrazCategory=$('#descripcionDisfrazCategory').val();
    

    let data={
        name:nombreDisfrazCategory,
        description:descripcionDisfrazCategory,
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'PUT',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(){
            $('#nombreDisfrazCategory').val("");
            $('#descripcionDisfrazCategory').val("");
        },
        complete : function(){
            leerCategory();
        }
    });
}


function borrarCategory(idDisfraz){
    let data={
        id:idDisfraz
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){

            $('#idDisfraz').val("");
            $('#marcaDisfraz').val("");
            $('#modeloDisfraz').val("");
            $('#categoryIdDifraz').val("");
            $('#nombreDisfraz').val("");
        },
        complete : function(){
            leerDisfraces();
        }
    });
}





//FUNCIONES CLIENTE
function leerClientes(){
    //Funcion GET
    $.ajax({
        url : 'https://150.230.25.129/api/Client/all',
        type : 'GET',
        dataType : 'json',

        success : function(clientes){

            let items=clientes.items;
            $("#Tbodycliente").empty();

            for(let i=0; i < items.length ; i++) {
                let table = document.createElement("tr")
                table.innerHTML += "<tr><td><center>"+items[i].id+"</center></td>";
                table.innerHTML += "<td><center>"+items[i].name+"</center></td>";
                table.innerHTML += "<td><center>"+items[i].email+"</center></td>";
                table.innerHTML += "<td><center>"+items[i].age+"</center></td>";
                table.innerHTML += "<td><button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button></tr>";

                $("#Tbodycliente").append(table);
            }
        }

    });
}


function guardarCliente(){
    let idCliente=$('#idCliente').val();
    let nombreCliente=$('#nombreCliente').val();
    let mailCliente=$('#mailCliente').val();
    let edadCliente=$('#edadCliente').val();

    let data={
        id:idCliente,
        name:nombreCliente,
        email:mailCliente,
        age:edadCliente
    };

    let dataToSend=JSON.stringify(data);
    //console.log(data);
    //console.log(dataToSend);

    $.ajax({
        url : 'https://',
        type : 'POST',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(cliente){

            $('#idCliente').val("");
            $('#nombreCliente').val("");
            $('#mailCliente').val("");
            $('#edadCliente').val("");
        },
        complete : function(){
            leerClientes();
        }
    });
}


function editarCliente(){
    let idCliente=$('#idCliente').val();
    let nombreCliente=$('#nombreCliente').val();
    let mailCliente=$('#mailCliente').val();
    let edadCliente=$('#edadCliente').val();

    let data={
        id:idCliente,
        name:nombreCliente,
        email:mailCliente,
        age:edadCliente
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'PUT',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(cliente){

            $('#idCliente').val("");
            $('#nombreCliente').val("");
            $('#mailCliente').val("");
            $('#edadCliente').val("");
        },
        complete : function(){
            leerClientes();
        }
    });
}


function borrarCliente(idCliente){
    let data={
        id:idCliente
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){

            $('#idCliente').val("");
            $('#nombreCliente').val("");
            $('#mailCliente').val("");
            $('#edadCliente').val("");
        },
        complete : function(){
            leerClientes();
        }
    });
}















//FUNCIONES MESSAGE
function leerMensajes(){
    //Funcion GET
    $.ajax({
        url : 'https://',
        type : 'GET',
        dataType : 'JSON',

        success : function(mensajes){

            let items=mensajes.items;
            $("#TbodyMessage").empty();

            for(let i=0; i < items.length ; i++) {
                let tableMessage = document.createElement("tr")
                tableMessage.innerHTML += "<tr><td><center>"+items[i].id+"</center></td>";
                tableMessage.innerHTML += "<td><center>"+items[i].messagetext+"</center></td>";
                tableMessage.innerHTML += "<td><button onclick='borrarMensaje(" + items[i].id + ")'>Borrar</button></tr>";

                $("#TbodyMessage").append(tableMessage);
            }
        }

    });
}


function guardarMensaje(){
    let idMessage=$('#idMessage').val();
    let message=$('#message').val();

    let data={
        id:idMessage,
        messagetext:message
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'POST',
        //dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/json',

        success : function(){

            $('#idMessage').val("");
            $('#message').val("");
        },
        complete : function(){
            leerMensajes();
        }
    });
}


function editarMensaje(){
    let idMessage=$('#idMessage').val();
    let message=$('#message').val();

    let data={
        id:idMessage,
        messagetext:message
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'PUT',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(mensaje){

            $('#idMessage').val("");
            $('#message').val("");
        },
        complete : function(){
            leerMensajes();
        }
    });
}


function borrarMensaje(idMessage){
    let data={
        id:idMessage
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        url : 'https://',
        type : 'DELETE',
        dataType : 'JSON',
        data : dataToSend,
        contentType : 'application/JSON',

        success : function(borrando){

            $('#idMessage').val("");
            $('#message').val("");
        },
        complete : function(){
            leerMensajes();
        }
    });
}