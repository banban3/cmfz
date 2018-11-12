<%@page pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $(function(){
        var select = $("#album").edatagrid("getSelected");
        $("#selectAlbum").form('load',select);
        $("#imgs").attr("src","${pageContext.request.contextPath}"+select.img_url);
    });
</script>
<div style="text-align: center;">
    <form id="selectAlbum" class="easyui-form" method="post" enctype="multipart/form-data">
       <div style="width: 40%;height: 100%;position: absolute;left: 30px;top:180px;">
           <img id="imgs" alt="" style="height: 150px;width: 150px;">
       </div>

       <div style="width: 60%;height: 100%;position: absolute;right: 50px;">
            <div style="margin-top: 70px;">
                专辑名称&nbsp;: <input type="text" name="name" class="easyui-textbox" data-options="required:true,validType:'name'">
            </div>
            <div style="margin-top: 20px;">
                专辑头像&nbsp;: <input type="text" name="img_url" class="easyui-textbox" data-options="required:true,validType:'name'">
                <%--<img id="imgs" src="" alt="" style="height: 15px;width: 15px;">--%>
            </div>
            <div style="margin-top: 20px;">
                创建时间: <input type="text" name="pub_date"  class="easyui-datebox">
            </div>
            <div style="margin-top: 20px;">
                星星数量&nbsp;: <input type="text" name="star" class="easyui-textbox" data-options="required:true,validType:'name'">
            </div>
            <div style="margin-top: 20px;">
                章节数量&nbsp;: <input type="text" name="n_count" class="easyui-textbox" data-options="required:true,validType:'name'">
            </div>
            <div style="margin-top: 20px;">
                作&nbsp;&nbsp;&nbsp;&nbsp;者&nbsp;: <input type="text" name="author" class="easyui-textbox" data-options="required:true,">
            </div>
            <div style="margin-top: 20px;">
                播&nbsp;&nbsp;&nbsp;&nbsp;音&nbsp;: <input type="text" name="broadcast" class="easyui-textbox" data-options="required:true,">
            </div>
            <div style="margin-top: 20px;">
                简&nbsp;&nbsp;&nbsp;&nbsp;介&nbsp;: <input type="text" name="context" class="easyui-textbox" data-options="required:true,">
            </div>
        </div>

    </form>
</div>