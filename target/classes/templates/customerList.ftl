<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Customer list</h3>
<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Type</th>
            <th>Name</th>
            <th>contactPerson</th>
            <th>address</th>
            <th>fax</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list customers as customer>
            <tr>
                <td>${customer.id}</td>
                <td>${customer.type}</td>
                <td>${customer.name}</td>
                <td>${customer.contactPerson.fullName}</td>
                <td>${customer.address}</td>
                <td>${customer.fax}</td>
                <td><a href="delete/${customer.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>