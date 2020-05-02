<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Number of order:<@spring.formInput "orderForm.numberOfOrder" "" "text"/>
    <br>
    Customer: <@spring.formSingleSelect "orderForm.customer", customersL, ""/>
    <br>
    EditionDirection: <@spring.formSingleSelect "orderForm.productType", productTypesL, ""/>
    <br>
    EditionDirection: <@spring.formSingleSelect "orderForm.printery", printeriesL, ""/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>