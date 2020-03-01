<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Author list</h3>
<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Full name</th>
            <th>Address</th>
            <th>Phone number</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list authors as author>
            <tr>
                <td>${author.id}</td>
                <td>${author.fullName}</td>
                <td>${author.address}</td>
                <td>${author.phoneNumber}</td>
                <td><a href="delete/${author.id}"><button>Delete</button></a></td>
                <td><button>Edit</button></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>