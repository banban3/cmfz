<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>
<div style="text-align: center;">
    <form id="addAlbum" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="">
        <div style="margin-top: 70px;">
            专辑名称&nbsp;: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            专辑头像: <input name="alb_img"  class="easyui-filebox" data-options="buttonAlign:'left',prompt:'点我选择'">
        </div>
        <div style="margin-top: 20px;">
            创建时间: <input type="text" name="pub_date"  class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            星星数量&nbsp;: <input type="text" name="star" class="easyui-textbox" data-options="required:true,validType:'name'">
        </div>
        <div style="margin-top: 20px;">
            作&nbsp;&nbsp;&nbsp;&nbsp;者&nbsp;: <input type="text" name="author" class="easyui-textbox" data-options="required:true,">
        </div>
        <div style="margin-top: 20px;">
            简&nbsp;&nbsp;&nbsp;&nbsp;介&nbsp;: <input type="text" name="context" class="easyui-textbox" data-options="required:true,">
        </div>
    </form>
</div>