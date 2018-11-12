<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){

    });
</script>
<div style="text-align: center;">
    <form id="addCourse" class="easyui-form" method="post">
        <%--<input type="hidden" name="id" value="${param.id}" >--%>
        <div style="margin-top: 70px;">
            课程名称: <input type="text" name="homework" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <%--<div style="margin-top: 20px;">
            用户id: <input type="text" name="user_id"  class="easyui-datebox">
        </div>
--%>
    </form>
</div>