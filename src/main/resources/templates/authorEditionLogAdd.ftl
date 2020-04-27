<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Author: <@spring.formSingleSelect "authorEditionLogForm.author", authorsL, ""/>
    <br>
    Edition: <@spring.formSingleSelect "authorEditionLogForm.edition", editionsL, ""/>
    <br>
    Additional form:<@spring.formInput "authorEditionLogForm.additionalInformation", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>