<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>SS
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.edatagrid.js"></script>


    <script type="text/javascript">
    $(function () {
        var name="${sessionScope.admin.name}";
        if(name==""){
            location.href="${pageContext.request.contextPath}/back/login.jsp";
        }else{
            $.post("${pageContext.request.contextPath}/menu/findmenu",function (menu) {
                //console.log(menu);
                //遍历一级菜单
                $.each(menu, function (index,m) {
                    //遍历二级菜单
                    var content="<div style='text-align: center'>";
                    $.each(m.childs, function (idx,child) {
                        content += "<a onclick=\"addtabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px;border:1px solid #00bbee;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                    });
                    content +="</div>";
                    $("#menu").accordion('add',{
                        title:m.name,
                        iconCls:m.iconCls,
                        content:content,
                    });
                })
            });
        }//
     });

    function upd() {

        $("#changpassword").dialog({
            href:"${pageContext.request.contextPath}/back/main/editpwd.jsp",
            buttons:[
                {
                    text:"保存",
                    iconCls:"icon-save",
                    handler:function(){
                        $("#editpwd").form('submit',{
                            url:"${pageContext.request.contextPath}/admin/change",

                            success:function (result) {
                                var parseJSON =$.parseJSON(result);
                                if (parseJSON.success) {
                                    //修改成功
                                    $.messager.show({title:'提示',msg:parseJSON.msg})
                                    //关闭对话框
                                    $("#changpassword").dialog('close')
                                    //增加一个定时器
                                    setTimeout(function () {
                                        location.href="${pageContext.request.contextPath}/back/login.jsp";
                                    },2000)
                                }else{
                                    $.messager.show({title:'提示',msg:parseJSON.msg})
                                }
                            }
                        });
                    }
                },{
                    text:"取消",
                    iconCls:"icon-remove",
                    handler:function(){
                        $("#changpassword").dialog('close');
                    }
                },],
        });
    }
    function addtabs(title,iconCls,href) {
        if (!$("#tabs").tabs('exists',title)) {
            $("#tabs").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}"+href,
            });
        }else{
            $("#tabs").tabs('select',title);
        }

    }
</script>

</head>
<body class="easyui-layout" data-options="fit:true," id="bg">
    <%--页面头部部分--%>
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
        <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
        <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
            欢迎您:${sessionScope.admin.name} &nbsp;
            <a href="#" onclick="upd()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/admin/quit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>

    <%--导航菜单--%>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
        <div id="menu" class="easyui-accordion" data-options="fit:true,"></div>
    </div>
    <%--中间部分--%>
    <div data-options="region:'center'">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',closable:true"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
        </div>
    </div>

    <%--页尾部部分--%>
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
        <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>

    <%--创建修改窗口的div--%>
    <div id="changpassword" data-options="draggable:false,width:650,height:500,iconCls:'icon-edit',title:'修改密码'"></div>

<%--<c:if test="">

</c:if>--%>

</body> 
</html>