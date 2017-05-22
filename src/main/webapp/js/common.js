function submitForm(_idName){
    $("#"+_idName).submit();
}
function multiSelect(checkClass,formId,listName){
    $("."+checkClass).click(function(){
        if($(this).attr('checked')){
            $('<input>').attr('type','hidden').attr('name',listName).attr('value',$(this).attr('name')).appendTo('#'+formId);
        }
        else{
            $('#'+formId+'>input[type=hidden]').filter('[value='+$(this).attr('name')+']').remove();
        }
    });
}

function turnPage(action) {
	var paginationFormId = document.getElementById('paginationFormId').value;
	var obj = document.getElementById('paction');
	if (obj != null) {
		obj.value = action;
	}
	submit(paginationFormId);
}

function gotoPage(page) {
	var paginationFormId = document.getElementById('paginationFormId').value;
	var obj = document.getElementById('ptopage');
	if (obj != null) {
		obj.value = page;
	}
	obj = document.getElementById('paction');
	if (obj != null) {
		obj.value = "";
	}
	submit(paginationFormId);
}

function submit(formName) {
	if (formName == null) {
		return;
	}
	
	var form = document.getElementById(formName);
	if (form == null) {
		return;
	}
	
	form.submit();
}
//string trim 
String.prototype.trim = function() 
{ 
return this.replace(/(^\s*)|(\s*$)/g, "").replace(/(^　*)|(　*$)/g, "").replace(/(^\s*)|(\s*$)/g, ""); 
} 