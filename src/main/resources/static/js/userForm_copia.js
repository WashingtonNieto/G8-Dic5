function saveUser() {
    let mydata={
        id:$("#idUser").val(),
        identification:$("#identificationUser").val(),
        name:$("#nameUser").val(),
        birthday:$("#birthDayUser").val(),
        monthBirthDay:$("#monthBirthDayUser").val(),
        address:$("#addressUser").val(),
        cellphone:$("#cellphoneUser").val(),
        email:$("#emailUser").val(),
        password:$("#passwordUser").val(),
        zone:$("#zoneUser").val(),
        type:$("#typeUser").val(),
    };
    let dataToSend=JSON.stringify(mydata);

    $.ajax({
        url: "http://localhost:8080/api/user/save",
        data: mydata,
        type: "POST",
        dataType: "JSON",
        success: function (respuesta) {
            console.log(respuesta);
            resultado(respuesta)	
        },

        error: function (xhr, status) {
            console.log("algo fallo");
        },
        complete: function (xhr, status) {
            console.log("Todo super bien"  + status);
        }
    });
}

function resultado(respuesta){
    let id = respuesta.id
    let nombre= respuesta.name

    if (id==null)
        alert("Usuario no registrado : " + nombre)
    else
        alert("Bienvenido : " + id + " "+ nombre)

}

function estadoInicial(){
    $("#username").focus()
}

