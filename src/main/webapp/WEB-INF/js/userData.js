layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;

    var tableIns=table.render({
        elem: '#user'
        , url: '../member/selectAll',
        toolbar: '#headDemo'
        , cols: [
            [
                {
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                field: 'id',
                title: 'ID',
                sort: true
            }, {
                field: 'username',
                title: '帐号'
            }, {
                field: 'face_image',
                title: '头像',
                templet: function (d) {
                    var path = d.faceImage;
                    return '<img width="40px" height="30x" src="../' + path + '"/>'
                }
            }, {
                field: 'nickname',
                title: '用户名'
            }, {
                field: 'phoneNumber',
                title: '手机号',
            }, {
                field: 'address',
                title: '地址'
            }
            ]
        ]
    });


    table.on('toolbar(userM)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , datas = checkStatus.data;
        switch (obj.event) {
            case 'add':
                layer.open({
                    type: 2,
                    title: '添加会员',
                    area: ['80%', '80%'],
                    content: 'addMember.html'
                })
                break;
            case 'delete':
                if (datas.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    var ids = new Array()
                    for (var i in datas) {
                        ids[i] = datas[i].id
                    }
                    layer.confirm("是否确认删除？", function (index) {
                        $.ajax({
                            type: 'post',
                            url: '../floristManage/deleteById',
                            data: {
                                'ids': ids
                            },
                            dataType: 'json',
                            traditional: true,
                            success: function (res) {
                                if (res.code == 200) {
                                    layer.alert(res.msg, {icon: 1}, function (index) {
                                        layer.close(index)
                                        tableIns.reload();
                                    })
                                } else {
                                    layer.alert(res.msg, {icon: 2}, function (index) {
                                        layer.close(index)
                                    })
                                }
                            }
                        })
                    })
                }
                break;
        }
        ;
    });
});