<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <title>我的商城 | 用户列表</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>


    <jsp:include page="../includes/menu.jsp"/>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <section class="content">
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <c:if test="${baseResult!=null}">
                            <div class="arrow">

                                <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
                                    </button>
                                        ${baseResult.message}
                                </div>
                            </div>
                        </c:if>
                    </div>


                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header with-border">
                            <h3 class="box-title">高级搜索</h3>
                        </div>

                        <form:form cssClass="form-horizontal" action="/user/search" method="post"
                                   modelAttribute="tbUser">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="username"
                                                   class="col-sm-4 control-label">姓名</label>

                                            <div class="col-sm-8">
                                                <form:input path="username"
                                                            class="form-control pull-right"
                                                            placeholder="姓名"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="email" class="col-sm-4 control-label">邮箱</label>

                                            <div class="col-sm-8">
                                                <form:input path="email" class="form-control pull-right"
                                                            placeholder="邮箱"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="phone" class="col-sm-4 control-label">手机</label>

                                            <div class="col-sm-8">
                                                <form:input path="phone" class="form-control pull-right"
                                                            placeholder="手机"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right"><i class="fa fa-search">搜索</i>
                                </button>
                            </div>
                        </form:form>
                    </div>


                    <div class="box-header">
                        <h3 class="box-title">用户列表</h3>


                        <div class="row" style="padding-left: 10px;padding-top: 5px">
                            <a href="/user/form" type="button" class="btn  btn-default btn-sm"><i
                                    class="fa fa-plus">新增</i></a>&nbsp;
                            <a href="#" type="button" class="btn  btn-default btn-sm"><i
                                    class="fa fa-trash-o">删除</i></a>&nbsp;
                            <a href="#" type="button" class="btn  btn-default btn-sm"><i
                                    class="fa fa-download">导入</i></a>&nbsp;
                            <a href="#" type="button" class="btn  btn-default btn-sm"><i
                                    class="fa fa-upload">导出</i></a>
                            <button type="button" class="btn  btn-info btn-sm"
                                    onclick="$('.box-info-search').css('display')=='none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')">
                                <i
                                        class="fa fa-search">高级搜索</i></button>
                        </div>

                    </div>

                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th><input type="checkbox" class="minimal" checked="" style="position: absolute; opacity: 0;"></th>
                                <th> ID</th>
                                <th>用户名</th>
                                <th>手机号</th>
                                <th>邮箱</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${tbUsers}" var="tbUser">
                                <tr>
                                    <th><input type="checkbox" class="minimal" checked="" style="position: absolute; opacity: 0;"></th>
                                    <td>${tbUser.id}</td>
                                    <td>${tbUser.username}</td>
                                    <td>${tbUser.phone}</td>
                                    <td>${tbUser.email}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                                        value="${tbUser.updated}"/></td>

                                    <td>
                                        <a href="#" type="button" class="btn  btn-default btn-sm"><i
                                                class="fa fa-search">查看</i></a>
                                        <a href="#" type="button" class="btn  btn-primary btn-sm"><i
                                                class="fa fa-edit">编辑</i></a>
                                        <a href="#" type="button" class="btn  btn-danger btn-sm"><i
                                                class="fa fa-trash-o">删除</i></a>

                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <!-- /.box -->
        </section>
    </div>
</div>
<jsp:include page="../includes/copyright.jsp"/>
<!-- ./wrapper -->


<jsp:include page="../includes/footer.jsp"/>

</body>