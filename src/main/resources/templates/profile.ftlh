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

    #green {
        background-color: green;
        border-color: green;
        width: 130px;
    }

    #blue {
        width: 130px;
        border-color: red;
        background-color: red;
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
                        <a class="nav-link" href="/#">
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
    <div class="container mt-4">
        <h2>Transaction History</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Sender</th>
                <th>Receiver</th>
                <th>Sum</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <#list transactions as transaction >
                <tr>
                    <td>${transaction.senderAccount}</td>
                    <td>${transaction.receiverAccount}</td>
                    <td>${transaction.amount} som</td>
                    <td>${transaction.actDate}</td>
                    <#if transaction.senderAccount==user.account>
                        <td>
                            <a href="#" id="blue" class="btn btn-primary">Debit</a>
                        </td>
                    <#else>
                        <td>
                            <a href="#" id="green" class="btn btn-primary">Transfer</a>
                        </td>
                    </#if>
                </tr>
            </#list>

            </tbody>
        </table>
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
