function loadAccount() {
    var dataTable = null
    var flagUpdateAccount = false
    
    var accountId = null

    let url = "http://localhost:8888/api/account/list-accounts"
    jQuery.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("Username") + ":" + localStorage.getItem("Password")));
        },
        success: function(response){
            console.log(response)
            let accounts = []

        for (let i = 0; i < response.length; i++) {
            let temp = []
            //temp[0] = i + 1
            temp[0] = response[i].firstName + " " + response[i].lastName
            temp[1] = response[i].username
            temp[2] = response[i].role
            temp[3] = response[i].department
            temp[4] = ''
            temp[5] = ''
            accounts.push(temp)
        }

        dataTable = $('#datatables-accounts').DataTable({
            data: accounts,

            columns: [
                { title: "Fullname" },
                { title: "Username" },
                { title: "Role" },
                { title: "Department" },
                { title: "Action" }
            ],
            "columnDefs": [
                {
                    "targets": 4,
                    "width": 100,
                    "render": function (data, type, row, meta) {
                        return '<td>' +
                            '<button class="btn-actions edit" data-toggle="modal" data-target="#defaultModalPrimary"><i class="material-icons">&#xE3C9;</i></button>' +
                            '<button class="btn-actions delete-account" data-toggle="modal" data-target="#defaultModalDanger"><i class="material-icons">&#xe872;</i></button>' +
                            '</td>'
                    }
                },
                {
                    orderable: false,
                    className: 'select-checkbox',
                    targets: 5,
                    with: 45
                },
            ],

            "select": {
                'style': 'multi'
            },
            
        })
        }
    })

    $('#datatables-accounts').on('click', '.edit', function(e){
        e.preventDefault()

        flagUpdateAccount = true

        let index = parseInt($(this).parents('tr').find('td').eq(1).html()) -1
        console.log(index)

        let record = dataTable.row(index).data()
        let fullName = record[0]
        let firstName = fullName.substr(0, fullName.indexOf(' ').trim())
        let lastName = fullName.substr(fullName.indexOf(' ').trim())
        let userName = record[1]
        let role = record[2]
        let departmentName = record[3]
        
        accountId = 1
        $('user_name').val(userName)
        $('first_name').val(firstName)
        $('last_name' ).val(lastName)
        $('role').val(role)
        $('department').val(departmentName)



    })

    /*$.get(url, function (response) {

        let departments = []

        for (let i = 0; i < response.length; i++) {
            let temp = []
            //temp[0] = i + 1
            //temp[1] = response[i].id
            temp[0] = response[i].firstName + " " + response[i].lastName
            temp[1] = response[i].username
            //temp[4] = response[i].password
            temp[2] = response[i].role
            temp[3] = response[i].department
            temp[4] = ''
            departments.push(temp)
        }

        $('#datatables-accounts').DataTable({
            data: departments,

            columns: [
                //{ title: "Order" },
                //{ title: "Id" },
                { title: "Fullname" },
                { title: "Username" },
                //{ title: "Password" },
                { title: "Role" },
                { title: "Department" },
                { title: "Action" }
            ],
            "columnDefs": [
                {
                    "targets": 4,
                    "width": 100,
                    "render": function (data, type, row, meta) {
                        return '<td>' +
                            '<button class="btn-actions"><i class="material-icons">&#xE3C9;</i></button>' +
                            '<button class="btn-actions"><i class="material-icons">&#xe872;</i></button>' +
                            '</td>'
                    }
                }
            ]
        })
    })*/
}


