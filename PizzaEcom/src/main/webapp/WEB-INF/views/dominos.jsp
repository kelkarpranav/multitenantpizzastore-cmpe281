<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@page import="org.json.simple.*"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dominos</title>

    <!-- Bootstrap core CSS -->
    <link href='resources/styles/bootstrap.min.css' rel="stylesheet"/>

    <!-- Custom CSS for the 'Heroic Features' Template -->
    <link href='resources/styles/home-features.css' rel="stylesheet"/>
	
    <!-- JavaScript -->
   <script src='resources/js/jquery.js' type="text/javascript"></script>
    <script src='resources/js/bootstrap.js' type="text/javascript"></script>
	 
	<script >
					
	var drinks = ${drinks};
	var sides = ${sides};
	var pizzas = ${pizzas};
	
	var pizzalen = pizzas.length;
	var sideslen = sides.length;
	var drinkslen = drinks.length;
	
	$(document).ready(function(){
	 for ( var i in pizzas ) {
		var name = pizzas[i].Name;
		var price = pizzas[i].Price__c;
			$("#pizzalist").append('<label class="checkbox" id="pizzaitem'+i+'"><input type="checkbox" id="pitem'+i+'">'+name+': <span class="pull-right">$'+price+'.00</span></label>');
	}
	for ( var i in drinks ) {
		var name = drinks[i].Name;
		var price = drinks[i].Price__c;
			$("#drinkslist").append('<label class="checkbox" id="drinkitem'+i+'"><input type="checkbox" id="ditem'+i+'">'+name+': <span class="pull-right">$'+price+'.00</span></label>');
	}
	for ( var i in sides ) {
		var name = sides[i].Name;
		var price = sides[i].Price__c;
			$("#sideslist").append('<label class="checkbox" id="sideitem'+i+'"><input type="checkbox" id="sitem'+i+'">'+name+': <span class="pull-right">$'+price+'.00</span></label>');
	}
	});
	
	function submitOrder(){
		var order = {};
		
		var pizzas = [];
		var drinks = [];
		var sides = [];
		var total = 0;
		//Set Store ID
		order["storeID"]= "dominos";
		
		var pizzaitemsordered = [];
		for (var i=0;i<window.pizzalen;i++)
		{ 
			
			if( document.getElementById("pitem"+i).checked===true){
			 var pizzaitem = $("#pizzaitem"+i).text();
				
			 	
				var pizza_total = pizzaitem.split(":",2);
				var name = pizza_total[0];
				var price = pizza_total[1];
				pizzaitemsordered.push({"Name" : name, "Price" : price});
			 }
			
		}
		var sideitemsordered = [];
		for (var i=0;i<window.sideslen;i++)
		{ 
			
			if( document.getElementById("sitem"+i).checked===true){
			 var sideitem = $("#sideitem"+i).text();
			
				var side_total = sideitem.split(":",2);
				var name = side_total[0];
				var price = side_total[1];
				sideitemsordered.push({"Name" : name, "Price" : price});
			 }
			
		}
		var drinkitemsordered = [];
		for (var i=0;i<window.drinkslen;i++)
		{ 
			
			if( document.getElementById("ditem"+i).checked===true){
			 	var drinkitem = $("#drinkitem"+i).text();
				var drink_total = drinkitem.split(":",2);
				var name = drink_total[0];
				var price = drink_total[1];
				drinkitemsordered.push({"Name" : name, "Price" : price});
			 }
			
		}
		order["drinks"]=drinkitemsordered;
		order["pizzas"]=pizzaitemsordered;
		order["sides"]=sideitemsordered;
		
		//alert(JSON.stringify(order));
		var orderstring = JSON.stringify(order);
		
         $.ajax({

             url:"/submitorder",
             type:"POST", 
             contentType: "application/json; charset=utf-8",
             dataType: "text",
             data: orderstring, //Stringified Json Object
             cache: false,    //This will force requested pages not to be cached by the browser  
             processData:false, //To avoid making query String instead of JSON
             success: function(data){
            	 document.getElementById("content").innerHTML = "<h2> Order Successful! Your new Order id is: "+data+"</h2>";
            	 $("#content").append('<h3>Pizzas Ordered: </h3>');
            	 for ( var i in pizzaitemsordered ) {
           			var name = pizzaitemsordered[i].Name;
           			var price = pizzaitemsordered[i].Price;
           			var tempprice = price.replace("$", "");
           			total += parseFloat(tempprice);
            	 	$("#content").append('<P>'+name+':'+price+'</p>');
            	 }
            	 $("#content").append('<h3>Sides Ordered: </h3>');
            	 for ( var i in sideitemsordered ) {
           			var name = sideitemsordered[i].Name;
           			var price = sideitemsordered[i].Price;
           			var tempprice = price.replace("$", "");
           			total += parseFloat(tempprice);
            	 	$("#content").append('<P>'+name+':'+price+'</p>');
            	 }
            	 $("#content").append('<h3>Drinks Ordered: </h3>');
            	 for ( var i in drinkitemsordered ) {
           			var name = drinkitemsordered[i].Name;
           			var price = drinkitemsordered[i].Price;
           			var tempprice = price.replace("$", "");
           			total += parseFloat(tempprice);
            	 	$("#content").append('<P>'+name+':'+price+'</p>');
            	 }
            	 $("#content").append('<h2>Total: $'+total+'</h2>');
     		 }
         });
     	
    	 
    }
	
	</script>
  </head>

  <body>

	<div class="row offset2 span8">
		<div class="text-center">
			<img src="resources/imgs/dominosimgs/homelogo.png" alt="" style="float:left">
			<h1 style="padding-top:30px">Welcome to Domino's!</h1>
		</div>
	</div>
   <div class="row offset2 span8" >
		 <div class="navbar">
              <div class="navbar-inner">
                <div class="container">
                  <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </a>
                    <ul class="nav pull-right">
                      <li><a href="<c:url value="/dominos"/>">Home</a></li>
                      <li><a href="#">About</a></li>
                      <li><a href="#">Contact Us</a></li>
                      <li><a href="<c:url value="/home"/>">Hub Home</a></li>
                    </ul>
                
                </div>
              </div><!-- /navbar-inner -->
            </div>
       <div id ="content">
		  <div class="alert alert-info text-center">Pizzas</div>
		  <ul id="pizzalist"></ul>
		   <div class="alert alert-info text-center">Drinks</div>
		  <ul id="drinkslist"></ul>
		  <div class="alert alert-info text-center">Sides</div>
		  <ul id="sideslist"></ul>
		  <button class="btn btn-primary offset3" type="button" onclick="submitOrder()">Submit Order</button>
	  </div>
	  <hr>	
      <footer>
        <div class="row text-center">
          <div class="col-lg-12">
            <p>Copyright &copy; 2013 Dominos IP Holder LLC. Dominos®, Domino's Pizza®</p>
          </div>
        </div>
      </footer>
      
    </div><!-- /.row -->


  </body>

</html>