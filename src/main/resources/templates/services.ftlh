<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<style>
    main {
        margin-top: 30px;
    }

    .service-card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        transition: 0.3s;
        border-radius: 5px;
        margin: 10px;
    }

    .service-card:hover {
        box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
    }
</style>


<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
                <ul class="navbar-nav">
                    <a class="navbar-brand" href="#">
                        E-wallet
                    </a>
                </ul>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/"><@spring.message 'navbar.navi.home'/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/service"><@spring.message 'service'/></a>
                    </li>
                </ul>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">
                            <i class="fas fa-user"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="?lang=en">English</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="?lang=ru">Русский</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout"><@spring.message 'logout'/></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container mt-5">
        <h1>List of Services</h1>
        <div class="row">
            <#list services as service>
                <div class="col-md-4">
                    <div class="card service-card">
                        <div class="card-body">
                            <h5 class="card-title">${service.service}</h5>
                            <p class="card-text">Description of Mbank service.</p>
                            <a href="/service/${service.id}" class="btn btn-primary">Perform</a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>

</main>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
