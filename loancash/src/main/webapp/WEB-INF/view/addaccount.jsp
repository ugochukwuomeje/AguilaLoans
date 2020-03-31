<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Aquila Loan</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    
     <!-- my own css -->
    <link rel="stylesheet" href="css/customforms.css">
    
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- Google fonts - Popppins for copy-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
    <!-- orion icons-->
    <style>
        	.alert_message{
        	 line-spaceing: 0.3em;
        	
		    font-weight: 700;
		    color: rgb(59, 69, 80);
		   
		    letter-spacing: 0px;
		    text-rendering: optimizelegibility;
        	 
        	}
     </style>
     
      
     
    <link rel="stylesheet" href="css/orionicons.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.png?3">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
        
        
  </head>
  
  <!-- this is the header of the page -->
  <header class="header">
      <nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow"><a href="#" class="sidebar-toggler text-gray-500 mr-4 mr-lg-5 lead"><i class="fas fa-align-left"></i></a><a href="index.html" class="navbar-brand font-weight-bold text-uppercase text-base">AGUILA LOANS</a>
        <ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
          <li class="nav-item">
            <form id="searchForm" class="ml-auto d-none d-lg-block">
              <div class="form-group position-relative mb-0">
                <button type="submit" style="top: -3px; left: 0;" class="position-absolute bg-white border-0 p-0"><i class="o-search-magnify-1 text-gray text-lg"></i></button>
                <input type="search" placeholder="Search ..." class="form-control form-control-sm border-0 no-shadow pl-4">
              </div>
            </form>
          </li>
          <li class="nav-item dropdown mr-3"><a id="notifications" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle text-gray-400 px-1"><i class="fa fa-bell"></i><span class="notification-icon"></span></a>
            <div aria-labelledby="notifications" class="dropdown-menu"><a href="#" class="dropdown-item">
                <div class="d-flex align-items-center">
                  <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                  <div class="text ml-2">
                    <p class="mb-0">You have 2 followers</p>
                  </div>
                </div></a><a href="#" class="dropdown-item"> 
                <div class="d-flex align-items-center">
                  <div class="icon icon-sm bg-green text-white"><i class="fas fa-envelope"></i></div>
                  <div class="text ml-2">
                    <p class="mb-0">You have 6 new messages</p>
                  </div>
                </div></a><a href="#" class="dropdown-item">
                <div class="d-flex align-items-center">
                  <div class="icon icon-sm bg-blue text-white"><i class="fas fa-upload"></i></div>
                  <div class="text ml-2">
                    <p class="mb-0">Server rebooted</p>
                  </div>
                </div></a><a href="#" class="dropdown-item">
                <div class="d-flex align-items-center">
                  <div class="icon icon-sm bg-violet text-white"><i class="fab fa-twitter"></i></div>
                  <div class="text ml-2">
                    <p class="mb-0">You have 2 followers</p>
                  </div>
                </div></a>
              <div class="dropdown-divider"></div><a href="#" class="dropdown-item text-center"><small class="font-weight-bold headings-font-family text-uppercase">View all notifications</small></a>
            </div>
          </li>
          <li class="nav-item dropdown ml-auto"><a id="userInfo" href="http://example.com" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle"><img src="img/avatar-6.jpg" alt="Jason Doe" style="max-width: 2.5rem;" class="img-fluid rounded-circle shadow"></a>
            <div aria-labelledby="userInfo" class="dropdown-menu"><a href="#" class="dropdown-item"><strong class="d-block text-uppercase headings-font-family">Mark Stephen</strong><small>Web Developer</small></a>
              <div class="dropdown-divider"></div><a href="#" class="dropdown-item">Settings</a><a href="#" class="dropdown-item">Activity log       </a>
              <div class="dropdown-divider"></div><a href="login.html" class="dropdown-item">Logout</a>
            </div>
          </li>
        </ul>
      </nav>
    </header>
  <!-- this the closing part of the header -->
  
  
  <!-- this is the section for the form -->
  
  <div class="container-fluid px-xl-5">
          <section class="py-5">
            <div class="row">
              <!-- Basic Form-->
              <div class="welcome-form col-lg-6 mb-5">
                <div class="card">
                  <div class="card-header">
                    <h3 class="h6 text-uppercase mb-0">Enter Your Account Details</h3>
                  </div>
                  <div class="card-body">
                    <p class="alert_message">
                    	<c:choose>
			     		<c:when test="${errorstatus == true}">
				     		
				     			<div class=" alert alert-danger alert-dismissable">	
				     				<button type="buttton" class="close" data-dismiss="alert">&times;</button>
				     				${errormessage}
				     			</div>
				     			
			     		</c:when>
			     	
			     	</c:choose>
                   </p>
                    <sf:form class="form" method="POST" action="/getaccoutdetails" modelAttribute="mybankacc" >
                      <div class="form-group" style="margin-bottom:0.6em;" >
                      	<label style="font-size:1em;"><strong>Select bank</strong></label><br>
                            <sf:select class="form-control bankcode" id="bankcode" path="bank" 
												items="${banks}"
												itemLabel="bankname"
												itemValue="bankcode"
										/>
                           
                      </div>
                      
                      <div class="form-group" style="margin-bottom:0.6em;" >
                      	<label style="font-size:1em;"><strong>Account Number</strong></label><br>
                        <sf:input path="accno" name="accno" class="form-control accno"/> 
                        <sf:errors path="accno" name="accno" element="em"/>   
                      </div>
                      
                      <div class="form-group" style="margin-bottom:0.6em;" >
                      	<label style="font-size:1em;"><strong>Account Name</strong></label><br>
                      	
                      	<div class="row">
                      		<div class="col-sm-4 col-md-6" style="margin-bottom:1em;">
                      			<sf:input type="text" path="accname" name="accname" class="form-control accname" readonly="true"/>
                      			<sf:errors path="accname" name="accno" element="em"/>  
                      		</div>
                      		<div class="col-sm-4 col-md-6">
                      			<button type="button" class="btn btn-warning verifyacc">Verify Account Number</button>
                      			<img src="images/inprogress.gif" style="width:50px; height:50px;" class="verfiyloading" >
                      		</div>
                      	</div>
                          
                      </div><br><br>
                      
                      <div class="form-group">       
                        <button type="submit" class="btn btn-primary">Proceed</button>
                      </div><br>
                       
                       <p style="color:red">
                       	
                       </p>
                    </sf:form>
                  </div>
                </div>
              </div>
              <!-- Horizontal Form-->
             
            </div>
          </section>
        </div>
  <!-- this is the sectiom for the form -->
  
  <!-- this is the javascript link to the page-->
  <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
    <script src="js/charts-home.js"></script>
    <script src="js/front.js"></script>
  <!-- this is the closing part of the link to javascript  -->
  <script>
     	$(".verfiyloading").hide();
     	$(".verifyacc").click(function()
     	{
     		$(".verfiyloading").show();
     		var bankcode = $(".bankcode").val();
     		var accountnumber = $(".accno").val();
     		
     			if(bankcode == "" || bankcode == null)
     			{
     				alert("Please enter the bankcode");
     				$(".verfiyloading").hide();
     				return;
     			}
     			
     			if(accountnumber == ""  || accountnumber == null)
     			{
     				alert("Please enter the Account Number" + accountnumber);
     				$(".verfiyloading").hide();
     				return;
     			}
     		
     		
     		//var datastring = "accountnumber="+accountnumber+"&bankcode="+bankcode;
     		
     		$.ajax({
     		
     			type:"GET",
     			url: "http://localhost:8080/resolvePhoneNumber/"+accountnumber+"/"+bankcode,
     			data: null,
     			cache: false,
     			success: function(data){
     				$(".verfiyloading").hide();
     				if(data == null || data == "" || data == "error"){
     					alert("Please check your account number");
     				}else{
     					
     					$(".accname").val(data);
     				}
     			}
     		});
     	});
    
     	
     </script>
<body>

</body>
</html>