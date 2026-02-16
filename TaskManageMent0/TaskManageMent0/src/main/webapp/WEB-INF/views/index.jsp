<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Amdox | Task Management System</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/home.css">
</head>

<body>

<!-- 🔹 NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
    <a class="navbar-brand fw-bold" href="#">Amdox</a>

    <div class="ms-auto">
        <a href="${pageContext.request.contextPath}/loginPage" class="btn btn-outline-light me-2">Login here </a>
        <a href="/register" class="btn btn-warning">Get Started</a>
    </div>
</nav>

<!-- 🔹 HERO SECTION -->
<section class="hero-section text-center text-light">
    <div class="container">
        <h1 class="fw-bold">Manage Tasks. Track Progress. Collaborate Better.</h1>
        <p class="mt-3">
            Amdox Task Management System helps teams organize work,
            meet deadlines, and improve productivity — all in one place.
        </p>

        <div class="mt-4">
            <a href="/register" class="btn btn-primary btn-lg me-3">Start Free</a>
            <a href="/login" class="btn btn-outline-light btn-lg">Login</a>
        </div>
    </div>
</section>

<!-- 🔹 FEATURES -->
<section class="features py-5">
    <div class="container text-center">
        <h2 class="fw-bold mb-4">Why Choose Amdox?</h2>

        <div class="row g-4 mt-3">

            <div class="col-md-4">
                <div class="feature-card">
                    <h5>Task Assignment</h5>
                    <p>Assign tasks with priorities and deadlines for better accountability.</p>
                </div>
            </div>

            <div class="col-md-4">
                <div class="feature-card">
                    <h5>Real-Time Collaboration</h5>
                    <p>Comment, share files, and communicate instantly with your team.</p>
                </div>
            </div>

            <div class="col-md-4">
                <div class="feature-card">
                    <h5>Progress Tracking</h5>
                    <p>Track task completion and performance using analytics dashboards.</p>
                </div>
            </div>

        </div>
    </div>
</section>

<!-- 🔹 CALL TO ACTION -->
<section class="cta-section text-center text-light">
    <h2 class="fw-bold">Boost Your Team’s Productivity Today</h2>
    <p class="mt-2">Secure. Scalable. Designed for teams of all sizes.</p>
    <a href="/register" class="btn btn-warning btn-lg mt-3">Create Account</a>
</section>

<!-- 🔹 FOOTER -->
<footer class="footer text-center">
    <p>© 2026 Amdox Technologies | Task Management System</p>
    <p>support@amdox.in</p>
</footer>

</body>
</html>
