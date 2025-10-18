<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Upload file</title>
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

    <form action="upload" method="post" enctype="multipart/form-data">
        <input type = "text" name = "text">
        <br>
        <input type = "file" name = "file">
        <br>
        <input type = "submit" value="upload">
    </form>

</body>

</html>