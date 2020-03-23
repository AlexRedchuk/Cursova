<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Full name:<@spring.formInput "authorForm.fullName" "" "text"/>
    <br>
    Address:<@spring.formInput "authorForm.address", "", "text"/>
    <br>
    Phone number:<@spring.formInput "authorForm.phoneNumber", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>