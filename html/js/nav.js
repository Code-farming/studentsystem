var json = window.sessionStorage.getItem("user");
var user = JSON.parse(json);
if (user == null) {
    window.location.href = "./index.html"
}

//用户名的显示
$(function () {
    var json = window.sessionStorage.getItem("user");
    var user = JSON.parse(json);
    var username = user.username;
    $("#name").html(username);
})

//获取用户信息
findInformation = function () {
    var json = window.sessionStorage.getItem("user");
    var user = JSON.parse(json);
    var role = "";
    $("#studentId").html(user.id);
    $("#studentName").html(user.username);
    console.log(user.roleId)
    debugger
    switch (user.roleId) {
        case 1:
            role = "普通学生";
            break;
        case 2:
            role = "课代表";
            break;
        case 3:
            role = "班长";
            break;
    }
    console.log(role);
    $("#studentRole").html(role);
}

//修改密码
updatePass = function () {
    {
        $('#oldSpan').addClass('hidden');
        $('#newSpan').addClass('hidden');
        $('#reSpan').addClass('hidden');
        var oldpwd = $('input[name="oldPwd"]').val();
        var newpwd = $('input[name="newPwd"]').val();
        var repwd = $('input[name="rePwd"]').val();
        var json = window.sessionStorage.getItem("user");
        var user = JSON.parse(json);

        if (newpwd.length < 1) {
            $('#newSpan').removeClass('hidden');
            return;
        }
        if (newpwd != repwd) {
            $('#reSpan').removeClass('hidden');
            return;
        }
        var params = {};
        params.id = user.id;
        params.oldPassword = oldpwd;
        params.newPassword = newpwd;
        $.ajax({
            url: '/ssm/user/updatePass',
            method: 'POST',
            dataType: 'json',
            data: JSON.stringify(params),
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {//data是成功后，接收的返回值
                if (data.code == 200) {
                    alert('修改密码成功');
                    window.location.href = './index.html';
                } else {
                    //不存在
                    alert('修改密码失败');
                    $('#oldSpan').removeClass('hidden');
                    return;
                }
            },
            error: function () {
                window.console.log('失败回调函数');
            }
        });

        $('input[name="oldpwd"]').val('');
        $('input[name="newpwd"]').val('');
        $('input[name="repwd"]').val('');
        $(function () {
            $('#pwdModal').modal('hide')
        });
    }
}

//退出登录
logout = function () {
    $.ajax({
        url: '/ssm/user/logout',
        method: 'get',
        dataType: 'json',
        success: function (data) {//data是成功后，接收的返回值
            if (data.code == 200) {
                sessionStorage.removeItem("user");
                window.location.href = './index.html';
            } else {
                //不存在
            }
        },
        error: function () {
            window.console.log('失败回调函数');
        }
    });
}