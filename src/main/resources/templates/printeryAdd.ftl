<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Name:<@spring.formInput "printeryForm.name" "" "text"/>
    <br>
    Address:<@spring.formInput "printeryForm.address", "", "text"/>
    <br>
    Phone number:<@spring.formInput "printeryForm.phoneNumber", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>