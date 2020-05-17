<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Printery list</h3>
<div>
    <a href = "/"><button>Back to home</button></a>
    <a href = "/web/printery/list"><button>Clear filters</button></a>
    <br>
    <div>
        <fieldset>
            <legend>Find  customer</legend>
            <form name="search" action="" method="POST">
                Author name:<@spring.formInput "searchForm.searchField" "" "text"/>
                <br>
                <input type="submit" value="Search"/>
            </form>
        </fieldset>
    </div>
    <br>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Name <a href="/web/printery/list/sortedByName" type="button">Sort</a></th>
            <th>Address <a href="/web/printery/list/sortedByAddress" type="button">Sort</a></th>
            <th>Phone number</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list printeries as printery>
            <tr>
                <td>${printery.id}</td>
                <td>${printery.name}</td>
                <td>${printery.address}</td>
                <td>${printery.phoneNumber}</td>
                <td><a href="delete/${printery.id}"><button>Delete</button></a></td>
                <td><a href="edit/${printery.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>