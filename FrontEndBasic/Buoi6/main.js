console.log('add main.js')
//Callback function
/*
function study(subject){
    setTimeout(function(){console.log('Studying...!' + subject)},2000)
}
function finished(){
    console.log('Finished!')
}
*/

/*
function finished(){
    console.log('Finished!')
}

function study(subject, callBack){
    setTimeout(function(){
        console.log('Studying...!' + subject)
        callBack()
    },2000)
}
study('IT', finished)
*/

$(document).ready(function() { //window.onload
    $('.add-new').click(function() {
        let index = $('table tbody tr:last-child').index()
        $(this).attr('disabled', 'disabled')
        let action = $('table td:last-child').html()
        let row = '<tr>' +
        '<td><input type="text" class="form-control"></td>' +
        '<td><input type="text" class="form-control"></td>' +
        '<td><input type="text" class="form-control"></td>' +
        '<td>'+ action +
        '</td>' +
    '</tr>'
        $('table').append(row)
        
        $('table tbody tr').eq(index + 1).find('.add, .edit').toggle()
    }) 
    
    $(document).on('click', '.delete', function(){
        $(this).parents('tr').remove()
    })

    $(document).on('click', '.add', function() {
        let empty = false;
        let inputs = $(this).parents('tr').find('input[type="text"]');

        inputs.each(function() {
            if (!$(this).val()) {
                $(this).addClass('error');
                empty = true;
            }else {
                $(this).removeClass('error');
            }
        })

        $(this).parents('tr').find('.error').first().focus();

        if (!empty) {
            inputs.each(function () {
                $(this).parent('td').html($(this).val());
            })
            $(this).parents('tr').find('.add, .edit').toggle();
            $('.add-new').removeAttr('disabled');
        }
    })
    

    // Edit row on edit button click
    $(document).on("click", ".edit", function(){		
        $(this).parents("tr").find("td:not(:last-child)").each(function(){
            $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
        });		
        $(this).parents("tr").find(".add, .edit").toggle();
        $(".add-new").attr("disabled", "disabled");
    });

    $(document).on('click', '.delete', function() {
        console.log($(this).parents());
        $(this).parents('tr').remove();
        $('.add-new').removeAttr('disabled');
    })
})