$(document).ready(function() {
		alert("ok")
		$("#saveStudent").click(function() {
			$.ajax({
				type : "POST",
				url: "insertStudent",
				data:{
					name : $("#name").val(),
					age : $("#age").val(),
					course : $("#course").val()
				},
				success : function(result) {
					$("#studentForm")[0].reset()
					/* getAllRecord(); */
				},
				error: function (err) {
					alert("error is" + err)
				}
			})
			
		})
	});