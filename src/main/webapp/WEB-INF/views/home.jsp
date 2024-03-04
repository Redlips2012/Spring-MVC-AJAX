<html>
   <head>
      <title>Hello Spring MVC</title>
   </head>
   
   <body>
      <h2>${message}</h2>
      
      <div class="container mt-3">

      
      <a href="${pageContext.request.contextPath}/employeeReport" class="btn btn-primary">  Employee </a>
      <a href="${pageContext.request.contextPath}/studentReport" class="btn btn-primary">  Student </a>
      
      </div>
   </body>
</html>