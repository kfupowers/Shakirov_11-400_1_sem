<html lang="en">

<head>
    <meta charset="UTF-8">
    <title><@title></@title></title>
</head>

<body>
<div id="header">
    <h3>Header 12345</h3>
    <a href="/logout">Выйти</a>
</div>
<form action="http://localhost:8080/login">
    <input type="submit" value="login">
</form>

<form action="http://localhost:8080/sign_up">
    <input type="submit" value="signUp">
</form>

<form action="http://localhost:8080/user">
    <input type="submit" value="users">
</form>


<div id="content">
    <div class="content">
        <@content></@content>
    </div>
</div>
</body>

</html>