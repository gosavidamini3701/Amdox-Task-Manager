<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Amdox | Dashboard</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/dashboard.css">
</head>

<body>

<!-- 🔹 NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
    <a class="navbar-brand fw-bold" href="#">Amdox</a>

    <div class="ms-auto d-flex align-items-center">
        <span class="text-white me-3">Welcome, Developer</span>
        <a href="/logout" class="btn btn-outline-light btn-sm">Logout</a>
    </div>
</nav>

<!-- 🔹 DASHBOARD HEADER -->
<section class="dashboard-header text-white text-center">
    <h1>Project Dashboard</h1>
    <p>Track tasks, issues, and progress efficiently</p>
</section>

<!-- 🔹 MAIN CONTENT -->
<div class="container my-5">

    <!-- PROFILE + STATS -->
    <div class="row g-4 mb-4">

        <!-- PROFILE CARD -->
        <div class="col-md-4">
            <div class="card dashboard-card">
                <div class="card-body text-center">
                    <div class="profile-avatar mb-3">JD</div>
                    <h5 class="fw-bold">John Developer</h5>
                    <p class="text-muted mb-1">john.dev@amdox.com</p>
                    <span class="badge bg-primary">DEVELOPER</span>

                    <hr>

                    <div class="text-start">
                        <p><strong>Team:</strong> Core Platform</p>
                        <p><strong>Status:</strong> Active</p>
                        <p><strong>Joined:</strong> Jan 2024</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- STATS -->
        <div class="col-md-8">
            <div class="row g-4">

                <div class="col-md-4">
                    <div class="stat-card">
                        <h6>Total Issues</h6>
                        <h2>42</h2>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="stat-card">
                        <h6>In Progress</h6>
                        <h2>12</h2>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="stat-card">
                        <h6>Completed</h6>
                        <h2>30</h2>
                    </div>
                </div>

            </div>
        </div>

    </div>

    <!-- 🔹 TASK BOARD -->
    <div class="row g-4">

        <div class="col-md-4">
            <div class="board-column">
                <h6>To Do</h6>
                <div class="task-card">Design Login Page</div>
                <div class="task-card">Create JWT Filter</div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="board-column">
                <h6>In Progress</h6>
                <div class="task-card">Dashboard UI</div>
                <div class="task-card">API Integration</div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="board-column">
                <h6>Done</h6>
                <div class="task-card done">User Authentication</div>
                <div class="task-card done">Role Management</div>
            </div>
        </div>

    </div>

</div>

<!-- 🔹 FOOTER -->
<footer class="footer text-center">
    © 2026 Amdox · Task Management System
</footer>

</body>
</html>
