<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Signin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


  <style>
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
  <!-- Custom styles for this template -->
  <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
<form class="form-signin" action="/signIn" method = "post">
  <img class="mb-4" src="images/logo.svg"  width="90" height="90">
  <h1 class="h3 mb-3 font-weight-normal">Sign In</h1>
  <input type="email" id="inputUsername" name = "email" class="form-control" placeholder="email" required autofocus>

  <input type="password" id="inputPassword" name = "password" class="form-control" placeholder="пароль" required>
  <div class="checkbox mb-3">
  </div>
  <div class="signup_link">Запомнить меня?
    <input type="checkbox" name="rememberMe">
  </div>
  <button type="submit" class="btn btn-secondary">Sign In</button>

  <p class="mt-5 mb-3 text-muted">&copy; 2021-2022</p>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
