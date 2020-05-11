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
    <a href = "/"><button>Back to home</button></a>
    <a href = "/web/edition/list"><button>Clear filters</button></a>
    <br>
    <div>
        <fieldset>
            <legend>Find  customer</legend>
            <form name="search" action="" method="POST">
                Edition name:<@spring.formInput "searchForm.searchField" "" "text"/>
                <br>
                <input type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Edition code <a href="/web/edition/list/sortedByEditionCode" type="button">Sort</a></th>
            <th>Name <a href="/web/edition/list/sortedByName" type="button">Sort</a></th>
            <th>Number of pages <a href="/web/edition/list/sortedByNumberOfPages" type="button">Sort</a></th>
            <th>Circulation <a href="/web/edition/list/sortedByCirculation" type="button">Sort</a></th>
            <th>Direction <a href="/web/edition/list/sortedByEditionDirection" type="button">Sort</a></th>
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