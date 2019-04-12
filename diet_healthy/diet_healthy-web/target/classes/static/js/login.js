function check(){
		var username=$("#username").val();
		var password=$("#password").val();
		var yanzhengma=$("#yanzhengma").val();
		if($.trim(username)=="" || $.trim(password)=="" || $.trim(yanzhengma)==""){
			alert("请内容输入完整");
			history.go(0);
			return false;
		}
		var val = $("[name=identity]:checked").val();
		if(val == null){
			alert("您还未选择身份");
			return false;
		}
		return true;
}