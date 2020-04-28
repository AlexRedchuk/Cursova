<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Edition: <@spring.formSingleSelect "editionOrderLogForm.edition", editionsL, ""/>
    <br>
    Order: <@spring.formSingleSelect "editionOrderLogForm.order", ordersL, ""/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>