<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<style>
	.modal-header, .modal-footer {
		background: deepskyblue;
		color: #fff;
		font-weight: 1000;
	}
	
	.input-container {
		display: flex;
		justify-content: space-start;
	}
	
	.input-container .phonenumber {
		
		width: 100%px;
		border-radius: 0px;
		display: inline-block;
		margin:0px;
		
	}
	
	.input-container .submitbtn {
	
		display: inline-block;
		border-radius: 0px;
		margin:0px;
		
	}
	
</style>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Smart Class</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="css/style.css" type="text/css"  />
    <link rel="stylesheet" href="css/customforms.css" type="text/css"  />
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <!-- jQuery library -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!--this should come after the jquery library-->
    <script src="js/caroufredsel.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body> 
    <header class="secondary">
        <div class="container">
            <div class="row">
                <a href="" class="logo" style="font-family: serif; font-size:3em; color:white"><img src="images/logo" >Aguila Loans</a>
                <nav>
                    <ul>
                        
                         
                            <li><a href="#" data-toggle="modal" data-target="#numberModal">Get Loan</a></li>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </div>    
    </header>
    <section class="slider">
        <ul class="slider-carousel" id="slider-carousel">
            <li class="img1">
                <h2>GET LOAN IN JUST FEW CLICKS WITH   <span>AGUILA LOANS</span></h2>
                <!--<p>We believe in Creativity always</p>-->
                <i class="fa fa-apple"></i>
                <i class="fa fa-android"></i>
                <!--  <i class="fa fa-windows"></i>-->
                <!--<p><br>
                      Now you can meet today’s needs with a little extra for tomorrow
               </p>-->  <br><br>
                <a href="#" data-toggle="modal" data-target="#numberModal" class="btn btn-half">Get Loan</a>
                <a href="#" class="btn btn-full">About AGuila Loans</a>
            </li>

        </ul>
    </section>
    <!-- this section will be displayed if there is error -->
     
     	<c:choose>
     		<c:when test="${messagestatus == 'failed'}">
	     		
	     			<div class="display-alert alert alert-danger alert-dismissable">	
	     				<button type="buttton" class="close" data-dismiss="alert">&times;</button>
	     				${message}
	     			</div>
	     			
     		</c:when>
     	
     	</c:choose>
     
    <!--this is the closing section-->
    
    <section class="intro-area white" id="intro">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h2>Benefits of Aguila Loan</h2>
                    <div class="sub-heading">
                        <p>
                            With Aguila Loans Uniques Benefits
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                    <div class="col-sm-4">
                        <div class="intro-block">
                            <span class="intro-icon"><i class="fa fa-paint-brush"></i></span>
                            <h3>Get a loan from your phone, anytime within minutes</h3>
                            <p>
                                We make access to credit easy. No guarantors, no collateral, no wahala with Carbon.
                                 You can apply 24/7 and receive funds in your account in as little as 5 minutes.
                            </p>
                        </div>
                    </div>
                    <div class="col-sm-4">
                            <div class="intro-block">
                                <span class="intro-icon"><i class="fa fa-angellist"></i></span>
                                <h3>Good Interest Rate</h3>
                                <p>
                                    To get the best out of your loan journey, ensure that you take and pay back your 
                                    loans before the tenure expires. The earlier you repay, the higher your loan offers grow!.
                                </p>
                    </div>
                    </div>
                    <div class="col-sm-4">
                                <div class="intro-block">
                                    <span class="intro-icon"><i class="fa fa-angellist"></i></span>
                                    <h3>Loans given every minute, everywhere!</h3>
                                    <p>
                                        No matter where you are in the country, we have a loan offer specifically for you.
                                         Obtaining a loan from us is seamless and can be done in less time than it takes 
                                         to finish reading this. Don't believe us, try it out yourself!
                                    </p>
                                </div>
                    </div>
            </div>
        </div>
     
    </section>

    <section class="feature-area" id="feature">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <div class="title">
                            <h2>WHAT MAKES US STAND OUT</h2>
                            <!--<div class="sub-heading">
                                <p>
                                    At W3Schools you will find complete references about tags,
                                    attributes, events, <br>color names, entities, character-sets, URL encoding, language codes, HTTP messages, and more.
                                </p>
                            </div>-->
                    </div>
                </div>
            </div>

            <div class="row ">
                <div class="col-sm-12 col-lg-8 text-center">
                    <div class="feature-block">
                        <div class="row standout"> 

                            <div class="single-feature feature-circle col-md-6">
                                <div class="circle">
                                    <span class="featured-icon">
                                        <i class="fa fa-exchange"></i>
                                    </span>
                                    <h3>Low Interest Rate</h3>
                                    <p>
                                            With Aquila loan comes a very low intrest which also decrese the more you use our platform and payback withing the specified period
                                    </p>
                                </div>
                            </div>
                            <div class="single-feature feature-circle col-md-6">
                                    <div class="circle">
                                        <span class="featured-icon">
                                            <i class="fa fa-arrows-alt"></i>
                                        </span>
                                        <h3>EASY TO USE</h3>
                                        <p>
                                                With our Just sign up and You can access our Loan
                                        </p>
                                    </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="single-feature feature-circle col-md-6">
                                <div class="circle">
                                    <span class="featured-icon">
                                        <i class="fa fa-cog"></i>
                                    </span>
                                    <h3>Rewards</h3>
                                    <p>
                                        There are many rewards for responsible borrowing such as increased loan offers, lower interest rates and longer loan tenures.
                                    </p>
                                </div>
                            </div>
                            <div class="single-feature feature-circle col-md-6">
                                    <div class="circle">
                                        <span class="featured-icon">
                                            <i class="fa fa-star-half-o"></i>
                                        </span>
                                        <h3>No Delay</h3>
                                        <p>
                                                When you access our loans your account will be credited instantly.
                                        </p>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-lg-4">
                    <div class="feature-mockup">
                        <img src="images/tab2.png" alt="" class="img-responsive">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="more-feature-area" id=more-feature>
       <div class="container">
            <div class="row">
                    <div class="col-sm-12 text-center">
                            <div class="title">
                                    <h2>How it Works</h2>
                                    <div class="sub-heading">
                                       <!-- <p>
                                            At W3Schools you will find complete references about tags,
                                            attributes, events, <br>color names, entities, character-sets, URL encoding, language codes, HTTP messages, and more.
                                        </p>-->
                                    </div>
                            </div>
                    </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-md-7 col-lg-7">
                    <img src="images/tab.jpg" alt="" class="img-responsive">
                </div>
                <div class="col-sm-12 col-md-5">
                    <div class="feature-list">
                        <ul>
                            <li>
                                <div class="feature-icon">
                                    <i class="fa fa-arrows-alt"></i>
                                </div>
                                <div class="feature-details">
                                    <h3>Loging With just your phone NUmber</h3>
                                    <p>
                                            Login with the phone number and you will receive one time password. Please login with number you receive alert from bank. No need to sign up. 
                                    </p>
                                </div>
                            </li>
                            <li>
                                    <div class="feature-icon">
                                        <i class="fa fa-cog"></i>
                                    </div>
                                    <div class="feature-details">
                                        <h3>Check for Loan</h3>
                                        <p>
                                                Click on check loan offer.
                                        </p>
                                    </div>
                            </li>
                            <li>
                                    <div class="feature-icon">
                                        <i class="fa fa-mobile"></i>
                                    </div>
                                    <div class="feature-details">
                                        <h3>Select Amount</h3>
                                        <p>
                                                At this point choose the amount you want from the list displayed
                                        </p>
                                    </div>
                            </li>
                            <li>
                                    <div class="feature-icon">
                                        <i class="fa fa-undo"></i>
                                    </div>
                                    <div class="feature-details">
                                        <h3>Select Bank Account</h3>
                                        <p>
                                               Choose the account you want to credit and you will receive the loan
                                        </p>
                                    </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
       </div> 
    </section>
    <section class="testimonials" id="testimonial">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h2>WHAT PEOPLE SAY ABOUT US</h2>
                    <div class="sub-heading">
                        <p>
                               At Quia loans we have your comfort in mind
                       
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                        <div id="carousel-testimonials" class="carousel slide" data-ride="carousel">
                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                  <li data-target="#carousel-testimonials" data-slide-to="0" class="active"></li>
                                  <li data-target="#carousel-testimonials" data-slide-to="1"></li>
                                  <li data-target="#carousel-testimonials" data-slide-to="2"></li>
                                </ol>
                              
                                <!-- Wrapper for slides -->
                                <div class="carousel-inner">
                                  <div class="item active text-center">
                                        <img src="images/admin_profile_pic.png" class="center-block" alt="Los Angeles">
                                        <h2>Ugochukwu</h2>
                                        <!--<h4>Sr Engineer</h4>-->
                                        <p>
                                                Aquila Loan Helped me to acces loan instantly from my phone with their application. I was so excited that
                                                there was no delay from the time I applied for the loan to the time I accessed it. 

                                        
                                        </p>
                                  </div>
                              
                                  <div class="item  text-center">
                                        <img src="images/admin_profile_pic.png" class="center-block" alt="Los Angeles">
                                        <h2>Daniel</h2>
                                        <!--<h4>Sr Engineer</h4>-->
                                        <p>
                                                I was so supprised on the intrest I had to pay back and also that withn the seven days of borrowing that I paid back i was charged 0% interest
                                        
                                        </p>
                                  </div>
                              
                                  <div class="item  text-center">
                                        <img src="images/admin_profile_pic.png" class="center-block" alt="Los Angeles">
                                        <h2>Daniel Grover</h2>
                                        <h4>Sr Engineer</h4>
                                        <p>
                                                At W3Schools you will find complete references about tags,
                                                attributes, events, <br>color names, entities, character-sets, URL encoding, language codes, HTTP messages, and more.
                                        
                                        </p>
                                  </div>
                                </div>

                        </div>
                </div>
            </div>
        </div>
    </section>
    <div id="numberModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">Enter your Phone Number</div>
                    <div class="modal-body">
                        <sf:form action="/checkcaptcher" class="form form-inline" modelAttribute="phonenumbers" method="GET">
                            <div class="form-group input-container" style="padding:0; width:100%">
                                <sf:input type="text" name=""  class="form-control phonenumber"  path="phonenumber" style="border-radius:0px; width:70%; margin:0"/>
                                <button type="submit"  class="btn btn-primary submitbtn" style="margin:0">Request loan</button><br>
                            </div><br>
                       <sf:errors path="phonenumber" id="error" cssClass="" element="em"></sf:errors>                            
                        </sf:form>
                    </div>
                    <div class="modal-footer"></div>
                </div>
        </div>        
    </div>
    <section class="team-area" id="team">
        <div class="container">
            
            <div class="row text-center">
                <div class="col-sm-6 col-md-4">
                   
                    <div class="team-description">
                        <p>
                            <img src="images/logo.PNG" alt="">
                        </p>

                        <article class="contact">
                           <span><strong>Email address:</strong></span> customer@aguilaloans.com
                           <span><strong>Phone number:</strong></span>  01-460 9945, 
                                         01-631 1215
                        </article>
                        
                    </div>
                </div>
                    <div class="col-sm-6 col-md-4">
                        
                        <div class="team-description">
                            <h3>Company</h3>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Contact</a></li>
                                <li><a href="#">FAQ</a></li>
                            </ul>
                            
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                            
                            <div class="team-description">
                                <div class="team-title`">
                                     <h3>Follow Us</h3>
                                     
                                </div>
                                
                                <div class="team-social-network">
                                    <a href=""><i class="fa fa-facebook"></i>&nbsp;&nbsp; FaceBook</a>
                                    <a href=""><i class="fa fa-twitter" style="margin-left: -17px"></i>&nbsp;&nbsp;Twitter </a>
                                    <a href=""><i class="fa fa-linkedin"></i>&nbsp;&nbsp;Linkedin</a>
                                    <a href=""><i class="fa fa-youtube-play"></i>&nbsp;&nbsp;Youtube</a>
                                </div>
                            </div>
                    </div>
                        
            </div>
        </div>    
    </section>
    <section class="copyright">
        <div>All rights reserved © 2019 <strong>Aquila Loans</strong> </div>
    </section>

    <script src="js/main.js"></script>
</body>
</html>