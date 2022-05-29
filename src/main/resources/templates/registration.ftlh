<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signUp.page.title'/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style>
        .error {
            color: red;
        }
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="center">
<form class="form-signin" action="/signUp" method = "post">
    <img class="mb-4" src="images/logo.svg" alt="" width="90" height="90">
    <h1 class="h3 mb-3 font-weight-normal"><@spring.message 'signUp.page.title'/></h1>
    <form action="/signUp" method="post">
        <@spring.bind path="signUpForm"/>
        <p class="error">${spring.status.errorMessage}</p>

        <form class="needs-validation" novalidate>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <div class="txt_field">
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.firstName"/></#assign>
                        <@spring.formInput "signUpForm.firstName" "placeholder=${i18Tooltip}"/>
                    </div>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="col-md-6 mb-3">
                    <div class="txt_field">
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.lastName"/></#assign>
                        <@spring.formInput "signUpForm.lastName" "placeholder=${i18Tooltip}"/>
                    </div>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="col-md-6 mb-3">
                    <div class="txt_field">
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
                        <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
                    </div>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="col-md-6 mb-3">
                    <div class="txt_field">
                        <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
                        <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
                        <br>
                    </div>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <button type="submit" class="btn btn-secondary">Зарегестрироваться</button>
            </div>
        </form>
        </div>
    </form>
</form>
</body>
</html>