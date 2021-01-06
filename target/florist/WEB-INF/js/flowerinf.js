layui.use(['table', 'form', 'jquery', 'layer'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery,
        layer = layui.layer

    var tableIns = table.render({
        elem: '#flowerTable',
        url: '../flower/selectAll',
        title: '鲜花信息',
        toolbar: '#headDemo',
        cols: [
            [
                {
                    field: 'id',
                    title: 'ID',
                    sort: true,
                    fixed: 'left'
                }, {
                field: 'name',
                title: '鲜花'
            }, {
                field: 'path',
                title: '参考图',
                templet: function (d) {
                    var path = d.path;
                    return '<img width="60px" height="30x" src="../' + path + '"/>'
                }
            },
            ]
        ]
    });
});