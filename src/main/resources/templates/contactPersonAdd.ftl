<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Full name:<@spring.formInput "contactPersonForm.fullName" "" "text"/>
    <br>
    Phone number:<@spring.formInput "contactPersonForm.phoneNumber", "", "text"/>
    <br>
    Fax:<@spring.formInput "contactPersonForm.fax", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>