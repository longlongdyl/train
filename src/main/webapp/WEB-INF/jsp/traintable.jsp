<%@ page import="com.sh2004.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/train/js/jquery.js"></script>
    <script src="/train/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/train/bootstrap-3.3.7-dist/css/bootstrap.css"/>
</head>
<body>
<table class="table table-bordered" align="center"
       style="text-align: center;width: 800px;">

    <tr>
        <td colspan="6">
            <h2>列车信息</h2>

        </td>
    </tr>

    <tr>
        <td colspan="5">

            <form id="form" class="form-inline" action="/train/train" method="post" style="display:inline">
                <select name="tnumber" class="form-control" id="c1" style=" width: 120px;height: 32px">
                    <c:if test="${t.tnumber == null}">
                        <option value="车次" id="c2">车次</option>
                    </c:if>
                    <c:if test="${t.tnumber != null}">
                        <option id="c2">${t.tnumber}</option>
                    </c:if>--%>
                    <c:forEach items="${tnumbers}" var="train">
                        <c:if test="${t.tnumber != train.tnumber}">
                            <option id="c2">${train.tnumber}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-primary" style="font-size: 10px">查询</button>
            </form>
            <button class="btn btn-success" id="buy"  style="font-size: 10px">购买</button>
            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="look"  style="font-size: 10px">查看已购</button>
            <button class="btn btn-warning" id="index"  style="font-size: 10px">回到首页</button>
            <c:if test="${user.uname == null}">
                <button class="btn btn-primary" id="lo"  style="font-size: 10px">登录</button>
            </c:if>
            <c:if test="${user.uname != null}">
                <span> 欢迎:${user.uname}</span>
                <button class="btn btn-danger" id="exit"  style="font-size: 10px">注销</button>
            </c:if>
            <script>
                $('#lo').click(function () {
                    location.href = "/train"
                });
                $('#exit').click(function () {
                    location.href = "/train/loginOut"
                });
                $('#index').click(function () {
                    location.href = "/train/train"
                });
            </script>
        </td>
    </tr>
    <tr>
        <td>
            <input type="checkbox" id="o1"/>
        </td>
        <td>
            车次
        </td>
        <td>
            发车-到达
        </td>
        <td>
            发时-到时
        </td>
        <td>
            车型
        </td>
    </tr>

    <c:forEach items="${trains}" var="train">
        <tr>
            <td><input type="checkbox" class="o2"/></td>
            <td>${train.tnumber}</td>
            <td>${train.taddress}</td>
            <td>${train.ttime}</td>
            <td>${train.ttype}</td>
        </tr>
    </c:forEach>

    <td colspan="6">
        ${pages}
    </td>
</table>
<script>
    $('#o1').change(function () {
        $('.o2').prop('checked', $('#o1').prop('checked'))
    })

    $('#buy').click(function () {
        <% User user = (User) request.getSession().getAttribute("user");
        if (user!=null){%>
        if ($('.o2:checked').length == 0) {
            alert("请至少选择一个")
        } else {
            var str = "";
            var otimes = [];
            $('.o2:checked').each(function () {
                str = $(this).parent().parent().children('td').eq(1).html();
                otimes.push(str)
            });
            var old = [];
            old = otimes
            if (confirm("确定购买" + otimes + "班次吗?")) {
                otimes = otimes.toLocaleString();
                $.ajax({
                    url: '/train/queryOrder',
                    data: {'otimes': otimes},
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {
                        if (data[0].length > 1) {
                            var str="";
                            for (var i1 = 0; i1 <data.length ; i1++) {
                                str += data[i1]+',';
                            }
                            str=str.substring(0,str.length-1);
                            var zz = [];
                            var str2 = "";
                            zz = str.split(",");
                            for (var i = 0; i <zz.length ; i++) {
                                for (var i2 = 0; i2 <old.length ; i2++) {
                                    if (zz[i] == old[i2]){
                                       old[i2] =old[i2].substring(old[i2].length)
                                        }
                                }
                            }
                            for (var i = 0; i <old.length ; i++) {
                                if (old[i].length>1){
                                    str2 += old[i]+","
                                }
                            }
                            str2 = str2.substring(0,str2.length-1);
                            if (confirm(str+"已经有了,是否购买剩下"+str2+"的车次")){
                                $.ajax({
                                    url: '/train/buy',
                                    data: {'otimes': str2},
                                    type: 'get',
                                    dataType: 'json',
                                    success: function (data) {
                                        alert("增加" + data + "张成功");
                                        $('#o1').prop('checked', false)
                                        $('.o2').prop('checked', $('#o1').prop('checked'))
                                    }
                                })
                            }else {
                                $('#o1').prop('checked', false);
                                $('.o2').prop('checked', $('#o1').prop('checked'))
                            }

                        } else {
                            $.ajax({
                                url: '/train/buy',
                                data: {'otimes': otimes},
                                type: 'get',
                                dataType: 'json',
                                success: function (data) {
                                    alert("增加" + data + "张成功");
                                    $('#o1').prop('checked', false)
                                    $('.o2').prop('checked', $('#o1').prop('checked'))
                                }
                            })
                        }
                    }
                });
            }
        }
        <%}else { %>
        alert("请先登录!");
        location.href = "/train";
        <%}%>
    })

    $('#look').click(function () {
        <% User user2 = (User) request.getSession().getAttribute("user");
       if (user2 != null){%>
        $.ajax({
            url: '/train/orderList',
            data: {'uid': <%=user.getUid()%>},
            type: 'get',
            dataType: 'json',
            success: function (data) {
                if ($('#a007').html() == undefined) {
                    for (var i = 0; i < data.length; i++) {
                        $('#t1').append("<tr>" + "<td id='a007' class='zz'>" + data[i].otime2 + "</td>" +
                            "<td>" + data[i].tnumber + "</td>" +
                            "<td>" + data[i].taddress + "</td>" +
                            "<td>" + data[i].ttime + "</td>" +
                            "<td>" + data[i].ttype + "</td>" +
                            "<td><button  class='btn btn-danger btn-sm' onclick='shanz($(this))'> " + '退票' + "</button></td>" + "</tr>")
                    }
                }
            }
        });


        <%}else{ %>
        alert("请先登录!");
        location.href = "/train";
        <%}%>
    })

    function shanz(mo) {
        var del = mo.parent().parent().children('td').eq(1).html();
        $.ajax({
            url: '/train/deleteOrder',
            data: {'otime': del},
            type: 'get',
            dataType: 'json',
            success: function (data) {
                alert(data);
                location.href = "/train/train"
            }

        })
    }


</script>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true"></span></button>
                <h4 class="modal-title" id="myModalLabel" align="center">${user.uname}用户已购买记录</h4>
            </div>
            <div class="modal-body">
                <table class="table table-bordered" align="center"
                       style="text-align: center" id="t1">
                    <tr>
                        <td>购票时间</td>
                        <td>车次</td>
                        <td>发车-到达 </td>
                        <td>发时-到时</td>
                        <td>车型</td>
                        <td>操作</td>
                    </tr>
                </table>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
