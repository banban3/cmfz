<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#user").datagrid({
            url:'${pageContext.request.contextPath}/user/findAll',
            pagination:true,//显示分页栏
            pageNumber:1,//当前页
            pageSize:5,//每页显示记录数
            pageList:[2,5,10,15,30],
            striped:true,//斑马线效果
            remoteSort:false,//关闭从服务器进行的排序
            columns:[[
                {field:'id',title:'id.',width:180,},
                {field:'name',title:'名称.',width:180,},
                {field:'password',title:'密码',width:180},
                {field:'phone',title:'电话号码',width:180},
                {field:'img_url',title:'图片地址',width:180},
                {field:'fname',title:'法名',width:180},
                {field:'stat',title:'状态',width:180}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.img_url +'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.title + '</p>' +
                    '<p>Status: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar: [
                {
                    iconCls: 'icon-tip',
                    text:'冻结用户',
                    handler: function(){
                        var user=$("#user").datagrid("getSelected");

                        if (user==null) {
                            $.messager.show({title:'温馨提示',msg:'至少选中一个用户！'});
                        }else{
                            if (user.stat=="正常"){
                                $.ajax({
                                    type:"get",
                                    url:"${pageContext.request.contextPath }/user/updateStat?sta=冻结&id="+user.id,
                                    success:function (data) {
                                        var parseJSON = $.parseJSON(data);
                                        if(parseJSON.suc){
                                            $.messager.show({title:'温馨提示',msg:'用户冻结成功！'});
                                        }else{
                                            $.messager.show({title:'温馨提示',msg:'用户冻结失败！'});
                                        }
                                    }
                                });
                                $("#user").datagrid("reload",true);
                            }else{
                                $.messager.show({title:'温馨提示',msg:'该用户已经冻结！'});
                            }
                        }
                    }
                },{
                    iconCls: 'icon-add',
                    text:'解冻用户',
                    handler: function(){
                        var user=$("#user").datagrid("getSelected");

                        if (user==null) {
                            $.messager.show({title:'温馨提示',msg:'至少选中一个用户！'});
                        }else{
                            if (user.stat=="冻结"){
                                $.ajax({
                                    type:"get",
                                    url:"${pageContext.request.contextPath }/user/updateStat?sta=正常&id="+user.id,
                                    datatype:"data",
                                    success:function (data) {
                                        var parseJSON = $.parseJSON(data);
                                        if(parseJSON.suc){
                                            $.messager.show({title:'温馨提示',msg:'用户解冻成功！'});
                                        }else{
                                            $.messager.show({title:'温馨提示',msg:'用户解冻失败！'});
                                        }
                                    }
                                });
                                $("#user").datagrid("reload",true);
                            }else{
                                $.messager.show({title:'温馨提示',msg:'该用户已经为正常模式！'});
                            }
                        }
                    }
                },
                {
                    iconCls: 'icon-save',
                    text:'添加用户',
                    handler: function(){
                            $("#useradd").dialog({
                                href:"${pageContext.request.contextPath}/back/user/add.jsp",
                                title:"用户添加",
                                draggable:false,//不能随意移动窗口
                                iconCls:'icon-add',
                                width:700,
                                height:510,
                                buttons:[{
                                    text:'保存',
                                    iconCls:'icon-save',
                                    handler:function(){
                                        addChapter();
                                    }
                                },{
                                    text:'关闭',
                                    iconCls:'icon-cancel',
                                    handler:function(){
                                        $("#useradd").dialog("close",true);
                                    }
                                }]
                            });
                    }
              },
            ],
        });
    });

    function addChapter() {
        $("#addUser").form('submit',{
            url:"${pageContext.request.contextPath}/user/add",
            success:function (result) {
                var parseJSON = $.parseJSON(result);
                if(parseJSON.suc){
                    $.messager.show({title:'温馨提示',msg:'添加成功！'});
                    $("#useradd").dialog("close",true);
                    $("#user").datagrid("reload",true);
                }else{
                    $.messager.show({title:'温馨提示',msg:'添加失败'});
                    $("#useradd").dialog("close",true);
                    $("#user").datagrid("reload",true);
                }
                //$("#useradd").dialog("close",true);
               ///* $("#user").datagrid("reload",true);
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

<table id="user" data-options="fit:true">

</table>
<%--创建头部的两个按钮--%>
<div id="userbut">
    <a href="#" class="easyui-linkbutton" onClick="save2();" data-options="iconCls:'icon-add',plain:true">添加</a>
</div>

<%--创建添加的弹出窗口--%>
<div id="useradd"
     data-options="         width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存信息',
                          "></div>
<%--创建修改窗口的div--%>
<div id="useredit" data-options="draggable:false,width:650,height:600,iconCls:'icon-edit',title:'修改用户信息'"></div>
