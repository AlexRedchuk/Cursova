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
    <a href = "/"><button>Back to home</button></a>
    <a href = "/web/productType/list"><button>Clear filters</button></a>
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
            <th>Name <a href="/web/productType/list/sorted" type="button">Sort</a></th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list productTypes as productType>
            <tr>
                <td>${productType.id}</td>
                <td>${productType.name}</td>
                <td>${productType.description}</td>
                <td><a href="delete/${productType.id}"><button>Delete</button></a></td>
                <td><a href="edit/${productType.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>