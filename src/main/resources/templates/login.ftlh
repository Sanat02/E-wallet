<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login and Registration Page</title>
    <link href='https://fonts.googleapis.com/css?family=Poppins' rel='stylesheet'/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">


    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 400px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        .container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        form {
            width: 100%;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color:dodgerblue;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: dodgerblue;
        }

        .register-option {
            margin-top: 10px;
            font-size: 14px;
            color: #333;
        }

        .register-option a {
            color: dodgerblue;
            text-decoration: none;
        }



        .divider hr {
            position: absolute;
            top: 50%;
            left: 0;
            width: 100%;
            margin: 0;
        }


    </style>
</head>
<body>
<div class="container">
    <h2><@spring.message 'login'/></h2>
    <form action="/login" method="post" id="login-form">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>

        </#if>
        <label for="email"><@spring.message 'account.name'/>:</label>
        <input type="text" id="email" name="username" placeholder="<@spring.message 'text.email'/>" required>

        <label for="password"><@spring.message 'password'/>:</label>
        <input type="password" id="password" name="password" placeholder="<@spring.message 'text.password'/>" required>

        <input type="submit" value="<@spring.message 'login'/>">
    </form>

    <div class="register-option">
        <@spring.message 'no.account'/> <a href="/register"><@spring.message 'navbar.user.signup'/></a>
    </div>
    <div class="register-option">
        <@spring.message 'forgot'/> <a href="/forgot"><@spring.message 'reset'/></a>
    </div>

</div>

<script>
    document.getElementById("login-form").addEventListener('submit', onLoginHandler);

    let user = {};

    function onLoginHandler(event) {

        let form = event.target;
        let userFormData = new FormData(form);
        user = Object.fromEntries(userFormData);
        saveUser(user)
    }

    function saveUser(user) {
        let userAsJson = JSON.stringify(user)
        localStorage.setItem('user', userAsJson)
    }
</script>
</body>
</html>
