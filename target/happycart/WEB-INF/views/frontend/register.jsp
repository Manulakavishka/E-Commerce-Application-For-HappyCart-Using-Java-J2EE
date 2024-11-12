<%--<%@ taglib uri="http://callidora.lk/jsp/template-inheritance" prefix="layout" %>--%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="${BASE_URL}assets/resources/img/logo.svg">
  <title>Happy Cart | Registration Page</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${BASE_URL}assets/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="${BASE_URL}assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${BASE_URL}assets/dist/css/adminlte.min.css">


  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="${BASE_URL}assets/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
  <!-- Toastr -->
  <link rel="stylesheet" href="${BASE_URL}assets/plugins/toastr/toastr.min.css">
</head>

<body class="hold-transition register-page " style="background-color: #74EBD5; background-image: linear-gradient(90deg,#74EBD5 0%,#9FACE6 100%);">
  <div class="register-box">
    <div class="card card-outline card-primary ">
      <div class="card-header text-center">
        <a href="index2.jsp" class="h1"><b>Happy Cart</b></a>
      </div>
      <div class="card-body">
        <p class="login-box-msg">Register a new membership</p>

        <form action="index.jsp" method="post">
          <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="First name" id="fname">
            <div class="input-group-append">
              <div class="input-group-text">
                <span class="fas fa-user"></span>
              </div>
            </div>
          </div>

          <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Last name" id="lname">
            <div class="input-group-append">
              <div class="input-group-text">
                <span class="fas fa-user"></span>
              </div>
            </div>
          </div>

          <div class="input-group mb-3">
            <input type="email" class="form-control" placeholder="Email" id="email">
            <div class="input-group-append">
              <div class="input-group-text">
                <span class="fas fa-envelope"></span>
              </div>
            </div>
          </div>
          <div class="input-group mb-3">
            <input type="password" class="form-control" placeholder="Password" id="password">
            <div class="input-group-append">
              <div class="input-group-text">
                <span class="fas fa-lock"></span>
              </div>
            </div>
          </div>
          <div class="input-group mb-3">
            <input type="password" class="form-control" placeholder="Retype password" id="repassword">
            <div class="input-group-append">
              <div class="input-group-text">
                <span class="fas fa-lock"></span>
              </div>
            </div>
          </div>

          <div class="form-group">
            <select class="form-control" id="gender">
              <option selected disabled value="SELECT">Select one</option>
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
            </select>
          </div>

          <div class="row">
            <div class="col-8">
              <div class="icheck-primary">
                <input type="checkbox" id="agreeTerms" name="terms" value="agree">
                <label for="agreeTerms" id="agree">
                  I agree to the <a href="#">terms</a>
                </label>
              </div>
            </div>
            <!-- /.col -->
            <div class="col-4">
              <button type="button" class="btn btn-primary btn-block swalDefaultWarning sign-up12" >Register</button>
            </div>
            <!-- /.col -->
          </div>
        </form>



        <a href="login" class="text-center">I already have a membership</a>
      </div>
      <!-- /.form-box -->
    </div><!-- /.card -->
  </div>
  <!-- /.register-box -->

  <!-- jQuery -->
  <script src="${BASE_URL}assets/plugins/jquery/jquery.min.js"></script>
  <!-- Bootstrap 4 -->
  <script src="${BASE_URL}assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- AdminLTE App -->
  <script src="${BASE_URL}assets/dist/js/adminlte.min.js"></script>

  <!-- SweetAlert2 -->
  <script src="${BASE_URL}assets/plugins/sweetalert2/sweetalert2.min.js"></script>
  <!-- Toastr -->
  <script src="${BASE_URL}assets/plugins/toastr/toastr.min.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="${BASE_URL}assets/dist/js/demo.js"></script>
  <!-- Page specific script -->
  <script>

  </script>

  <script src="${BASE_URL}assets/script.js"></script>
</body>
  <script type="text/javascript">


    document.getElementsByClassName('sign-up12').item(0).addEventListener('click', function () {



      var fname = document.getElementById("fname").value;
      var lname = document.getElementById("lname").value;
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;
      var repassword = document.getElementById("repassword").value;
      var gender = document.getElementById("gender").value;
      var agreeTerms = document.getElementById("agreeTerms").checked;
      // alert("abct");

      fetch('register',{
        method:'post',
        headers:{
          'Content-Type':'application/json'
        },
        body:JSON.stringify({
          password:password,
          fname:fname,
          lname:lname,
          email:email,
          repassword:repassword,
          gender:gender,
          agreeTerms:agreeTerms
        })
      }).then(response=> response.text())
              .then(text=>document.body.innerHTML=text);

    });


  </script>
</html>