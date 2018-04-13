
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Bed & Brunch</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
    
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

    
    <link rel = "stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script type="text/javascript" src = "<c:url value="http://code.jquery.com/jquery-1.9.1.js"/>"></script>
    <script type="text/javascript" src = "<c:url value="http://code.jquery.com/ui/1.10.2/jquery-ui.js"/>"></script>
    <style>
        .datepicker{
        }
    </style>
    <script>
        $(function(){
            $(".datepicker ").datepicker();
        });
    </script>
    <script>
        function myFunction() {
            document.getElementById("rForm").reset();
        }
    </script>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="<c:url value="/" />">Sleeping Inn Bed & Brunch</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/home" />">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/roomList" />">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/brunch" />">Brunch</a>
                </li>
            </ul>
            <div class="form-inline mt-2 mt-md-0">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login" />"><input type="hidden" name="action" value="create"/>Login</a>
                    </li>
                    <li class="nav-item">
                    
                        <a class="nav-link" href="<c:url value="/cart" />"><input type="hidden" name="action" value="create"/>Cart</a>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
</header>