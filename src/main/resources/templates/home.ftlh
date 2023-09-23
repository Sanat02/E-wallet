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
</head>
<style>
    #warning {
        color: red;
        font-size: 16px;
    }

    #success {
        color: green;
        font-size: 16px;
    }

    #your {
        color: orange;
        font-size: 16px;
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
                        <a class="nav-link" href="#"><@spring.message 'navbar.navi.home'/></a>
                    </li>
                    <#if username??>
                        <li class="nav-item">
                            <a class="nav-link" href="/service"><@spring.message 'service'/></a>
                        </li>
                    </#if>
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
                    <#if username??>
                        <h1 class="display-4"><@spring.message 'welcome'/> ${username.balance} <@spring.message 'som'/></h1>
                    </#if>
                    <#if username?? >
                        <div class="container">
                            <div id="warning"></div>
                            <div id="success"></div>
                            <div id="your"></div>
                            <form action="/" method="post">
                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                           value="${(_csrf.token)!'csrf-token'}"/>
                                </#if>
                                <div class="form-group">
                                    <label for="receiver"><@spring.message 'account.name'/> </label>
                                    <input type="text" class="form-control" id="receiver" name="receiver"
                                           placeholder="<@spring.message 'enter.account.name'/> "
                                           required>
                                </div>
                                <div class="form-group">
                                    <label for="amount"><@spring.message 'amount'/> :</label>
                                    <input type="number" class="form-control" id="amount" name="amount"
                                           placeholder="<@spring.message 'amount'/>" required
                                           min="0">
                                </div>
                                <button type="submit" class="btn btn-primary"><@spring.message 'send'/></button>
                            </form>
                        </div>
                    </#if>
                </div>
            </div>
        </div>
    </section>


</main>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function getQueryParam(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    const accountValue = getQueryParam("account");

    if (accountValue === "user") {
        const warningDiv = document.getElementById("warning");
        warningDiv.textContent = "<@spring.message 'invalidUser'/>";
    } else if (accountValue === "balance") {
        const warningDiv = document.getElementById("warning");
        warningDiv.textContent = "<@spring.message 'notE'/>";
    } else if (accountValue === "success") {
        const successDiv = document.getElementById("success");
        successDiv.textContent = "<@spring.message 'succes'/>";
    } else if (accountValue === "yourself") {
        const yourselfDiv = document.getElementById("your");
        yourselfDiv.textContent = "<@spring.message 'noTransfer'/>";
    }
</script>
</body>
</html>
