<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#album").treegrid({
            url:"${pageContext.request.contextPath}/album/findPage",
            idField:'id',
            treeField:'name',
            lines:true,
            pagination:true,//显示分页栏
            pageNumber:1,//当前页
            pageSize:100,//每页显示记录数
            pageList:[2,5,10,15,30,100],
            columns:[[
                {title:'name',field:'name',width:180},
                {field:'downpath',title:'下载路径.',width:600,},
                {field:'size',title:'章节大小',width:180},
                {field:'downloadtime',title:'章节时长',width:180}
            ]],
            toolbar: [
                {
                    iconCls: 'icon-tip',
                    text:'专辑详情',
                    handler: function(){
                        var roots = $("#album").treegrid("getRoots");
                        var select = $("#album").edatagrid("getSelected");
                        if(select == null){
                            $.messager.show({title:'温馨提示',msg:'至少选中一行！'});
                        }else{
                            var index = $.inArray(select,roots);
                            if(index!=-1){
                                show(select.id,select.img_url);
                                //alert(select.img_url);
                            }else{
                                $.messager.show({title:'温馨提示',msg:'请选择专辑！'});
                            }
                        }
                    }
                },{
                    iconCls: 'icon-add',
                    text:'增加专辑',
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
                    text:'增加章节',
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
                {
                    iconCls: 'icon-undo',
                    text:'下载音频',
                    handler: function(){
                        var roots = $("#album").treegrid("getRoots");
                        var select = $("#album").edatagrid("getSelected");
                        if(select == null){
                            $.messager.show({title:'温馨提示',msg:'至少选中一行！'});
                        }else{
                            var index = $.inArray(select,roots);
                            if(index==-1){
                                location.href="${pageContext.request.contextPath }/chapter/download?fileName="+select.downpath+"&openStyle=attachment";
                            }else{
                                $.messager.show({title:'温馨提示',msg:'请选择章节！'});
                            }
                        }
                    },
                }
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

    function show(id,img_url) {
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

<table id="album" data-options="fit:true">

</table>
<%--创建头部的两个按钮--%>
<div id="albumbut">
    <a href="#" class="easyui-linkbutton" onClick="save2();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>

<%--创建添加的弹出窗口--%>
<div id="albumadd"
     data-options="         width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存信息',
                          "></div>
<div id="chapteradd"
     data-options="         width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存信息',
                          "></div>

<%--创建修改窗口的div--%>
<div id="selectalbum" data-options="draggable:false,width:650,height:600,iconCls:'icon-edit',title:'修改用户信息'"></div>
