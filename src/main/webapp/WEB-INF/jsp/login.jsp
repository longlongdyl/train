
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script src="/train/js/jquery.js"></script>
    <script src="/train/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/train/bootstrap-3.3.7-dist/css/bootstrap.css"/>
</head>
<body>
<br><br><br><br><br>
<center>
    <form action="/train/login" method="post">
        <table width="300px" style="text-align: center" align="center" border="0" alcellspacing="0" cellpadding="0">
            <tr>
                <td align="right" height="55px" width="100px">
                    <div class="form-group">
                        <label class="sr-only" for="u3">用户名</label>
                        <input name="uname" type="text" class="form-control" id="u3"
                               placeholder="用户名">
                    </div>
                </td>
            </tr>
            <tr>
                <td align="right" height="55px" width="100px">
                    <div class="form-group">
                        <label class="sr-only" for="p3">密码</label>
                        <input type="password" name="upwd" class="form-control" id="p3"
                               placeholder="密码">
                    </div>
                </td>
            </tr>
            <tr>
                <td width="100px">
                    <div class="checkbox" >
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
