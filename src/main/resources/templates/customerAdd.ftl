<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Type of customer: <@spring.formSingleSelect "customerForm.type", typesL, ""/>
    <br>
    Full name:<@spring.formInput "customerForm.name" "" "text"/>
    <br>
    Contact person: <@spring.formSingleSelect "customerForm.contactPerson", contactPersonsL, ""/>
    <br>
    Address:<@spring.formInput "customerForm.address" "" "text"/>
    <br>
    Fax:<@spring.formInput "customerForm.fax" "" "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>