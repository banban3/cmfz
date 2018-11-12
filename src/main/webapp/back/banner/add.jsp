<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){

    });
</script>
<div style="text-align: center;">
    <form id="addForm" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}" >
        <div style="margin-top: 70px;">
            标&nbsp;&nbsp;&nbsp;&nbsp;题&nbsp;: <input type="text" name="title" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            选择图片: <input name="bn"  class="easyui-filebox" data-options="buttonAlign:'left',prompt:'点我选择'">
        </div>
        <div style="margin-top: 20px;">
            描&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;: <input type="text" name="des" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            状态:
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