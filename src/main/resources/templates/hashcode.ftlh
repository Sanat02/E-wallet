<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3 text-center">
            <h1 class="display-4">Your Generated Account Code</h1>
            <p class="lead">Here is your unique account code:</p>
            <h2 class="font-weight-bold">${account}</h2>
            <p class="mt-4">Click the buttons below to proceed:</p>
            <a href="/login" class="btn btn-primary mr-2">Login</a>
            <a href="/register" class="btn btn-success">Register</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
