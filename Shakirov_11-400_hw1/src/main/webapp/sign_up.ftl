<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>SignUp page</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel = "styleshit">
</head>

<body>

<form action="http://localhost:8080/login">
    <input type="submit" value="login">
</form>

<form action="http://localhost:8080/sign_up">
    <input type="submit" value="signUp">
</form>

<form action="http://localhost:8080/logout">
    <input type="submit" value="logout">
</form>

<form action="/sign_up" method="post" enctype="multipart/form-data">
    Login:
    <input type="text" name="login" id="login-text" placeholder="type your login here">
    <div class="flex-box" id="ajax-response">
    </div>
    <script>
        $("#login-text").on("input", function () {
            $("#mySubmit").prop('disabled', true)
            $.post("/ajax/sign_up_check", {login : document.getElementById("login-text").value}, function (response) {
                $("#ajax-response").text(response)
                if(response.toString() != "User with this login already exists!") {
                    $("#mySubmit").prop('disabled', false);
                }
            });
        })
    </script>
    <br>
    Password:
    <input type="password" name="password" placeholder="type your password here">
    <br>
    Name:
    <input type="text" name="name" placeholder="type your name here">
    <br>
    Lastname:
    <input type="text" name="lastname" placeholder="type your lastname here">
    <br>
    Avatar:
    <input type="file" name="file">
    <br>
    <input type="submit" id="mySubmit" value="signUp">
</form>

</body>

</html>