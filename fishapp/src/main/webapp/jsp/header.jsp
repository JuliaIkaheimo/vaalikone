<!DOCTYPE html>
<html lang="fin">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link href="https://fonts.googleapis.com/css?family=Oswald&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>Vaalikone</title>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
  <a class="navbar-brand" href="index.html">Vaalikone-admin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
    <div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/readehdokkaattoadmin">Admin paneeli</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/showkysymykset">Vaalikone</a>
      </li>
    </ul>
			<span class="navbar-text">
            <p class="navbar-text">
			<% 
			if(session!=null)
	    	{ 
	    		String username=(String)session.getAttribute("username");
	    		out.print("Kirjautuneena: " + username);
				%>
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit"><a class="nav-link" href="/logout">
	    		Kirjaudu ulos
	    		</a></button>
	    		<%
	    	}
	    	else
	    	{
	    		
				response.sendRedirect("/login");
	    	} %>
		</span>
  </div>
</nav>
<header class="masthead">
  <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="col-12">
        <h1 class="font-weight-light">Ehdokkaat</h1>
        <p class="lead">Hallintapaneeli</p>
      </div>
    </div>
  </div>
</header>