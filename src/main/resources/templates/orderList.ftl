<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Order list</h3>
<div>
    <a href = "/"><button>Back to home</button></a>
    <a href = "/web/order/list"><button>Clear filters</button></a>
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
            <th>Number of order <a href="/web/order/list/sortedByNumberOfOrder" type="button">Sort</a></th>
            <th>Customer <a href="/web/order/list/sortedByCustomer" type="button">Sort</a></th>
            <th>Product type <a href="/web/order/list/sortedByProductType" type="button">Sort</a></th>
            <th>Printery <a href="/web/order/list/sortedByPrintery" type="button">Sort</a></th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.numberOfOrder}</td>
                <td>${order.customer.name}</td>
                <td>${order.productType.name}</td>
                <td>${order.printery.name}</td>
                <td><a href="delete/${order.id}"><button>Delete</button></a></td>
                <td><a href="edit/${order.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
    <a href="create"><button>Create</button></a>
</div>

</body>
</html>