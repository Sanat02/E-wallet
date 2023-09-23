<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home Page</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
</head>

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
                        <a class="nav-link" href="#section_1"><@spring.message 'navbar.navi.home'/></a>
                    </li>
                </ul>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="profile.html">
                            <i class="fas fa-user"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <@spring.message 'navbar.navi.lang'/>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="languageDropdown">
                            <a class="dropdown-item" href="?lang=en">English</a>
                            <a class="dropdown-item" href="?lang=ru">Русский</a>
                        </div>
                    </li>
                    <#if username??>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout"><@spring.message 'logout'/></a>
                        </li>
                    <#else>
                        <li class="nav-item">
                            <a class="nav-link" href="/login?lang="><@spring.message 'navbar.user.signin'/></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register"><@spring.message 'navbar.user.signup'/></a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main>
    <section class="hero-section d-flex justify-content-center align-items-center" id="section_1">
        <div class="container text-center">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <h1 class="display-4"><@spring.message 'welcome'/></h1>
                    <form method="get" class="mt-4">
                        <div class="input-group">
                            <input name="keyword" type="search" class="form-control"
                                   placeholder="<@spring.message 'search'/>..." aria-label="Search">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-primary"><@spring.message 'search'/></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</main>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script>
    function addLanguageParam(lang) {
        const loginLink = document.querySelector('.nav-link');
        loginLink.href = '/login?lang=' + lang;
    }
</script>
</html>
