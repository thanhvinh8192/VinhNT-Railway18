function loadDepartment() {
    let url = "http://localhost:8888/api/department/list-departments"

    jQuery.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("Username") + ":" + localStorage.getItem("Password")));
        },
        success: function(response){
            let departments = []

            for (let i = 0; i < response.length; i++) {
                let temp = []
                temp[0] = response[i].departmentName
                temp[1] = response[i].totalMember
                temp[2] = response[i].type
                temp[3] = response[i].createdDate
                temp[4] = ''
                departments.push(temp)
            }

            $('#datatables-department').DataTable({
                data: departments,

                columns: [
                    { title: "Department Name" },
                    { title: "Total Member" },
                    { title: "Type" },
                    { title: "Create Date" },
                    { title: "Action" }
                    ],
                    "columnDefs": [
                        {
                            "targets": 4,
                            "width": 100,
                            "render": function (data, type, row, meta) {
                                return '<td>' +
                                    '<button class="btn-actions"><i class="material-icons">&#xE145;</i></button>' +
                                    '<button class="btn-actions"><i class="material-icons">&#xE3C9;</i></button>' +
                                    '<button class="btn-actions"><i class="material-icons">&#xe872;</i></button>' +
                                    '</td>'
                            }
                        }
                ]
        })
        }
    })
    
}


