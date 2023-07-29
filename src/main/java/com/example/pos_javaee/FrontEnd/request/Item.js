loadAllItem();

function loadAllItem(){
    $("#tblItem").empty();
    $.ajax({
        url:"http://localhost:8080/pos/item-manager",
        method:"GET",
        success:function (resp){
            console.log(resp);
            for (const item of resp) {
                let row=`<tr><td>${item.code}</td><td>${item.description}</td><td>${item.qty}</td><td>${item.price}</td></tr>`;
                $("#tblItem").append(row);
            }
            bindClickEvents();
        }
    });
}

function bindClickEvents(){
    $("#tblCustomer>tr").click(function (){
        let code=$(this).children().eq(0).text();
        let description=$(this).children().eq(1).text();
        let qty=$(this).children().eq(2).text();
        let price=$(this).children().eq(3).text();

        $("#txtItemId").val(code);
        $("#txtItemName").val(description);
        $("#txtItemQty").val(qty);
        $("#txtItemPrice").val(price);
    });
}

$("#btnGetAllCustomer").click(function (){
    loadAllItem();
})


$("#btnSaveCustomer").click(function (){
    var data = $("#customerForm").serialize();
    $.ajax({
        url: "http://localhost:8080/pos/item-manager",
        method: "POST",
        data:data,
        success:function (resp){
            alert(resp);
            loadAllItem();
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
        url :"http://localhost:8080/pos/item-manager?cusID="+code,
        method:"DELETE",
        success:function (resp){
            alert(resp);
            loadAllItem();
        }
    });
});


$("#btnUpdateCustomer").click(function (){
    let code = $("#txtItemId").val();
    let description = $("#txtItemName").val();
    let qty = $("#txtItemQty").val();
    let price = $("#txtItemPrice").val();

    $.ajax({
        url: "http://localhost:8080/pos/item-manager",
        data: dataForm,
        method:"PUT",
        success:function (resp){
            alert(resp);
            loadAllItem();
        }
    })
});