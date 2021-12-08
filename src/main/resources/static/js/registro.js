//Manejador "POST"
function registrar() {

    //if($("#identificationUser") == "" || $("#nameUser").val() == 0){
    //    alert("Todos los campos son obligatorios")
    //}else{
            let element = {
                name: $("#nameUser").val(),
                password : $("#passwordUser").val()
            }

            let dataToSend = JSON.stringify(elemento);

            $.ajax({
                type: "POST",
                contentType: "application/json",
                //url:"http://168.138.247.22:80/api/Category/save",
                url: "http://localhost:8080/api/user/save",
                data: dataToSend,
                datatype: "json",

                success: function (response) {
                    console.log(response);
                    //Limpiar Campos
                    $("#resultado").empty();
                    $("#name").val("");
                    $("#description").val("");

                    //Listar Tabla
                    alert("Se ha guardado Correctamente!")
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("NO se ha guardado Correctamente!")
                }
            });
    //}
}
