<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        h3{
            width: 100%;
            text-align: center;
            position: absolute;
        }
        .create {
            border: 2px solid black;
            border-radius: 5px;
            width: 150px;
            height: 40px;
            font-size: 24px;
            display: flex;
            align-items: center;
            justify-content: space-around;
        }

        .containers {
            margin: 4px;
            position: relative;
            width: 100%;
            display: flex;
            justify-content: space-between;
            padding-right: 10px;
        }
        .search_form {
            padding: 5px;
        }
        .others {
        }
        span {
            margin-left: 5px;
        }
    </style>
</head>
<body>
<h3>Customer list</h3>
<div>
    <div class="containers">
        <div class="others">
            <a class="btn btn-dark" href = "/tables.html"><i class="fa fa-table"></i><span>Back to tables</span></a>
            <a class="btn btn-dark" href = "/web/customer/list"><i class="fa fa-refresh"><span>Clear filters</span></i></a>
        </div>

        <div class="search_form">
            <fieldset>
                <form name="search" action="" method="POST">
                    Customer name:<@spring.formInput "searchForm.searchField" "" "text"/>
                    <button class="btn btn-dark" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </fieldset>
        </div>
    </div>
    <table class="table">
        <tr class="thead-dark">
            <th>ID</th>
            <th>Type</th>
            <th>Name</th>
            <th>contactPerson</th>
            <th>address <a class="btn btn-outline-light" href="/web/customer/list/sorted" type="button"><i class="fa fa-sort-alpha-asc"></i></a></th>
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
                <td><a class="btn btn-outline-danger" href="/web/customer/delete/${customer.id}" type="button"
                       onclick="return confirm('Are you sure you want to delete ${customer.name} ?');"><i class="fa fa-trash"></i></a></td>
                <td><a class="btn btn-light fa-2x" href="/web/customer/edit/${customer.id}" ><i class="fa fa-pencil-square-o"></i></a></td>
            </tr>
        </#list>
    </table>
    <a class="btn btn-light create" href="/web/customer/create"><i class="fa fa-plus-circle "></i><span>Add new</span></a>
</div>

</body>
</html>