// 定义服务层:
app.service("brandService",function($http){
	this.findAll = function(){
		return $http.get("../brand/findAll.do");
	}

	this.findByPage = function(page,rows){
		return $http.get("../brand/findByPage.do?page="+page+"&rows="+rows);
	}

	this.save = function(entity){
		return $http.post("../tbBrand/insert",entity);
	}

	this.update=function(entity){
		return $http.put("../tbBrand/update",entity);
	}

	this.findById=function(id){
		return $http.get("../tbBrand/get/"+id);
	}

	this.dele = function(ids){
		return $http.delete("../tbBrand/delete/"+ids);
	}

	this.search = function(page,rows,searchEntity){
		return $http.post("../tbBrand/search?page="+page+"&rows="+rows,searchEntity);
	}

	this.selectOptionList = function(){
		return $http.get("../brand/selectOptionList.do");
	}
});