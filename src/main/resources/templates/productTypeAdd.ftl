<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Name:<@spring.formInput "productTypeForm.name" "" "text"/>
    <br>
    Description:<@spring.formInput "productTypeForm.description", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>