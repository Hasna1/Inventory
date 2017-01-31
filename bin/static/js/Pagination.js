Skip to content
This repository
Search
Pull requests
Issues
Gist
 @Hasna1
 Unwatch 39
  Star 0
  Fork 0 Fusemachines/prospectordashboard Private
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Pulse  Graphs
Branch: master Find file Copy pathprospectordashboard/src/main/resources/static/content/script/pagination.js
2838f55  on Aug 18, 2016
@aarati-shrestha aarati-shrestha small changes
2 contributors @aarati-shrestha @AnupGrahan
RawBlameHistory    
236 lines (187 sloc)  5.42 KB

var page;
var size;
var companyClientId;
var productId;

$( document ).ready(function() {
	var url = $("#url").val();
	console.log("url", url);
	
	$(function () {
		var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $(document).ajaxSend(function(e, xhr, options) {
	        xhr.setRequestHeader(header, token);
	    });
	});
	
	if(window.history.state){
		page = window.history.state.page;
	}else{
		page = 1;
	}
	if(url == '/displayproduct'){
		console.log("here");
		page = 1;
		//history.pushState({ "page": page, "size" : size }, "title",  "/dashboard/clientcompany");
		$.ajax({
			type:"GET",
			url:'/displayproduct',
			data:{ page : 1, size:5},
			success: function(res){
				console.log("insidee document");
				history.pushState({ "page": page, "size" : size, }, "title",   "/displayproduct");
				$('tbody').remove();
				$('table').append($(res).find('tbody'));
				
			},
			error : function(){
				console.log("error");
		}
		});
	}
	console.log("page number",page );
	size = 5;
	if(page == totalPage ){
		$('#nextbtn').attr('disabled',true);
	}
	if(page == 1){
		$('#previousbtn').attr('disabled',true);
	}
	
	$("#searchForm").submit(function(e){
		e.preventDefault();
		var url = 'productdisplay';
		searchProduct(url);
	});

});





function nextPage(){
	var url = $("#url").val();
	var searchValue = $('#searchProduct').val();
	var totalPages = $("#totalPage").val()
	$('#previousbtn').attr('disabled',false);
	page++;
	
	
	if(totalPages == page ){
		$('#nextbtn').attr('disabled',true);
	}
	console.log("total page", totalPages, page);
	$.ajax({
		type:"GET",
		url: url,
		data:{ page : page, size: size, key: searchValue},
		success: function(res){
			history.pushState({ "page": page, "size" : size}, "title", url+ "?page="+page);
			$('tbody').remove();
			$('table').append($(res).find('tbody'));
			
		},
		error : function(){
			console.log("error");
	}
	});
	
	
}


function prevPage(){
	var url = $("#url").val();
	var searchValue = $("#searchProduct").val();
	if(totalPage == 1 ){
		$('#previousbtn').attr('disabled',true);
	}	
	$('#nextbtn').attr('disabled',false);
	page--;
	if(page == 1){
		$('#previousbtn').attr('disabled',true);
	}
	
	
	$.ajax({
		type:"GET",
		url: url,
		data:{ page : page, size:10, key: searchValue},
		success: function(res){
			history.pushState({ "page": page, "size" : size, }, "title",  url+ "?page="+page);
			$('tbody').remove();
			$('table').append($(res).find('tbody'));
			
		},
		error : function(){
			console.log("error");
	}
	});
}




function searchClientCompany(url){
	page=1;
	var searchValue = $('#searchProduct').val();
	console.log('search value ' , searchValue);
	$.ajax({
		type:"GET",
		url: url,
		data:{ key : searchValue, page,size},
		success: function(res){						
			//history.pushState({ "size" : size }, "title",  "/dashboard/clientcompany?page="+page);
			$('tbody').remove();
			$('table').append($(res).find('tbody'));
			totalPageNo = $("#totalPage").val();
			console.log("totalPage", totalPage);
			if(totalPageNo <= 1 ){
				console.log("inside here");
				console.log("totalPagewerty",totalPage );
				$('#nextbtn').attr('disabled',true);
			}else{
				$('#nextbtn').attr('disabled',false);
			}
			if(page == 1){
				$('#previousbtn').attr('disabled',true);
			}
		},
		error : function(){
			console.log("error");
	}
	});
}




function editData (id){
	productId = id;
}


$(document).on('click', '.btn-cc-edit',function(){
	
	var currentRow = $(this).parents('tr');
	var colTwo = currentRow.children("td").eq(1);
	var colThree = currentRow.children("td").eq(2);
	var colFour = currentRow.children("td").eq(3);
    var btnEdit = colFour.children("button");
    if(btnEdit.text() == "update"){
    	var _this = this;
    	$(_this).attr('disabled',true);
    	var tdc = currentRow.children("td").eq(1).find("input").val();
    	var udc = currentRow.children("td").eq(2).find("input").val();
    	console.log("inside dddkdkdl", tdc, udc);
    	if(Number(udc) > Number(tdc)){
    		alert("Total Discover Credit is greater than Used Discover Credit");
    		return;
    		//console.log("this is it");
    	}
    
    	var jsonData ={
    			"id" : productId,
    			"totalDiscoverCredit" : tdc,
    			"usedDiscoverCredit" : udc
    	}
    	$.ajax({
    		url : "/displayproduct?page="+page+"&&size="+size,
    		type: "PUT",
    		contentType: "application/json",
            data: JSON.stringify(jsonData)
    	}).done(function(data){
    		colTwo.html(data.totalDiscoverCredit);
    		colThree.html(data.usedDiscoverCredit);
    		$(_this).attr('disabled',false);
    		btnEdit.text("Edit");
    		$('.bottom-left').notify({
  	          message: { text: "The client company has been updated" },
  	          
  	          //type: ' blackgloss',
  	          type: "info",
  	          fadeOut: {
  	            delay: Math.floor(Math.random() * 500) + 2500
  	          }
  	        }).show();
    	}).error(function(){
    		$(_this).attr('disabled',false);
    		console.log("argurments",arguments);
    		console.log("inside fail");
    	});
    	
    		
    	
    	return;
    }
	
	var text = colTwo.text();
    $(colTwo).html($('<input />',{'value' : text, 'type' : 'number', 'id' : 'totalDC'}).val(text));
    
	var text = colThree.text();
    $(colThree).html($('<input />',{'value' : text, 'type' : 'number', 'id' : 'usedDC'}).val(text));       
    btnEdit.text("update");     
     return;
	
});







Contact GitHub API Training Shop Blog About
© 2017 GitHub, Inc. Terms Privacy Security Status Help