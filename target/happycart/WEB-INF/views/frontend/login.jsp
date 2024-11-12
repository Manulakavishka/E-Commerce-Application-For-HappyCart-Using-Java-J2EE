
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="${BASE_URL}assets/resources/img/logo.svg">
    <title>Happy Cart | Log in</title>

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

    <link rel="stylesheet" href="${BASE_URL}assets/style.css">
  </head>

  <body class="hold-transition login-page" style="background-color: #74EBD5; background-image: linear-gradient(90deg,#74EBD5 0%,#9FACE6 100%);">
    <div class="alert alert-success d-none" id="alart">
    </div>
    <div class="login-box">
      <!-- /.login-logo -->
      <div class="card card-outline card-primary">
        <div class="card-header text-center">
          <a href="index" class="h1"><b>Happy Cart</b></a>
        </div>
        <div class="card-body">
          <p class="login-box-msg">Welcome to Happy Cart</p>

          <form action="index3.html" method="post">
            <div class="input-group mb-3">
              <input type="email" class="form-control" placeholder="Email" id="e">
              <div class="input-group-append">
                <div class="input-group-text">
                  <span class="fas fa-envelope"></span>
                </div>
              </div>
            </div>
            <div class="input-group mb-3">
              <input type="password" class="form-control" placeholder="Password" id="pw">
              <div class="input-group-append">
                <div class="input-group-text">
                  <span class="fas fa-lock"></span>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-8">
                <div class="icheck-primary">
                  <input type="checkbox" id="remember">
                  <label for="remember">
                    Remember Me
                  </label>
                </div>
              </div>
              <!-- /.col -->
              <div class="col-4">
                <button type="button" class="btn btn-primary btn-block swalDefaultWarning sign-up12" >Sign In</button>
              </div>
              <!-- /.col -->
            </div>
          </form>



          <p class="mb-1">
            <a href="#" onclick="forgotPassword();">I forgot my password</a>
          </p>
          <p class="mb-0">
            <a href="register" class="text-center">Register a new membership</a>
          </p>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
    </div>
    <!-- /.login-box -->

    <!-- model -->

    <div class="modal" tabindex="-1" id="fogotPasswordModel">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Modal title</h5>

          </div>
          <div class="modal-body">

            <div class="row g-3">

              <div class="col-6">
                <label class="form-label">New Password</label>
                <div class="input-group mb-3">
                  <input type="password" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2" id="np">

                  <button class="btn btn-secondary" type="button" id="npb" onclick="showpassword1();"><i class="bi bi-eye-slash-fill">Show</i></button>
                </div>

              </div>
              <div class="col-6">
                <label class="form-label">Re-Type Password</label>
                <div class="input-group mb-3">
                  <input type="password" class="form-control" id="rnp">

                  <button class="btn btn-secondary" type="button" id="rnpb" onclick="showpassword2();"><i class="bi bi-eye-slash-fill">Show</i></button>
                </div>

              </div>

              <div class="col-6">
                <label class="form-label">Verification Code</label>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" id="vc">
                </div>

              </div>
              <p>Verification code has send to your email. please check inbox.</p>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" onclick="resetpassword();">Reset</button>
          </div>
        </div>
      </div>
    </div>

    <!-- model -->


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

    <script src="${BASE_URL}assets/bootstrap.js"></script>
    <script src="${BASE_URL}assets/script.js"></script>

  </body>

  </html>
  <script type="text/javascript">


    document.getElementsByClassName('sign-up12').item(0).addEventListener('click', function () {



      var email = document.getElementById("e").value;
      var password = document.getElementById("pw").value;
      var rememberme = document.getElementById("remember").checked;

      fetch('login',{
        method:'post',
        headers:{
          'Content-Type':'application/json'
        },
        body:JSON.stringify({
          password:password,
          email:email,
          rememberme:rememberme
        })
      }) .then(function(response) {
        if (response.status === 200) {
          // Handle successful response
          // Change the URL using JavaScript
          window.location.href = 'index';
        } else if(response.status===403) {
          alert("Please Confirm Your Email");
        }else {
          // Handle other response status codes
          console.error('Request failed with status:', response.status);
          alert("Invalid Email or Password");
        }
      })
              .catch(function(error) {
                // Handle network or other errors
                console.error('Request failed:', error);
              });

    });


  </script>
