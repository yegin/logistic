<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<link href="/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="/js/select-ui.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="/basic/saveOrUpdate" method="post">
	    <ul class="forminfo">
	    <!-- 隐藏域 保存用户编号 -->
	    <input type="hidden" value="${basic.baseId }" name="baseId">
	    <li><label>数据名称</label><input name="baseName" type="text" class="dfinput" value="${basic.baseName }"/><i>账号不能为空，长度3~6位</i></li>
	    <li><label>描述</label><input name="baseDesc" type="text" class="dfinput" value="${basic.baseDesc }"/><i></i></li>
	    <li><label>类别</label>
	    	<div class="vocation">
			    <select class="select1" name="parentId">
			    	<option value="0">--本身就是大类--</option>
			    	<c:forEach items="${parents }" var="p">
			    		<option value="${p.baseId }" ${p.baseId eq basic.parentId?"selected":"" }>${p.baseName }</option>
			    	</c:forEach>
			    </select>
		    </div>
	    </li>
	    
	   
	    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    
    </form>
    </div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
