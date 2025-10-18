<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login page</title>
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

<form method="post" action="/login">
    Login:
    <input type="text" name="login" placeholder="type your login here">
    Password:
    <input type="password" name="password" placeholder="type your password here">
    <br>
    <input type="submit" value="login">
</form>

</body>

</html>