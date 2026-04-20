<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Result Form</title>

<script>
function validateForm() {
    let marks = document.getElementsByClassName("marks");

    for (let i = 0; i < marks.length; i++) {
        let value = marks[i].value;

        if (value === "" || isNaN(value) || value < 0 || value > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }
    return true;
}
</script>

<style>
.container {
    width: 350px;
    margin: auto;
    border: 1px solid #ccc;
    padding: 20px;
}
</style>
</head>

<body>
<div class="container">
<h2>Student Details</h2>

<form action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno" required><br><br>
Name: <input type="text" name="name" required><br><br>

Sub1: <input type="text" name="sub1" class="marks" required><br><br>
Sub2: <input type="text" name="sub2" class="marks" required><br><br>
Sub3: <input type="text" name="sub3" class="marks" required><br><br>
Sub4: <input type="text" name="sub4" class="marks" required><br><br>
Sub5: <input type="text" name="sub5" class="marks" required><br><br>

<input type="submit" value="Submit">

</form>
</div>
</body>
</html>