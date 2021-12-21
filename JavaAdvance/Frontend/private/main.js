window.onload = function() {
    getAllDepartments();
}

function getAllDepartments() {
    $.ajax({
        url: 'http://localhost:8888/departments/show-list-departments',
        method: 'GET',
        success: function(response) {
            let arrDepartments = response;
            _.forEach(arrDepartments, (element, index) => {
                let row = '<tr>' +
                    '<td>' + (index + 1) + '</td>' +
                    '<td>' + element.id + '</td>' +
                    '<td>' + element.departmentName + '</td>' +
                    '<td>' + element.createdAt + '</td>' +
                    '<td>' +
                        '<a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>' +
                        '<a class="save" title="Save" data-toggle="tooltip"><i class="material-icons">&#xE065;</i></a>' +
                        '<a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>' +
                        '<a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>'
                    + '</td>'
                '</tr>';
                $('#table tbody').append(row);
            });
        },
        error: function(err) {
            console.log(err)
        }
    })
}

$(document).ready(function() {
    var flagAddNewDepartment = false;

    $(document).on('click', '.add', function() {
        let actions = $('table td:last-child').html();

        let lastRowIndex = $('table tbody tr:last-child').index();
        let row = '<tr>' +
            '<td>' + (lastRowIndex + 2) + '</td>' +
            '<td></td>' +
            '<td><input type="text" class="form-control" required></td>' +
            '<td><input type="text" class="form-control" required></td>' +
            '<td>' + actions + '</td>' + 
        '</tr>';
        $('table tbody').append(row)

        $('table tbody tr').eq(lastRowIndex + 1).find('.add, .save, .edit').toggle()

        flagAddNewDepartment = true;
    })


    $(document).on('click', '.delete', function() {

        $(this).parents('tr').remove()

        let id = $(this).parents('tr').find('td').eq(1).html();

        id = parseInt(id);

        let url = "http://localhost:8888/api/department/delete?id=" + id
        $.ajax({
            url: url,
            method: 'POST',
            success: function(response) {
            },
            error: function(err) {
                console.log(err)
            }
        })
    })

    $(document).on('click', '.edit', function() {
        $(this).parents("tr").find("td:nth-child(3), td:nth-child(4)").each(function(){
            $(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
        });

        $(this).parents("tr").find(".add, .edit, .save").toggle();

        let id = $(this).parents('tr').find('td').eq(1).html();
    })

    $(document).on('click', '.save', function() {
        let inputs = $(this).parents('tr').find('input[type="text"]');
        let flagInputEmpty = false;
        inputs.each(function() {
            if (!$(this).val() || $(this).val().trim() === '') {
                $(this).addClass('error')
                flagInputEmpty = true
            }else $(this).removeClass('error')
        })

        $(this).parents('tr').find('.error').first().focus()

        if (flagInputEmpty == false) {
            inputs.each(function() {
                $(this).parent('td').html($(this).val())
            })
            $(this).parents("tr").find(".add, .save, .edit").toggle()
        }

        

        let name = $(this).parents('tr').find('td').eq(2).html();

        let createdAt = $(this).parents('tr').find('td').eq(3).html();

        let tdIdNewRow = $(this).parents('tr').find('td').eq(1)

        if (flagAddNewDepartment == true) {
            let url = "http://localhost:8888/api/department/create"
            $.ajax({
                url: url,
                method: 'POST',
                data: {
                    'name': name.trim(),
                    'created_at': createdAt.trim()
                },
                success: function(response) {
                    tdIdNewRow.html(response);
                },
                error: function(err) {
                    console.log(err)
                }
            })
            flagAddNewDepartment = false;
        }else {
            let id = $(this).parents('tr').find('td').eq(1).html();
            id = parseInt(id);
            let url = "http://localhost:8888/api/department/update?id=" + id + "&name=" + name + "&created_at=" + createdAt; 
            $.ajax({
                url: url,
                method: 'POST',
                success: function(response) {
                },
                error: function(err) {
                    console.log(err)
                }
            })
        }
    })
})
        
