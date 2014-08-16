/*function krSearchViaAjax(krSearchResult)
{
	var tagValue=krSearchForm.tags.value;
	$.ajax
	  (
	    {
	        type: "post",
	        url : "/cloudapp/view/Over2Cloud/KRLibraryOver2Cloud/searchKRViaAjax.action?tags="+tagValue,
	        success : function(krData) 
	        {
	    		$("#"+krSearchResult).html(krData);
	    	},
    		error: function()
    		{
    			alert("error");
    		}
	    }
	  );
}
*/
//$("#downLoadKRDialog").load("/cloudapp/view/Over2Cloud/KRLibraryOver2Cloud/searchKRViaAjax.action?tags="+tagValue.split(" ").join("%20"));                                             
  // $("#downLoadKRDialog").dialog('open');

//find the data according to selected module from client
function krSearchViaAjax(krSearchResult) 
{
	alert("function called<><><><><><><>>>>  ");
	var singleValues = $("#krSearchResult").val();
	var singleValues2 = $("#single").val();
	alert("the value of DIV IS>>>>   "+singleValues);
	
	var tagValue=krSearchForm.tags.value;
	$.ajax
	  (
	    {
	        type: "post",
	        url : "/cloudapp/view/Over2Cloud/KRLibraryOver2Cloud/searchKRViaAjax.action?tags="+tagValue.split(" ").join("%20"),
	        success : function(data) 
	        {	alert("inside the success   "+data);
	        	document.getElementById("indicator1").style.display="none";
	        	$("#"+krSearchResult).html(data);},
	        	error: function() {
	        		alert("error");
	        		}
	     }
	  );
}

function getDivForShow(theValueAre) {
		
	//var abc=$('input:checkbox:checked').val(); 
	
	var singleValues = $("#shareTo").val();
	alert($('s:checked').val());
	alert("called<><><>>>>>>");
	alert("the value of abs is><><><><><>>>>>     "+singleValues);
	
		document.getElementById("shareToDiv").style.display='block';
		document.getElementById("mail").style.display='none';
		
	}

function showMultiple()
{
	document.getElementById("sms").style.display='block';
	document.getElementById("mail").style.display='none';
}

function showSingle()
{
	document.getElementById("mail").style.display='block';
	document.getElementById("sms").style.display='none';
}


















