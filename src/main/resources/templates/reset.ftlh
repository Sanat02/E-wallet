<#import "spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reset</title>
</head>
<body>
<div class="text-center">
    <h2><@spring.message 'reset'/></h2>
    <#if error??>
        <b class="text-danger">${error}</b>
    </#if>
</div>

<div class="py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-7 col-lg-5 col-xl-5">
            <form action="/reset" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                           value="${(_csrf.token)!'csrf-token'}"/>
                </#if>
                <input type="hidden" name="token" value="${token!}">
                <input type="password" name="<@spring.message 'password'/>" class="form-control"
                       placeholder="<@spring.message 'text.password'/>" required autofocus/>
                <p class="text-center">
                    <button type="submit" class="btn btn-primary mt-3"><@spring.message 'submit'/></button>
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>