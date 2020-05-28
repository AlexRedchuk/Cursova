<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            margin: 0;
        }
        .form{
            width: 100%;
            height: 100vh;
            -webkit-background-size: cover;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
        }


        input, select{
            padding: 5px;
            border: 1px solid #f7c707;
            font-size: 15px;
            background: #aebad4;
            margin-bottom: 10px;
            width: 200px;
        }

        .message__form {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            border: 2px solid #0d3880;
            border-radius: 5px;
            padding: 10px;
        }

        .message__form input:hover{
            border: 1px solid #fcfdff;
        }



        .send__btn{
            background-color: #1d3466;
            width: 70px;
            height: 40px;
            color: #fff;
            text-align: center;
            font-size: 15px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="form">
    <form class="message__form" name="group" action="" method="POST">
        <span>Full name:</span><@spring.formInput "authorForm.fullName" "" "text" />
        <span>Address:</span><@spring.formInput "authorForm.address", "", "text"/>
        <span>Phone number:</span><@spring.formInput "authorForm.phoneNumber", "", "text"/>
        <button class="send__btn" type="submit">Submit</button>
    </form>
</div>
</body>
</html>