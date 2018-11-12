<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#course").datagrid({
            url:"${pageContext.request.contextPath}/course/findAll",
            pagination:true,//显示分页栏
            pageNumber:1,//当前页
            pageSize:5,//每页显示记录数
            pageList:[2,5,10,15,30],
            striped:true,//斑马线效果
            remoteSort:false,//关闭从服务器进行的排序
            columns:[[
                {field:'id',title:'id.',width:210,},
                {field:'homework',title:'功课名称',width:180},
                {field:'score',title:'类型',width:180},
                {field:'user_id',title:'用户id',width:180},
            ]],
            toolbar: [
                {
                    iconCls: 'icon-tip',
                    text:'增加必修课程',
                    handler: function(){
                        $("#courseAdd").dialog({
                            href:"${pageContext.request.contextPath}/back/course/add.jsp",
                            title:'课程添加',
                            draggable:false,
                            iconCls:'icon-add',
                            width:450,
                            height:300,
                            buttons:[{
                                text:'保存',
                                iconCls:'icon-save',
                                handler:function(){
                                    $("#addCourse").form("submit",{
                                        url:'${pageContext.request.contextPath}/course/save',
                                        success:function (result) {
                                            var parseJSON = $.parseJSON(result);
                                            if(parseJSON.suc){
                                                $.messager.show({title:'温馨提示',msg:'添加成功！'});
                                            }else{
                                                $.messager.show({title:'温馨提示',msg:'添加失败！'});
                                            }
                                            $("#courseAdd").dialog("close",true);
                                            $("#course").datagrid("reload");
                                        }
                                    });
                                }
                            },{
                                text:'关闭',
                                iconCls:'icon-cancel',
                                handler:function(){
                                    $("#courseAdd").dialog("close",true);
                                }
                            }]
                        });

                    }
                },{
                    iconCls: 'icon-filter',
                    text:'修改必修课程',
                    handler: function(){
                        var select = $("#course").dialog("getSelected");
                        if(select == null){
                            $.messager.show({title:'温馨提示',msg:'至少选中一行！'});
                        }else{
                            if(select.score=='必修'){
                                showedit(select.id);
                            }else{
                                $.messager.show({title:'温馨提示',msg:'用户添加课程，您无权修改！'});
                            }
                        }
                    }
                },
                {
                    iconCls: 'icon-save',
                    text:'删除必修课程',
                    handler: function(){
                        var select = $("#course").edatagrid("getSelected");
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

    function showedit(id) {
        $("#courseedit").dialog({
            href:"${pageContext.request.contextPath}/back/course/edit.jsp?id="+id,
            buttons:[
                {
                    text:"保存",
                    iconCls:"icon-save",
                    handler:function(){
                        $("#courseEdit").form('submit',{
                            url:"${pageContext.request.contextPath}/course/update",
                            success:function (result) {
                                //关闭弹出的窗口
                                $("#courseedit").dialog('close');
                                //刷新页面
                                $("#course").datagrid('reload',true);
                                //弹出修改成功的界面
                                $.messager.show({title:"提示",msg:"修改成功"});
                            }
                        });
                    }
                },
                {
                    text:"取消",
                    iconCls:"icon-remove",
                    handler:function(){
                        $("#courseedit").dialog('close',true);
                    }
                },],
        });
    }
</script>

<table id="course" data-options="fit:true">

</table>
<%--创建头部的两个按钮--%>
<div id="coursebut">
    <a href="#" class="easyui-linkbutton" onClick="save2();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>

<%--创建添加的弹出窗口--%>
<div id="courseAdd"
     data-options="         width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存信息',
                          "></div>
<%--创建修改窗口的div--%>
<div id="courseedit" data-options="draggable:false,width:650,height:600,iconCls:'icon-edit',title:'修改用户信息'"></div>
