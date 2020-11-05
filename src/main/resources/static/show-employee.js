$(document).ready(function() {

    $("#transaction-form").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        var $form = $(this),
            employeeId = $form.find("input[name='id']").val();

        var employeeJobHistory;

        // Get the data
        $.ajax({
            url: 'http://localhost:8080/api/employees/' + employeeId,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            async: false,
            //headers: {
            //    'Authorization': "Basic " + btoa('admin' + ":" + 'admin')
            //},

            success: function(employeeJobHistory) {
                formatTable(employeeJobHistory);
            }
        });

        function formatTable(employeeJobHistory) {
            $('#table td').parent().remove();
            console.log(employeeJobHistory);
            var employee_data = '';
            employee_data += '<tr>';
            employee_data += '<th>' + 'ID' + '</th>';
            employee_data += '<th>' + 'Ime' + '</th>';
            employee_data += '<th>' + 'Prezime' + '</th>';
            employee_data += '<th>' + 'Curent Department' + '</th>';
            employee_data += '<th>' + 'Current Salary' + '</th>';
            employee_data += '</tr>';

            employee_data += '<tr>';
            employee_data += '<td>' + employeeJobHistory.employeeId + '</td>';
            employee_data += '<td>' + employeeJobHistory.employeeFirstName + '</td>';
            employee_data += '<td>' + employeeJobHistory.employeeLastName + '</td>';
            employee_data += '<td>' + employeeJobHistory.departmentName[0] + '</td>';
            employee_data += '<td>' + employeeJobHistory.currentSalary + '</td>';
            employee_data += '</tr>';

            employee_data += '<tr>';
            employee_data += '<th>' + 'Job History' + '</th>'
            employee_data += '</tr>';
            employee_data += '<tr>';
            employee_data += '<th>' + 'Department Name' + '</th>'
            employee_data += '<th>' + 'Min Salary' + '</th>'
            employee_data += '<th>' + 'Max Salary' + '</th>'
            employee_data += '</tr>';


            var len = employeeJobHistory.departmentName.length;

            for (var i = 1; i < len; i++) {
                employee_data += '<tr>';
                employee_data += '<td>' + employeeJobHistory.departmentName[i] + '</td>';
                employee_data += '<td>' + employeeJobHistory.minSalary[i] + '</td>';
                employee_data += '<td>' + employeeJobHistory.maxSalary[i] + '</td>';
                employee_data += '</tr>';
            }
            $('#table').append(employee_data);
        }
    });

});