<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#article").datagrid({
            url:'${pageContext.request.contextPath}/article/findAll',
            pagination:true,//显示分页栏
            pageNumber:1,//当前页
            pageSize:5,//每页显示记录数
            pageList:[2,5,10,15,30],
            striped:true,//斑马线效果
            remoteSort:false,//关闭从服务器进行的排序
            columns:[[
                {field:'id',title:'id.',width:180,},
                {field:'title',title:'名称.',width:180,},
                {field:'c_img',title:'图片地址',width:180},
                {field:'pub_date',title:'上传时间',width:180},
                {field:'content',title:'内容',width:180},
                {field:'fid',title:'上师id',width:180}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.c_img+ '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.title + '</p>' +
                    '<p>Status: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar: [
                {
                    iconCls: 'icon-tip',
                    text:'文章添加',
                    handler: function(){

                    }
                },{
                    iconCls: 'icon-add',
                    text:'文章删除',
                    handler: function(){
                        $("#albumadd").dialog({
                            href:"${pageContext.request.contextPath}/back/album/add.jsp",
                            title:'专辑添加',
                            draggable:false,
                            iconCls:'icon-add',
                            width:650,
                            height:500,
                            buttons:[{
                                text:'保存',
                                iconCls:'icon-save',
                                handler:function(){
                                    $("#addAlbum").form("submit",{
                                        url:'${pageContext.request.contextPath}/album/save',
                                        success:function (result) {
                                            var parseJSON = $.parseJSON(result);
                                            if(parseJSON.success){
                                                $.messager.show({title:'温馨提示',msg:'专辑添加成功！'});
                                            }else{
                                                $.messager.show({title:'温馨提示',msg:parseJSON.msg});
                                            }
                                            $("#albumadd").dialog("close",true);
                                            $("#album").treegrid("reload");
                                        }
                                    });
                                }
                            },{
                                text:'关闭',
                                iconCls:'icon-cancel',
                                handler:function(){
                                    $("#albumadd").dialog("close",true);
                                }
                            }]
                        });
                    }
                },
                {
                    iconCls: 'icon-save',
                    text:'文章修改',
                    handler: function(){
                        var select = $("#album").edatagrid("getSelected");
                        if(select == null){
                            $.messager.show({title:'温馨提示',msg:'至少选中一行！'});
                        }else{
                            $("#chapteradd").dialog({
                                href:"${pageContext.request.contextPath}/back/chapter/chapterAdd.jsp?id="+select.id,
                                title:"章节添加",
                                draggable:false,//不能随意移动窗口
                                iconCls:'icon-add',
                                width:400,
                                height:410,
                                buttons:[{
                                    text:'保存',
                                    iconCls:'icon-save',
                                    handler:function(){
                                        addChapter()
                                    }
                                },{
                                    text:'关闭',
                                    iconCls:'icon-cancel',
                                    handler:function(){
                                        $("#chapteradd").dialog("close",true);
                                    }
                                }]
                            });
                        }
                    }
              },
            ],
        });
    });

    function addChapter() {
        $("#addChapter").form('submit',{
            url:"${pageContext.request.contextPath}/chapter/save",
            success:function (result) {
                var parseJSON = $.parseJSON(result);
                if(parseJSON.success){
                    $.messager.show({title:'温馨提示',msg:'章节添加成功！'});
                }else{
                    $.messager.show({title:'温馨提示',msg:parseJSON.msg});
                }
                $("#chapteradd").dialog("close",true);
                $("#album").treegrid("reload");
            },
        });
    }

    function show(id) {
        $("#selectalbum").dialog({
            href:"${pageContext.request.contextPath}/back/album/selectAlbum.jsp?id="+id,
            buttons:[
                {
                    text:"取消",
                    iconCls:"icon-remove",
                    handler:function(){
                        $("#selectalbum").dialog('close',true);
                    }
                },],
        });
    }
</script>

<table id="article" data-options="fit:true">

</table>
<%--创建头部的两个按钮--%>
<div id="articlebut">
    <a href="#" class="easyui-linkbutton" onClick="save2();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>

<%--创建添加的弹出窗口--%>
<div id="articleadd"
     data-options="         width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存信息',
                          "></div>
<%--创建修改窗口的div--%>
<div id="articlealbum" data-options="draggable:false,width:650,height:600,iconCls:'icon-edit',title:'修改用户信息'"></div>
