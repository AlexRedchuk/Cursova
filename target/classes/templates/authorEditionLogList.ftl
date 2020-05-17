<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Author edition log list</h3>
<div>
    <a href = "/"><button>Back to home</button></a>
    <a href = "/web/authorEditionLog/list"><button>Clear filters</button></a>
    <br>
    <div>
        <fieldset>
            <legend>Find  customer</legend>
            <form name="search" action="" method="POST">
                Author or Edition name:<@spring.formInput "searchForm.searchField" "" "text"/>
                <br>
                <input type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>
    <br>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Edition <a href="/web/authorEditionLog/list/sortedByEdition" type="button">Sort</a></th>
            <th>Author <a href="/web/authorEditionLog/list/sortedByAuthor" type="button">Sort</a></th>
            <th>Additional information</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list authorEditionLogs as authorEditionLog>
            <tr>
                <td>${authorEditionLog.id}</td>
                <td>${authorEditionLog.edition.name}</td>
                <td>${authorEditionLog.author.fullName}</td>
                <td>${authorEditionLog.additionalInformation}</td>
                <td><a href="delete/${authorEditionLog.id}"><button>Delete</button></a></td>
                <td><a href="edit/${authorEditionLog.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>