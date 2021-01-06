layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;

    var tableIns = table.render({
        elem: '#flowertable',
        height: 600,
        url: '../order/selectAll',
        title: '鲜花进货记录',
        page: true,
        toolbar: '#headDemo',
        cols: [
            [
                {
                    field: 'flowerName',
                    title: '鲜花名',
                }, {
                field: 'count',
                title: '进货数目',
            }, {
                field: 'createTime',
                title: '上传时间'
            }
            ]
        ]
    });
});