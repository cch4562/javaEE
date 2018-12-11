function check() {
    var uid=document.getElementById("uid").value;
    if(uid.length==0||uid==" "){
        alert("学号不能为空");
        return false;
    }
    var name=document.getElementById("name").value;
    if(name.length==0||name==" "){
        alert("姓名不能为空");
        return false;
    }
    var pwd=document.getElementById("pwd").value;
    if(pwd.length==0||name==" "){
        alert("密码不能为空");
        return false;
    }
    var link=document.getElementById("link").value;
    if(link.length==0||link==" "){
        alert("联系方式不能为空");
        return false;
    }
    var roles=document.getElementById("roles").value;
    if(roles.length==0||roles==" "){
        alert("角色不能为空");
        return false;
    }
    return true;
}

