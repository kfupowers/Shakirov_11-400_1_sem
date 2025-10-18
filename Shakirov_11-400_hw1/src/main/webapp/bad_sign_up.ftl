<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>

<body>
Пользователь с таким логином уже есть
<form action="http://localhost:8080/login">
    <input type="submit" value="login">
</form>

<form action="http://localhost:8080/sign_up">
    <input type="submit" value="signUp">
</form>

<form method="post" action="/sign_up">
    Login:
    <input type="text" name="login" placeholder="type your login here">
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
    <input type="submit" value="login">
</form>

</body>

</html>