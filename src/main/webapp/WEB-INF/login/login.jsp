<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../res/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">	
<script src="../js/jquery-1.11.1.min.js"></script>

<title>登录页面</title>
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">		
			<h1 class="margin-bottom-15">欢迎使用</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="#" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="username" placeholder="请输入用户名">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" placeholder="请输入密码">
		            </div>
		          </div>
		        </div>
		        <!--  
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                		<input class="autoLoginCheckbox" type="checkbox"  name="checked" id="checked1" value="1" />	                	
                                                                                   下次自动登录
                		</label>
	              	</div>
		          </div>
		        </div>
		        -->
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
				        <button type="button" id="loginBtn" class="btn btn-primary btn-lg btn-block mt30" onClick="return checkForm();" >登录</button>
		            </div>
		          </div>
		        </div>
		        <!--  
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="Log in" class="btn btn-info">
		          		<a href="forgot-password.html" class="text-right pull-right">忘记密码?</a>
		          	</div>
		          </div>
		        </div>
		        -->
		        <hr>
		      </form>
		      <!--  
		      <div class="text-center">
		      	<a href="create-account.html" class="templatemo-create-new">创建账户<i class="fa fa-arrow-circle-o-right"></i></a>	
		      </div>-->
		</div>
	</div>
</body>
<script type="text/javascript">	
		function checkForm(){
			 var username = document.getElementById("username").value.trim();
			    //判断用户编码是否填写。
			    if (username == ""){
			        document.getElementById("username").focus();
			        alert("请填写用户名!");
			        return false;
			    }
			    
			    //判断密码是否填写。
			    var password = document.getElementById("password").value.trim();
			    if (password == ""){
			        document.getElementById("password").focus();
			        alert("请填写密码!");
			        return false;
			    } 
			              
			    
				var json = "";
				json += "username:"+ username;
				json += ",password:"+ password;
				$.ajax({
					
				    url: "${ctx}/logins/login_in.do",
				    dataType : "json",
				    type : "POST",
				    async: false,
				   	//data:"paramsStr={'preOrderKey':9}",
				   	data:{"username" : username,"password" : password},
				    success: function(result) {

				    	alert(result.returnCode);
				    	alert(result.returnMsg);

				 /*   	if(result.pTCRSverFlg == 1){//在线
				    		$(".pTCRSverFlg").html("在线");
				    		$(".pTCRSverFlg").css("color","green");
				    	}else{//离线
				    		$(".pTCRSverFlg").html("服务已离线,请及时处理");
				    		$(".pTCRSverFlg").css("color","red");
				    	}

				    */
				    },
				    error: function(XMLHttpRequest, textStatus, errorThrown) {
				    	
				    }
				});
	    
		/*$(function(){
		$(".autoLoginCheckbox").iCheck({
		   checkboxClass: 'icheckbox_square-orange fl',
		   increaseArea: '80%'
		});
		
		$("#userCode").focus();
		
		$("body").css( "height" , $(window).height()+"px");
		
		$(".autoLoginCheckbox").on('ifChecked', function(event){
			 $("#checked1").val("0");
		});
		
		$(".autoLoginCheckbox").on('ifUnchecked', function(event){
			$("#checked1").val("1");
		});
	});
	*/
	    return true;
		}

	</script>
	
</html>