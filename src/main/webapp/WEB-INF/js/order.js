function fun() {
    layui.use('table', function () {
        var table = layui.table;
        var id = document.getElementById("userId").value;
        console.log(id);
        table.render({
            elem: '#test'
            , url: "../order/selectById
            , cols: [
                [
                    {
                        field: 'flowerName',
                        title: '鲜花名字'
                    }
                    , {
                    field: 'count',
                    title: '数量',
                    sort: true
                }
                    , {
                    field: 'createTime',
                    title: '创建时间',
                    sort: true
                }
                ]
            ]
        });
    });
}