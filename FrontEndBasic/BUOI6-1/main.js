//Callback function

// function study(subject) {
//     setTimeout(function() {
//         console.log('Studying ' + subject);
//     }, 2000)
    
// }

// function study(subject, callback) {
//     setTimeout(function() {
//         console.log('Studying ' + subject);
//         callback();
//     }, 2000)
// }

// study('IT', finished);

$(document).ready(function() {//window.onload
    
    $('.add-new').click(function() {
        //console.log('btn add new clicked...')
        
        $(this).attr('disabled', 'disabled');

        let index = $('table tbody tr:last-child').index();
        //console.log('index: ' + index);

        let actions = $('table td:last-child').html();

        let row = '<tr>' + 
            '<td><input type="text" class="form-control"></td>' + 
            '<td><input type="text" class="form-control"></td>' + 
            '<td><input type="text" class="form-control"></td>' + 
            '<td>' + actions + '</td>' + 
        '</tr>';

        $('table').append(row);

        $('table tbody tr').eq(index + 1).find('.add, .edit').toggle();
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
