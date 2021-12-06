function saveUser() {
    let mydata={
        id:$("#idUser").val(),
        identification:$("#identificationUser").val(),
        name:$("#nameUser").val(),
        address:$("#addressUser").val(),
        cellphone:$("#cellphoneUser").val(),
        email:$("#emailUser").val(),
        password:$("#passwordUser").val(),
        zone:$("#zoneUser").val(),
        type:$("#typeUser").val(),
    };
    let dataToSend=JSON.stringify(mydata);
    console.log(mydata);
    $.ajax({
        url: "http://localhost:8080/api/user/save",
        type: "POST",
        data: mydata,
        dataType: "JSON",
        ContentType:"application/json;charset=utf-8",
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


