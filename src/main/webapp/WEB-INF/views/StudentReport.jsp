
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

<script>
	$(document).ready(function() {
		alert("ok")
		getAllRecord()
		$('#saveStudent').show();
		$('#updateStudent').hide();
		$('#idfield').hide();
		$("#saveStudent").click(function() {
			$.ajax({
				type : "POST",
				url: "insertStudent",
				data:{
					firstName : $("#firstname").val(),
					lastName : $("#lastname").val(),
					age : $("#age").val(),
					course : $("#course").val()
				},
				success : function(result) {
					alert("Them Thanh Cong")
					$("#studentForm")[0].reset()
					getAllRecord();
				},
				error: function (err) {
					alert("error is" + err)
				}
			})
			
		})
	});
	
	
	 var data ="";
	 function getAllRecord() {
		    $.ajax({
		        type: "GET",
		        url: "getAllStudent",
		        success: function(response) {
		            var data = response;

		            $(".tr").remove();

		            for (var i = 0; i < data.length; i++) {
		                $("#studentTable").append(
		                    '<tr class="tr"> <td>' + data[i].id + '</td>' +
		                    '<td>' + data[i].firstName + '</td>' +
		                    '<td>' + data[i].lastName + '</td>' +
		                    '<td>' + data[i].age + '</td>' +
		                    '<td>' + data[i].course + '</td>' +
		                    '<td><input type="button" class="btn btn-warning" onclick="editStudent(' + data[i].id + ')" value="Edit"></td>' +
		                    '<td><input type="button" class="btn btn-danger" onclick="deleteStudent(' + data[i].id + ')" value="Delete"></td></tr>'
		                );
		            }
		        },
		        error: function(err) {
		            alert("Error is " + err);
		        }
		    });
		}
	 
	 
	 function editStudent(id) {
		    $.ajax({
		        type: "GET",
		        url: "getOneStudent/?id=" + id,
		        dataType: "json",
		        success: function(response) {
		            // Populate form fields with the retrieved data
		            $("#id").val(response.id),
		            $("#firstname").val(response.firstName),
		            $("#lastname").val(response.lastName),
		            $("#age").val(response.age),
		            $("#course").val(response.course)

		            // Show/hide relevant buttons and fields
		            $('#saveStudent').hide();
		            $('#updateStudent').show();
		            $('#idfield').show();
		        },
		        error: function(err) {
		            alert("Error: " + err);
		        }
		    });
		}

	 
	 
	 function updateStudentbtn() {
		 $.ajax({
			 type : "POST",
			 url : "updateStudent",
			 data : {
				 id : $("#id").val(),
				 firstName : $("#firstname").val(),
				 lastName : $("#lastname").val(),
				 age : $("#age").val(),
				 course : $("#course").val()
			 },
			 success : function (result) {
				 getAllRecord();
				 $('#saveStudent').show();
					$('#updateStudent').hide();
					$('#idfield').hide();
					$('#studentForm')[0].reset()
				 
				
			},
			error : function (err) {
				alert()
			}
		 })
	}
	 
	 function deleteStudent(id) {
		 $.ajax({
			 type : "GET",
			 url: "deleteStudent/?id=" + id,
			 success : function (reponse) {
						getAllRecord();
					},
		 	error: function (err) {
		 		alert("error is" + err);
			}
		 })
		
	}

</script>

</head>
<body>
	<center>
		<h1>Student CRUD Using AJAX</h1>
	</center>

	<!--  <button id="gettime">Get Time</button>
	
	<h2 id="printtime"></h2>
  -->


	<div class="container mt-3">
		<form id="studentForm" name="studentform">
			<div class="row">
				<div class="col-6">
					<h3>Student Form</h3>


					<div class="row" id="idfield">
						<div class="col">
							<div class="form-group">
								<label for="id">ID</label> <input type="text"
									readonly="readonly" class="form-control" id="id" name="id">
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">First Name</label> <input type="text"
									class="form-control" id="firstname" name="firstname"
									placeholder="Enter First Name">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">Last Name</label> <input type="text"
									class="form-control" id="lastname" name="lastname"
									placeholder="Enter Last Name">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="age">Age</label> <input type="text"
									class="form-control" id="age" name="age"
									placeholder="Enter Age">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<div class="form-group">
								<label for="name">Course</label> <input type="text"
									class="form-control" id="course" name="course"
									placeholder="Enter Course">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<button type="button" id="saveStudent" class="btn btn-primary">Submit</button>
							<button type="button" id="updateStudent"
								onclick="updateStudentbtn()" class="btn btn-primary">Update</button>
						</div>
					</div>
				</div>
				<div class="col-6">

					<h3>Student Record</h3>

					<br>
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">First Name</th>
								<th scope="col">Last Name</th>
								<th scope="col">Age</th>
								<th scope="col">Course</th>
								<th scope="col">Edit</th>
								<th scope="col">Delete</th>
							</tr>
						</thead>
						<tbody id="studentTable">
							<%-- 
						<c:forEach var="std" items="${student}">
						<tr>
							<td class="table-plus">${std.id}</td>
							<td>${std.name}</td>
							<td>${std.age}</td>
							<td>${std.course}</td>
							<td><a href="editEmployee/${std.id}" class="btn btn-warning">
									Edit </a></td>
							<td><a href="deleteEmployee/${std.id}"
								class="btn btn-danger"> Delete </a></td>
						</tr>
					</c:forEach> --%>

						</tbody>
					</table>


				</div>


			</div>
		</form>
	</div>

</body>
</html>