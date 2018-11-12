<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){

    });
</script>
<div style="text-align: center;">
    <form id="addTeach" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}" >
        <div style="margin-top: 70px;">
            名&nbsp;&nbsp;&nbsp;&nbsp;字&nbsp;: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            选择头像: <input name="tea_img"  class="easyui-filebox" data-options="buttonAlign:'left',prompt:'点我选择'">
        </div>
        <div style="margin-top: 20px;">
            性别:
            <select class="easyui-combobox" name="sex"  data-options="width:159">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <%--<div style="margin-top: 20px;">
            上传时间: <input type="text" name="i_date"  class="easyui-datebox">
        </div>--%>
    </form>
</div>