function fun() {
    layui.use('table', function () {
        var table = layui.table;
        var id=document.getElementById("name").value;

        table.render({
            elem: '#ordertable'
            , height: 800
            , url: "../order/selectById?id=" +id
            , cols: [
                [{
                        field: 'userid',
                        title: 'ID',
                        sort: true,
                        fixed: 'left'
                    }, {
                    field: 'flowerName',
                    title: '花名'
                }, {
                    field: 'count',
                    title: '购买量',
                    sort: true,
                }, {
                    field: 'createTime',
                    title: '创建时间',
                },
                ]
            ]
        });
    })
}