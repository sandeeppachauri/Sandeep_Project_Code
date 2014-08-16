function getEmpNameMobViaAjax(destAjaxDiv,subdeptId) {
	
	
	var subdept=$("input[name='"+subdeptId+"']:checked").val();
	
		 alert(subdeptId+"sub");
		
		 $
					.ajax( {
						type :"post",
						url :"/erp/view/admin_pages/common_admin/FBTypeAjax.action?destination="
								+ destAjaxDiv+"&subDept="+subdept+"&destinationResult=radio",
						success : function(feedTypeData) {
							$("#" + destAjaxDiv).html(feedTypeData);

						},
						error : function() {
							alert("error");
						}
					});
		}
		