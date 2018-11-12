<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>

</script>
<div style="text-align: center;">
    <form id="addChapter" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top: 70px;">
            章节名称&nbsp;: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            上传时间: <input type="text" name="pub_time"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            下载地址: <input name="file"  class="easyui-filebox" data-options="buttonAlign:'left',prompt:'点我选择'">
        </div>

    </form>
</div>