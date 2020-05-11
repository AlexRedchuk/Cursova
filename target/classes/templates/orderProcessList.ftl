<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Order Process list</h3>
<div>
    <a href = "/"><button>Back to home</button></a>
    <br>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Number of order</th>
            <th>Accept Date</th>
            <th>Completion Date</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list orderProcesses as orderProcess>
            <tr>
                <td>${orderProcess.id}</td>
                <td>${orderProcess.order.numberOfOrder}</td>
                <td>${orderProcess.acceptDate}</td>
                <td>${orderProcess.completionDate}</td>
                <td><a href="delete/${orderProcess.id}"><button>Delete</button></a></td>
                <td><a href="edit/${orderProcess.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>