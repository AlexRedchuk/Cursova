<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="group" action="" method="POST">
    Edition Code:<@spring.formInput "editionForm.editionCode" "" "text"/>
    <br>
    Name:<@spring.formInput "editionForm.name" "" "text"/>
    <br>
    Number of pages:<@spring.formInput "editionForm.numberOfPages" "" "text"/>
    <br>
    Circulation:<@spring.formInput "editionForm.circulation" "" "text"/>
    <br>
    EditionDirection: <@spring.formSingleSelect "editionForm.editionDirection", editionDirectionsL, ""/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>