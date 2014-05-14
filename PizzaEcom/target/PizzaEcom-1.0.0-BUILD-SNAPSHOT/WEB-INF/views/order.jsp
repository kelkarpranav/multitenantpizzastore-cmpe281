<html>
 <head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type" />
	<link href='resources/styles/styles.css' media="screen" rel="stylesheet" type="text/css" />
    <script src='resources/js/jquery.js' type="text/javascript"></script>
    <script src='resources/js/bootstrap.js' type="text/javascript"></script>
    <script src='resources/js/script.js' type="text/javascript"></script>
    <title>Domino's Order</title>
 </head>
 <body>
  <div class="masthead">
   <div id="hdrImg">
    <section class="left">
     <h1 class="muted">Domino's Pizza</h1>
    </section>         <section class="right">
        <img src="https://cache.dominos.com/nolo/us/en/013131/assets/build/images/img/img-logo-home.png"/> 
        </section>
        <section class="rightmost">
          <h3><a href="#">Sign in</a>, Do not have a pizza profile? <a href="#">Create One</a></h3> 
         </section>
        </div>
        <div class="navbar">
              <ul class="nav">
                <li class="active"><a href='/home'>Home</a></li>
                <li><a href='/order'>Order</a></li>
                <li><a href="menu.html">Menu</a></li>
                <li><a href="coupons.html">Coupons</a></li>
                <li><a href="location.html">Location</a></li>
                <li><a href="tracker.html">Tracker</a></li>
              </ul>
        </div>
   <div>
	<table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Item</th>
                  <th>Price</th>
                  <th>Buy</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Pizza Large</td>
                  <td>14$</td>
                  <td><a href='' onclick="buyCallback()">Buy</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Pizza Medium</td>
                  <td>10 $</td>
                  <td>buy</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Pizza personal</td>
                  <td>8.5 $</td>
                  <td>buy</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>Pasta</td>
                  <td>8 $</td>
                  <td>buy</td>
                </tr>
                <tr>
                  <td>5</td>
                  <td>Salad</td>
                  <td>6.5 $</td>
                  <td>buy</td>
                </tr>
                <tr>
                  <td>6</td>
                  <td>Coke</td>
                  <td>6 $</td>
                  <td>buy</td>
                </tr>
                 <tr>
                  <td>7</td>
                  <td>bread</td>
                  <td>4 $</td>
                  <td>buy</td>
                </tr>
                  <tr>
                  <td>8</td>
                  <td>deserts</td>
                  <td>4.5 $</td>
                  <td>buy</td>
                </tr>
              </tbody>
         </table>
   </div>
  </div>
        <div>
        <section class="left">
            <p></p>
         </section>
         <section class="right" style="padding-top:30px;">
            <img src="http://cache.dominos.com/nolo/us/en/013131/assets/build/images/promo/DPZ_N4_GM_HP_mcr.jpg"/>
         </section>
      </div>
     <script type="text/javascript">
      var item = 'pizzalarge';
      
      function buyCallback(){
    	  alert("Your Order Has been Placed, Thanks you!!");
          var dataUrl = "/buy";
          jQuery.ajax({
      		type : "GET",
      		url : dataUrl,
      		data: item,
      		success : function(data) {
      			if (data) {
      				alert("Your Order Has been Placed, Thanks you!!");
      			}
      		},
      		error : function() {
      			alert("Your Order Has been Placed.");
      		}
      	});
  
      }
      
    </script>
 </body>
</html>
