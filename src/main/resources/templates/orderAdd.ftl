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
            height: 30px;
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
    <span>Number of order:</span><@spring.formInput "orderForm.numberOfOrder" "" "text"/>
    <span>Customer: </span><@spring.formSingleSelect "orderForm.customer", customersL, ""/>
    <span>Product type: </span><@spring.formSingleSelect "orderForm.productType", productTypesL, ""/>
    <span>Printery:</span> <@spring.formSingleSelect "orderForm.printery", printeriesL, ""/>
    <button class="send__btn">Submit</button>
    </form>
</div>
</body>
</html>