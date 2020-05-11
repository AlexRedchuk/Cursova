<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Contact person list</h3>
<div>
    <a href = "/"><button>Back to home</button></a>
    <br>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Full name</th>
            <th>Phone number</th>
            <th>Fax</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list contactPersons as contactPerson>
            <tr>
                <td>${contactPerson.id}</td>
                <td>${contactPerson.fullName}</td>
                <td>${contactPerson.phoneNumber}</td>
                <td>${contactPerson.fax}</td>
                <td><a href="delete/${contactPerson.id}"><button>Delete</button></a></td>
                <td><a href="edit/${contactPerson.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>