//FUNCIONES DISFRAZ
/*function leerDisfraces(){
    //Funcion GET
    $.ajax({
        //url : 'https://150.230.25.129:8080/api/Costume/all',
        url : 'https://localhost:8080/api/Costume/all',
        type : 'GET',
        dataType : 'json',

        success : function(disfraces){
            let items=disfraces.items;
            $("#TbodyDisfraz").empty();
            for(let i=0; i < items.length ; i++) {
                let tableDisfraz = document.createElement("tr")
                tableDisfraz.innerHTML += "<td><center>"+items[i].brand+"</center></td>";
                tableDisfraz.innerHTML += "<td><center>"+items[i].name+"</center></td>";
                tableDisfraz.innerHTML += "<td><center>"+items[i].year+"</center></td>";
                tableDisfraz.innerHTML += "<td><center>"+items[i].description+"</center></td>";

                tableDisfraz.innerHTML += "<td><button onclick='borrarDisfraz(" + items[i].id + ")'>Borrar</button></tr>";

                $("#TbodyDisfraz").append(tableDisfraz);
            }
        }

    });
}*/

function tablaDisfraz(){
    let html=""
}


function guardarDisfraz(){
    let marcaDisfraz=$('#marcaDisfraz').val();
    let nombreDisfraz=$('#nombreDisfraz').val();
    let anioDisfraz=$('#anioDisfraz').val();
    let descripcionDisfraz=$('#descripcionDisfraz').val();
    let categoryDisfraz=$('#categoryDisfraz').val();


    let data={
        brand:marcaDisfraz,
        name:nombreDisfraz,
        year:anioDisfraz,
        description:descripcionDisfraz,
        category:categoryDisfraz,
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        //url : 'https://150.230.25.129:8080/api/Costume/save',
        url : 'https://localhost:8080/api/Costume/save',
        type : 'POST',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(disfraz){

            $('#marcaDisfraz').val("");
            $('#nombreDisfraz').val("");
            $('#anioDisfraz').val("");
            $('#descripcionDisfraz').val("");
            $('#categoryDisfraz').val("");
        },
        complete : function(){
            leerDisfraces();
        }
    });
}


function editarDisfraz(){
    let marcaDisfraz=$('#marcaDisfraz').val();
    let nombreDisfraz=$('#nombreDisfraz').val();
    let anioDisfraz=$('#anioDisfraz').val();
    let descripcionDisfraz=$('#descripcionDisfraz').val();
    let categoryDisfraz=$('#categoryDisfraz').val();

    let data={
        brand:marcaDisfraz,
        name:nombreDisfraz,
        year:anioDisfraz,
        description:descripcionDisfraz,
        category:categoryDisfraz,
    };

    let dataToSend=JSON.stringify(data);

    $.ajax({
        //url : 'hhttps://150.230.25.129:8080/api/Costume/update',
        url : 'https://localhost:8080/api/Costume/update',
        type : 'PUT',
        //dataType : 'json',
        data : dataToSend,
        contentType : 'application/json',

        success : function(disfraz){

            $('#marcaDisfraz').val("");
            $('#nombreDisfraz').val("");
            $('#anioDisfraz').val("");
            $('#descripcionDisfraz').val("");
            $('#categoryDisfraz').val("");
        },
        complete : function(){
            leerDisfraces();
        }
    });
}


function borrarDisfraz(idDisfraz){
    let data={
        id:idDisfraz
    };
    let dataToSend=JSON.stringify(data);

    $.ajax({
        //url : 'hhttps://150.230.25.129:8080/api/Costume/delete',
        url : 'https://localhost:8080/api/Costume/delete',
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