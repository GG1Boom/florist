layui.use(['table', 'form', 'jquery', 'layer'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery,
        layer = layui.layer

    var tableIns = table.render({
        elem: '#videotable',
        height: 600,
        url: '../flower/rank'
        ,
        title: '鲜花信息',
        page: false
        ,
        toolbar: '#headDemo'
        ,
        cols: [
            [
                {
                    field: 'name',
                    title: '鲜花'
                }, {
                field: 'sell',
                title: '畅销度',
            },

            ]
        ]
    });


});