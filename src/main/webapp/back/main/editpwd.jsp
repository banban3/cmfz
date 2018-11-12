<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
   $(function(){
        //$ ("#editpwd").form('load','${pageContext.request.contextPath}/admin/findone?name=${requestScope.name}');
    });
</script>
<div style="text-align: center;">
    <form id="editpwd" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            用户名: <input type="text" name="name" value="${sessionScope.admin.name}" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            原密码: <input type="text" name="password"  class="easyui-passwordbox">
        </div>
        <div style="margin-top: 20px;">
            新密码: <input type="text" name="password2"  class="easyui-passwordbox">
        </div>


    </form>
</div>