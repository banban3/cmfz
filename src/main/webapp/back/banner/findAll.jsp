<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<script>
        $("#dg").datagrid({
            url:'${pageContext.request.contextPath}/banner/findAll',
            pageNumber:1,//当前页
            pageSize:5,//每页显示记录数
            pageList:[2,5,10,15,30],
            striped:true,//斑马线效果
            remoteSort:false,//关闭从服务器进行的排序
            columns:[[
                {field:'che',title:'che',checkbox:true,},
                {field:'id',title:'id',width:250,editor:"{type:'validatebox',options:{required:true}}" },
                {field:'title',title:'标题',width:150},
                {field:'img_url',title:'图片地址',width:150,},
                {field:'des',title:'描述',width:150,},
                {field:'sta',title:'状态',width:150,},
                {field:'i_date',title:'上传时间',width:150,},
                {title:"options",field:"options",width:150,
                    formatter:function(value,row,index){
                        return  "<a href='javascript:;' onClick=\"delRow('"+row.id+"')\", class='options' data-options=\"iconCls:'icon-remove',plain:true,\">删除</a>&nbsp;&nbsp;" +
                            "<a href='javascript:;' onClick=\"upd('"+row.id+"')\", class='options' data-options=\"iconCls:'icon-edit',plain:true,\">修改</a>";
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.img_url+ '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.i_date + '</p>' +
                    '<p>Status: ' + rowData.sta + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },


        onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:"#tb",
        });


        //删除一行的事件
        function delRow(id) {
            //删除弹出确认框
            $.messager.confirm("操作提示", "您确定要删除该记录吗？", function (r) {
                if (r) {
                    //获取到当前单击获取到的id,发送远程请求 删除这个id下的数据
                    $.post("${pageContext.request.contextPath}/banner/delete",
                        {"id":id},
                        function (result) {//成功之后的响应函数
                            var resultObj=$.parseJSON(result);
                            if (resultObj.success){
                                //弹出删除成功的界面
                                $.messager.show({title:"提示",msg:"用户删除成功"});
                            } else{
                                //弹出删除失败的界面
                                $.messager.show({title:"提示",msg:resultObj.message});
                            }
                            //刷新datagrid的页面数据
                            //$("#tab").datagrid('reload');
                            $("#dg").datagrid('reload');
                        });
                    $("#dg").datagrid('reload');
                }
            });

        }


        //修改更新用户 打开修改用户对话框
        function upd(id) {
            $("#editDialog").dialog({
                href:"${pageContext.request.contextPath}/back/banner/edit.jsp?id="+id,
                buttons:[
                    {
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#editForm").form('submit',{
                                url:"${pageContext.request.contextPath}/banner/update",
                                success:function (result) {
                                    //关闭弹出的窗口
                                    $("#editDialog").dialog('close');
                                    //刷新页面
                                    $("#dg").datagrid('reload');
                                    //弹出修改成功的界面
                                    $.messager.show({title:"提示",msg:"图片修改成功"});
                                }
                            });
                        }
                    },{
                        text:"取消",
                        iconCls:"icon-remove",
                        handler:function(){
                            $("#editDialog").dialog('close',true);
                        }
                    },],
            });
        }


        //添加一行数据
        function save() {
            $("#savedialog").dialog({
                buttons:[
                    {
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function(){
                            $("#addForm").form('submit',{
                                url:"${pageContext.request.contextPath}/banner/add",

                                success:function (result) {
                                    var resultObj=$.parseJSON(result);
                                    if (resultObj.suc){
                                        //弹出添加成功的界面
                                        $.messager.show({title:'提示',msg:resultObj.msg})
                                        //关闭弹出的窗口
                                        $("#savedialog").dialog('close');
                                        //刷新页面
                                        $("#dg").datagrid('reload');
                                    } else{
                                        //弹出添加失败的界面
                                        $.messager.show({title:"提示",msg:resultObj.msg});
                                    }
                                }
                            });
                        }
                    },
                    {
                        text:"取消",
                        iconCls:"icon-remove",
                        handler:function(){
                            $("#savedialog").dialog('close',true);
                        }
                    }
                ],
            });
        }


        // 批量删除多行
       /* function deleteall(){
            //弹出确认删除的对话框
            $.messager.confirm("操作提示", "您确定要删除该记录吗？", function (r) {
                if (r) {
                    var rows= $("#deptbg").datagrid('getSelections');
                    if (rows.length<=0) {
                        $.messager.show({title:'提示',msg:"至少选中一行！",});
                    }else{
                        var ids=[];
                        for (var i=0;i<rows.length;i++) {
                            //console.log(rows[i]);
                            ids.push(rows[i].id);
                        }
                        //console.log(ids);
                        //发送ajax请求   注意: $.get $.post 只能传递简单数据(key=value) 不能数组类型的数据
                        // 如果想要传递数组类型的数据只能使用  $.ajax 并且还要设置其中的一个属性
                        $.ajax({
                            //url:"/user/deleteAll",
                            type:"POST",
                            data:{id:ids},
                            traditional:true,//传递数组类型的数据必须设置为true
                            success:function (result) {
                                //消息提示
                                var resultObj=$.parseJSON(result);
                                if (resultObj.success){
                                    //弹出修改成功的界面
                                    $.messager.show({title:"提示",msg:"用户删除成功"});
                                } else{
                                    //弹出修改成功的界面
                                    $.messager.show({title:"提示",msg:resultObj.message});
                                }
                                //$.messager.show({title:'提示',msg:"删除成功！",});
                                //刷新datagrid
                                //$("#tab").datagrid('reload');

                            },
                            error:function () {
                                $.messager.show({title:'提示',msg:"删除失败！",});
                                //刷新datagrid
                                //$("#tab").datagrid('reload');
                            }
                        });
                        $("#deptbg").datagrid('reload');
                    }
                }
            });
            }
*/


</script>
<table id="dg" data-options="fit:true">

</table>
<%--创建头部的两个按钮--%>
<div id="tb">
    <a href="#" class="easyui-linkbutton" onClick="save();" data-options="iconCls:'icon-add',plain:true">添加</a>
<%--
    <a href="#" class="easyui-linkbutton" onClick="deleteall();" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
--%>
</div>

<%--创建添加的弹出窗口--%>
<div id="savedialog"
     data-options=" href:'${pageContext.request.contextPath}/back/banner/add.jsp',
                            width:600,
                            height:450,
                            draggable:false,<%--是否能移动窗口--%>
                            title:'保存用户信息',
                          "></div>

<%--创建修改窗口的div--%>
<div id="editDialog" data-options="draggable:false,width:650,height:500,iconCls:'icon-edit',title:'修改用户信息'"></div>
