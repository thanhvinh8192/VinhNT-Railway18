

$(document).ready(function(){
    var flagAddNewDepartment = false
    function getAllDepartments(){
        $.ajax({
            url: 'http://localhost:8888/departments/show-list-departments',
            method: 'GET',
            success: function(response){
                response.forEach((element, index) => {
                    let row = '<tr>' +
                            '<td>' + (index + 1) + '</td>'+
                            '<td>' + element.id + '</td>'+
                            '<td>' + element.departmentName + '</td>'+
                            '<td>' + element.createdAt + '</td>' + 
                            '<td>' + 
                            '<a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B</i></a>' +
                            '<a class="save" title="Save" data-toggle="tooltip"><i class="material-icons">&#xE065;</i></a>' +
                            '<a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE3C9;</i></a>' +
                            '<a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xe872;</i></a>' +
                            '</td>'+
                            '</tr>'
                            $('#table tbody').append(row)
                });
            }
        })
    }

    getAllDepartments()

    //Editor clicked
    $(document).on('click', '.edit', function(){
        $(this).parents('tr').find('td:nth-child(3), td:nth-child(4)').each(function(){
            $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">')

        })
        //$(this).parents('tr').find('.add, .edit, .save').toggle()
        $(this).parent().find('.add, .edit, .save').toggle()
    })

    //Delete clicked
    $(document).on('click', '.delete', function(){
        $(this).parents('tr').remove()
        //get id from td
        let id = parseInt($(this).parents('tr').find('td').eq(1).html())
        
        $.ajax({
            url: 'http://localhost:8888/departments/delete?id=' + id,
            method: 'POST',
            success: function(response){

            },
            error: function(error) {
                console.log(error)
            }
        })
    })

    //Add clicked
    $(document).on('click', '.add', function(){
        let actions = $('table tbody td:last-child').html()
        let lastIndex = $('table tbody tr:last-child').index()
        let row = '<tr>' + 
                '<td>' + (lastIndex + 2) + '</td>' +
                '<td></td>' +
                '<td><input type="text" class="form-control"/></td>' +
                '<td><input type="text" class="form-control"/></td>' +
                '<td>' + actions + '</td>' +
                '</tr>'
        $('table tbody').append(row)
        $('table tbody tr').eq(lastIndex + 1).find('.add, .save, .edit').toggle()
        $()
        flagAddNewDepartment = true
    })

    //Save clicked
    $(document).on('click', '.save', function(){
        let inputs = $(this).parents('tr').find('input[type="text"]')

        let flagInputEmpty = false
        

        inputs.each(function(){
            if(!$(this).val() || $(this).val().trim() === ''){
                $(this).addClass('error')
                flagInputEmpty = true
            }else {
                $(this).removeClass('error')
            }
        })
        
        $(this).parents('tr').find('.error').first().focus()
        if(flagInputEmpty == false) {
            inputs.each(function(){
                $(this).parent().html($(this).val())
            })
            $(this).parents('tr').find('.add, .save, .edit').toggle()
        }

        let departmentName = $(this).parents('tr').find('td').eq(2).html()
        let createdAt = $(this).parents('tr').find('td').eq(3).html()
        let tdIdNewRow = $(this).parents('tr').find('td').eq(1)
        

        if(flagAddNewDepartment == true) { //Add
            $.ajax({
                url:'http://localhost:8888/departments/create',
                method: 'POST',
                data: {
                    'departmentName': departmentName,
                    'created_at': createdAt
                },
                success: function(response){
                    tdIdNewRow.html(response)

                },
                error: function(error){
                    console.log(error)
                }
            })
            flagAddNewDepartment = false
        }else{//Update
            //lay id tu database
            let id = $(this).parents('tr').find('td').eq(1).html()
            let url = 'http://localhost:8888/departments/update?id=' + id + '&departmentName=' + departmentName + '&created_at=' + createdAt
            $.ajax({
                url:url,
                method: 'POST',
                success: function(response){

                },
                error: function(error){
                    console.log(error)
                }
                
            })
        }
    })

})