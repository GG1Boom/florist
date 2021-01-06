layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    form.on('submit(login)',function (data) {
        $.ajax({
            type:'post',
            url:'index/login',
            data:data.field,
            dataType:'json',
            success:function (res) {
                if(res.code==200){
                    layer.msg(res.msg)
                    window.location.href="index/index"
                }else{
                    layer.alert(res.msg,{icon:2})
                }
            }
        })
        return false;
    })

    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})

//重新生成验证码
function changeCode() {
    var img = document.getElementById("codeImg");
    //当某个操作过于频繁 地址都是一样的 浏览器有可能出现直接从上一次的缓存中获取值  所以要new Date（时间戳）
    img.src="index/getCode?time="+new Date().getTime();
}