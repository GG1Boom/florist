function fun() {
    layui.use('table', function () {
        var table = layui.table;
        var tableIns = table.render({
            elem: '#flowertable'
            , height: 800
            , url: "../flower/selectByName?name="+document.getElementById("name").value
            , cols: [
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
    })
}