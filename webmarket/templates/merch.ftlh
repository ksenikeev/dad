<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>

    <h1>Добро пожаловать</h1>
    <h2>Наши товары на ${date}</h2>

    <#list merchList as merch>
        <p><b> ${merch} </b></p>
    </#list>

    <a href='index.html'>Главная</a>
</body>
</html>