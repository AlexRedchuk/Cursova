<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Edition list</h3>
<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Edition code</th>
            <th>Name</th>
            <th>Number of pages</th>
            <th>Circulation</th>
            <th>Direction</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list editions as edition>
            <tr>
                <td>${edition.id}</td>
                <td>${edition.editionCode}</td>
                <td>${edition.name}</td>
                <td>${edition.numberOfPages}</td>
                <td>${edition.circulation}</td>
                <td>${edition.editionDirection.name}</td>
                <td><a href="delete/${edition.id}"><button>Delete</button></a></td>
                <td><a href="edit/${edition.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>