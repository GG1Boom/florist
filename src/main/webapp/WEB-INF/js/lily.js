layui.use('table', function () {
    var table = layui.table;

    table.render({
        elem: '#test'
        , url: '../member/class?role=百合'
        , cols: [
            [
                {
                field: 'name',
                title: '鲜花名字'
            }
                , {
                field: 'path',
                title: '图片',
                templet: function (d) {
                    var path = d.path;
                    return '<img width="60px" height="30x" src="../' + path + '"/>'
                }
            }
                , {
                field: 'sell',
                title: '已卖出',
                sort:true
            }
                , {
                field: 'price',
                title: '售价',
                sort: true
            }
                , {
                field: 'information',
                title: '信息'
            }
            ]
        ]
    });
});