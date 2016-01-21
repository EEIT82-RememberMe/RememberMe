<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
    </head>
    <body>
        <div id="fb-root"></div>
        <script>
          //initializing API
          window.fbAsyncInit = function() {
            FB.init({appId: '1652372388346353', status: true, cookie: true,
                     xfbml: true});
          };
          
          (function(d, s, id) {
        	  
            var e = document.createElement('script'); e.async = true;
            e.src = document.location.protocol +
              '//connect.facebook.net/en_US/all.js';
            document.getElementById('fb-root').appendChild(e);
            
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/zh_TW/sdk.js";
//             fjs.parentNode.insertBefore(js, fjs); 
          }(document, 'script', 'facebook-jssdk'));
          
          
          function testAPI() {
        	    console.log('Welcome!  Fetching your information.... ');
        	    FB.api('/me', function(response) {
        	      console.log('Successful login for: ' + response.name);
        	     // document.getElementById('status').innerHTML =
        	       // 'Thanks for logging in, ' + response.name + response.id +  '!';
        	      //location.href  = "../member.controller/ProcessFacebookLogin?name=" + response.name + "&id=" + response.id
        	      
        	    });
        	  }
        </script>

        <!-- custom login button -->
        <a href="#" onclick="fblogin();return false;">login with facebook<!-- <img src="../images/cart.png"> --></a>


        <script>
          //your fb login function
          function fblogin() {
            FB.login(function(response) {
            	FB.getLoginStatus(function(response) {
            	      if (response.status === 'connected') {
            	    	  //alert(123);
            	    	  testAPI();
            	        // connected
            	    	  //console.log('Successful login for: ' + response.name);
            	      } else if (response.status === 'not_authorized') {
            	        // not_authorized
            	        login();
            	      } else {
            	        // not_logged_in
            	       login();
            	      }
            	    });
            	  
            		
            });
          }
        </script>
    </body>
</html>