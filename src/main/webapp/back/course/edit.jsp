<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){
        $("#editCourse").form('load','${pageContext.request.contextPath}/course/findOne?id=${param.id}');
    });
</script>
<div style="text-align: center;">
    <form id="editCourse" class="easyui-form" method="post">

        <input type="hidden" name="id" value="${param.id}" >

        <div style="margin-top: 70px;">
            课程名称: <input type="text" name="homework" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 70px;">
            课程类别: <input type="text" style="readonly:true;" name="homework" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 70px;">
            用户id: <input type="text" name="homework" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            状&nbsp;&nbsp;&nbsp;&nbsp;态:
            <select class="easyui-combobox" name="sta"  data-options="width:159">
                <option value="1">1</option>
                <option value="2">2</option>
            </select>
        </div>
        <div style="margin-top: 20px;">
            上传时间: <input type="text" name="i_date"  class="easyui-datebox">
        </div>
    </form>
</div>