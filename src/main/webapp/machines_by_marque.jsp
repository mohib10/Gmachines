<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Machine"%>
<% ArrayList machines = (ArrayList)request.getAttribute("machines");%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="ressources/img/logo/logo.png" rel="icon">
    <title>Gmachine - Dashboard</title>
    <link href="ressources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="ressources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="ressources/css/ruang-admin.min.css" rel="stylesheet">
</head>

<body id="page-top">
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="ressources/index.html">
                <div class="sidebar-brand-icon">
                    <img href="ressources/img/logo/logo2.png">
                </div>
                <div class="sidebar-brand-text mx-3">Gmachine</div>
            </a>
            <hr class="sidebar-divider my-0">
            <li class="nav-item active">
                <a class="nav-link" href="ressources/index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>
            <hr class="sidebar-divider">
            <div class="sidebar-heading">
                Features
            </div>
            <li class="nav-item">
                <a class="nav-link collapsed" href="marques" data-toggle="collapse" data-target="#collapseBootstrap" aria-expanded="true" aria-controls="collapseBootstrap">
                    <i class="far fa-fw fa-window-maximize"></i>
                    <span>Marques</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="machines" data-toggle="collapse" data-target="#collapseBootstrap" aria-expanded="true" aria-controls="collapseBootstrap">
                    <i class="far fa-fw fa-window-maximize"></i>
                    <span>Machines</span>
                </a>
            </li>
        </ul>
        <!-- Sidebar -->
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <!-- TopBar -->
                <nav class="navbar navbar-expand navbar-light bg-navbar topbar mb-4 static-top">
                    <button id="sidebarToggleTop" class="btn btn-link rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="ressources/#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                <form class="navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-1 small" placeholder="What do you want to look for?" aria-label="Search" aria-describedby="basic-addon2" style="border-color: #3f51b5;">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="ressources/#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="ressources/#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="ressources/#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="ressources/#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="ressources/#">Show All Alerts</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="ressources/#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <span class="badge badge-warning badge-counter">2</span>
                            </a>
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="ressources/#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" href="ressources/img/man.png" style="max-width: 60px" alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been having.
                                        </div>
                                        <div class="small text-gray-500">Udin Cilok ? 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="ressources/#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" href="ressources/img/girl.png" style="max-width: 60px" alt="">
                                        <div class="status-indicator bg-default"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Jaenab ? 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="ressources/#">Read More Messages</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="ressources/#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-tasks fa-fw"></i>
                                <span class="badge badge-success badge-counter">3</span>
                            </a>
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Task
                                </h6>
                                <a class="dropdown-item align-items-center" href="ressources/#">
                                    <div class="mb-3">
                                        <div class="small text-gray-500">Design Button
                                            <div class="small float-right"><b>50%</b></div>
                                        </div>
                                        <div class="progress" style="height: 12px;">
                                            <div class="progress-bar bg-success" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </a>
                                <a class="dropdown-item align-items-center" href="ressources/#">
                                    <div class="mb-3">
                                        <div class="small text-gray-500">Make Beautiful Transitions
                                            <div class="small float-right"><b>30%</b></div>
                                        </div>
                                        <div class="progress" style="height: 12px;">
                                            <div class="progress-bar bg-warning" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </a>
                                <a class="dropdown-item align-items-center" href="ressources/#">
                                    <div class="mb-3">
                                        <div class="small text-gray-500">Create Pie Chart
                                            <div class="small float-right"><b>75%</b></div>
                                        </div>
                                        <div class="progress" style="height: 12px;">
                                            <div class="progress-bar bg-danger" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="ressources/#">View All Taks</a>
                            </div>
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="logout" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="img-profile rounded-circle" src="ressources/img/photo.png" style="max-width: 60px">
                                <span class="ml-2 d-none d-lg-inline text-white small">Mohib oussama</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="ressources/#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
                                </a>
                                <a class="dropdown-item" href="ressources/#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Settings
                                </a>
                                <a class="dropdown-item" href="ressources/#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i> Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="ressources/javascript:void(0);" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> Logout
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <!-- Topbar -->

                <!-- Container Fluid-->
                <div class="container-fluid" id="container-wrapper">
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Marques</h1>
                    </div>

                    <div class="row mb-3">
                        <!-- Earnings (Monthly) Card Example -->
                       
                        <!-- Invoice Example -->
                        <div class="col-xl-12 col-lg-7 mb-4">
                            <div class="card">
                                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">Invoice</h6>
                                    <a class="m-0 float-right btn btn-danger btn-sm" href="add_marque">Add new Marque <i
                                    
                      class="fas fa-chevron-right"></i></a>
                                </div>
                                <div class="table-responsive">
                                <table class="table align-items-center table-flush">
			                        <thead>
			                          <tr>
			                            <th>Id</th>
			                            <th>Reference</th>
			                            <th>Marque id</th>
			                            <th>Date d'achat</th>
			                            <th>Prix</th>
			                            <th>Action</th>
			                          </tr>
			                        </thead>
			                        <tbody>
			                        <% int index = 0; while (machines.size() > index){%>
			                         <tr>
			                         	<% Machine machine = (Machine) machines.get(index++);%>
			                        	<td> <%= machine.getId()  %> </td>
			                            <td> <%= machine.getReference() %> </td>
			                            <td>  <%= machine.getMarqueId() %></td>
			                            <td>  <%= machine.getDateAchat() %></td>
			                            <td>  <%= machine.getPrix() %></td>
			                            <td class="d-flex justify-content-start"> <a type="button" href="update_machine?id=<%= machine.getId()%>" class="btn btn-primary btn-sm m-2">Modifier</a> 
			                            <form method="POST" action="delete_machine">  <button type="submit" class="btn btn-danger btn-sm m-2"> <input type="hidden" value="<%=machine.getId()%>" name="id" /> Supprimer</button> </form></td>
			                          </tr>
									<%}%>
			                        </tbody>
			                      </table>
                                </div>
                                <div class="card-footer"></div>
                            </div>
                        </div>
                    </div>
                    <!--Row-->

                    
                    <!-- Modal Logout -->
                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLogout" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabelLogout">Ohh No!</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure you want to logout?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Cancel</button>
                                    <a href="ressources/login.html" class="btn btn-primary">Logout</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!---Container Fluid-->
            </div>
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by
              <b><a href="ressources/https://indrijunanda.gitlab.io/" target="_blank">oussama</a></b>
            </span>
                    </div>
                </div>

                <div class="container my-auto py-2">
                    <div class="copyright text-center my-auto">
                        <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - distributed by
              <b><a href="ressources/https://themewagon.com/" target="_blank">themewagon</a></b>
            </span>
                    </div>
                </div>
            </footer>
            <!-- Footer -->
        </div>
    </div>

    <!-- Scroll to top -->
    <a class="scroll-to-top rounded" href="ressources/#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <script href="ressources/vendor/jquery/jquery.min.js"></script>
    <script href="ressources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script href="ressources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script href="ressources/js/ruang-admin.min.js"></script>
    <script href="ressources/vendor/chart.js/Chart.min.js"></script>
    <script href="ressources/js/demo/chart-area-demo.js"></script>
</body>

</html>