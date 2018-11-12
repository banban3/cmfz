<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){

    });
</script>
<div style="text-align: center;">
    <form id="addUser" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}" >
        <div style="margin-top: 70px;">
            名&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            选择头像: <input name="file"  class="easyui-filebox" data-options="buttonAlign:'left',prompt:'点我选择'">
        </div>
        <div style="margin-top: 20px;">
            密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;: <input type="text" name="password" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>

        <div style="margin-top: 20px;">
            法&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;: <input type="text" name="fname" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            性&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;: <input type="text" name="sex" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            电话号码: <input type="text" name="phone" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>

        <div style="margin-top: 20px;">
            时间: <input type="text" name="c_date"  class="easyui-datebox">
        </div>
    </form>
</div>