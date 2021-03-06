<%--

    Copyright 2020-2021 redragon.dongbin
 
    This file is part of redragon-erp/赤龙ERP.

    redragon-erp/赤龙ERP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 2 of the License, or
    (at your option) any later version.

    redragon-erp/赤龙ERP is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with redragon-erp/赤龙ERP.  If not, see <https://www.gnu.org/licenses/>.
	
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="searchDiv" class="ibox " style="display: none;">
	<div class="ibox-title collapse-link" style="cursor: pointer;"
		title="展开/收起查询条件">

		<h5>查询条件</h5>
		<div class="ibox-tools"></div>

	</div>
	
	<form action="web/mdMaterial/getMdMaterialList" method="get">
	<div class="ibox-content m-b-sm border-bottom">
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label class="control-label" for="materialCode">物料/事项编码</label> 
					<input type="text" id="materialCode" name="materialCode" value="${param.materialCode}" class="form-control">
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label class="control-label" for="materialName">物料/事项名称</label> 
					<input type="text" id="materialName" name="materialName" value="${param.materialName}" class="form-control">
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label class="control-label" for="materialType">物料或事项</label>
					<select name="materialType" id="materialType" class="form-control">
						<option value="" selected="">请选择</option>
						<c:forEach items="${requestScope.materialTypeMap}" var="materialType">
                       		<option value="${materialType.key}">${materialType.value}</option>
                       	</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="row">	
			<div class="col-sm-4">
				<div class="form-group">
					<label class="control-label" for="categoryCode">物料/事项类别</label> 
					<select name="categoryCode" id="categoryCode" class="form-control">
						<option value="" selected="">请选择</option>
						<c:forEach items="${requestScope.materialCategoryMap}" var="materialCategory">
                       		<option value="${materialCategory.key}">${materialCategory.value}</option>
                       	</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label class="control-label" for="status">状态</label> 
					<select name="status" id="status" class="form-control">
						<option value="" selected="">请选择</option>
						<option value="Y">有效</option>
						<option value="N">无效</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-right">
				<div class="form-group">
					<button type="submit" class="btn btn-w-m btn-primary">查询</button>
				</div>
			</div>
		</div>
	</div>
	
	<%-- 隐藏字段 --%>
	<input type="hidden" name="page" value="1">
	</form>
</div>

<script>
$(document).ready(function(){
	//设置状态默认值
	if("${param.status}"!=""){
		$("#status").val("${param.status}");
	}
	//设置materialType默认值
	if("${param.materialType}"!=""){
		$("#materialType").val("${param.materialType}");
	}
	//设置物料类别默认值
	if("${param.categoryCode}"!=""){
		$("#categoryCode").val("${param.categoryCode}");
	}
});
</script>
