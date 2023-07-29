loadAllCustomers();

function loadAllCustomers(){
    $("#tblCustomer").empty();
    $.ajax({
        url:"http://localhost:8080/pos/customer-manager",
        method:"GET",
        success:function (resp){
            console.log(resp);
            for (const customer of resp) {
                let row=`<tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.address}</td><td>${customer.salary}</td></tr>`;
                $("#tblCustomer").append(row);
            }
            bindClickEvents();
        }
    });
}

function bindClickEvents(){
    $("#tblCustomer>tr").click(function (){
        let id=$(this).children().eq(0).text();
        let name=$(this).children().eq(1).text();
        let address=$(this).children().eq(2).text();
        let salary=$(this).children().eq(3).text();

        $("#cusID").val(id);
        $("#cusName").val(name);
        $("#cusAddress").val(address);
        $("#cusSalary").val(salary);
    });
}

$("#btnGetAllCustomer").click(function (){
    loadAllCustomers();
})


$("#btnSaveCustomer").click(function (){
    var data = $("#customerForm").serialize();
    $.ajax({
        url: "http://localhost:8080/pos/customer-manager",
        method: "POST",
        data:data,
        success:function (resp){
            alert(resp);
            loadAllCustomers();
        },error: function (ob,textStatus, error){
            alert(textStatus);
            console.log(ob.responseText);
        }
    });
});

// // =====================================================DELETE==========================================================

$("#btnDeleteCustomer").click(function (){
    var customerID = $("#cusID").val();
    $.ajax({
        url :"http://localhost:8080/pos/customer-manager?cusID="+customerID,
        method:"DELETE",
        success:function (resp){
            alert(resp);
            loadAllCustomers();
        }
    });
});


$("#btnUpdateCustomer").click(function (){
    var customerID = $("#cusID").val();
    var customerName = $("#cusName").val();
    var customerAddress = $("#cusAddress").val();
    var customerSalary = $("#cusSalary").val();
    var dataForm = {
        "customerID": customerID,
        "customerName": customerName,
        "customerAddress": customerAddress,
        "customerSalary": customerSalary
    };
    $.ajax({
        url: "http://localhost:8080/pos/customer-manager",
        data: dataForm,
        method:"PUT",
        success:function (resp){
            alert(resp);
            loadAllCustomers();
        }
    })
});