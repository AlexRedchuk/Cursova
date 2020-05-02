<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Order: <@spring.formSingleSelect "orderProcessForm.order", ordersL, ""/>
    <br>
    Accept date:<@spring.formInput "orderProcessForm.acceptDate", "", "text"/>
    <br>
    Complited date:<@spring.formInput "orderProcessForm.completionDate", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>