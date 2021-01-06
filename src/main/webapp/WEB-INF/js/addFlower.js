layui.use('form', function () {
    var form = layui.form,
        $ = layui.jquery;
    form.on('submit(flowerSubmit)', function (data) {
        $.ajax({
            type: 'post',
            url: '../flower/add',
            data: data.field,
            dataType: 'json',
            success: function (res) {
                window.parent.location.reload();
            }
        });
        return false;
    });
})
