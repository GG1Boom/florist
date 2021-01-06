layui.use(['table','form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;

    var tableIns = table.render({
        elem: '#flowertable',
        height: 600,
        url: 'http://localhost:8080/florist/flower/selectAll',
        title: '鲜花库存',
        page: true,
        toolbar: '#headDemo',
        cols: [
            [
                {
                    type: 'checkbox',
                    fixed: 'left'
                }, {
                field: 'id',
                title: '编号',
                sort: true,
                fixed: 'left',
            }, {
                field: 'name',
                title: '花名',
            }, {
                field: 'path',
                title: '图片',
                templet: function (d) {
                    var path = d.path;
                    return '<img width="60px" height="30x" src="../' + path + '"/>'
                }
            }, {
                field: 'buy',
                title: '买入数量',
                sort: true
            }, {
                field: 'sell',
                title: '卖出数量',
                sort: true,
            }, {
                field: 'cost',
                title: '成本',
                sort: true,
            }, {
                field: 'price',
                title: '售价',
                sort: true,
            }, {
                field: 'information',
                title: '详细信息',
            }, {
                field: 'role',
                title: '类型',
            }, {
                fixed: 'right',
                width: 165,
                align: 'center',
                toolbar: '#barDemo'
            }
            ]
        ]
    });

    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data;
        switch (obj.event) {
            case 'add':
                layer.open({
                    type: 2,
                    title: '添加花卉',
                    area: ['60%', '60%'],
                    content: 'addFlower.html'
                });
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    //声明一个数组存放选中的数据
                    var ids = new Array();
                    for (var i in data) {
                        ids[i] = data[i].id;
                    }
                    layer.confirm("是否确认删除？", function (index) {
                        $.ajax({
                            type: 'post',
                            url: '../flower/deleteById',
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

    table.on('tool(test)', function (obj) {
        var data = obj.data;
        var id = data.id;
        var ids = new Array();
        ids[0] = id;
        layer.confirm('真的删除这一行吗？', function (index) {
            $.ajax({
                type: 'post',
                url: '../flower/deleteById',
                data: {
                    'ids': ids
                },
                dataType: "json",
                traditional: true,
                success: function (res) {
                    if (res.code == 200) {
                        layer.msg(res.msg)
                        obj.del();
                        layer.close(index);
                    } else {
                        layer.msg(res.msg);
                    }
                }
            })
        });
    })
})