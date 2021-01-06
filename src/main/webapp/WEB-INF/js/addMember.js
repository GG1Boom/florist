layui.use('form', function () {
    var form = layui.form,
        $ = layui.jquery;
    form.on('submit(memberSubmit)', function (data) {
        $.ajax({
            type: 'post',
            url: '../user/add',
            data: data.field,
            dataType: 'json',
            success: function (res) {
                window.parent.location.reload()
            }
        })
        return false;
    });
})