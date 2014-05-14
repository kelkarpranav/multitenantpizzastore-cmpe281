<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pizza Hub</title>

    <!-- Bootstrap core CSS -->
    <link href='resources/styles/home-bootstrap.css' rel="stylesheet"/>

    <!-- Custom CSS for the 'Heroic Features' Template -->
    <link href='resources/styles/home-features.css' rel="stylesheet"/>
    
       <!-- JavaScript -->
     <script src='resources/js/jquery.js' type="text/javascript"></script>
     <script src='resources/js/bootstrap.js' type="text/javascript"></script>
    
  </head>

  <body>

    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <!-- <a class="navbar-brand" href="index.php">Start Bootstrap</a> -->
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
		    <!-- 
            <li><a href="#about">About</a></li>
          
			<li><a href="#services">Services</a></li>
            <li><a href="#contact">Contact</a></li>
			-->
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>
    
    <div class="container" >
      <div class="jumbotron hero-spacer text-center">
        <h1>Welcome to the Pizza Hub!</h1>
        <p >Please Pick the Pizza Store of your choice!</p> 
      </div>
      <hr>     
      <div class="row text-center col-sm-offset-1">
		<div class="col-lg-2 " >
          <div class="thumbnail" >
            <img src="resources/imgs/pmhlogo.jpg" alt="">
            <div class="caption">
              <p><a href="<c:url value="/pizzamyheart"/>" class="btn btn-primary" style="margin-top:25px">Enter Site!</a></p>
            </div>
          </div>
        </div>
		
        <div class="col-lg-2 hero-feature">
          <div class="thumbnail">
            <img src="resources/imgs/dominoslogo.jpg" alt="" style="margin-top:10px">
            <div class="caption">
              <p><a href="<c:url value="/dominos"/>" class="btn btn-primary" style="margin-top:30px" >Enter Site!</a></p>
            </div>
          </div>
        </div>

        <div class="col-lg-2 hero-feature">
          <div class="thumbnail" >
            <img src="resources/imgs/pizzahutlogo.jpg" alt="">
            <div class="caption">
            
              <p><a href="<c:url value="/pizzahut"/>" class="btn btn-primary">Enter Site!</a></p>
            </div>
          </div>
        </div>
        <div class="col-lg-2 hero-feature">
          <div class="thumbnail" >
            <img src="resources/imgs/papajohnslogo.jpg" alt="" style="margin-top:10px">
            <div class="caption">
              
              <p><a href="<c:url value="/papajohns"/>" class="btn btn-primary" style="margin-top:45px">Enter Site!</a></p>
            </div>
          </div>
        </div>
		 <div class="col-lg-2 hero-feature">
          <div class="thumbnail" >
            <img src="resources/imgs/roundtablelogo.jpg" alt="" >
            <div class="caption">
              <p><a href="<c:url value="/roundtable"/>" class="btn btn-primary" style="margin-top:35px">Enter Site!</a></p>
            </div>
          </div>
        </div>
      </div><!-- /.row -->
      
      <hr>

      <footer>
        <div class="row text-center">
          <div class="col-lg-12">
            <p>Copyright &copy; Company 2013</p>
          </div>
        </div>
      </footer>
      
    </div><!-- /.container -->

 

  </body>

</html>
