<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admission Page</title>
    <style>
        body {
    font-family: Arial, sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh; 
	}

	.form-container {
    background-color: #ffffff;
    padding: 40px;
    border-radius: 8px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 80%; 
    max-width: 600px; 
    min-height: 400px; 
    display: flex;
    flex-direction: column;
    justify-content: center;
	}

	.form-container h2 {
    margin-bottom: 20px;
	}

	.form-group {
    margin-bottom: 20px;
    flex: 1; 
	}

	.form-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 10px;
	}

	.form-group input[type="file"] {
    width: calc(100% - 20px);
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-top: 5px;
	}

	.form-group input[type="submit"] {
    width: calc(100% - 20px);
    background-color: #4caf50;
    color: white;
    padding: 10px;
    margin: 30px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
	}

	.form-group input[type="submit"]:hover {
    background-color: #45a049;
	}
        
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Admission Form</h2>
        <form action="UploadServlet" method="post" enctype="multipart/form-data" class="form-group">
            <label for="passport">Upload Student Passport Picture (.jpg or .png):</label>
            <input type="file" name="passport" accept=".jpg, .jpeg, .png" required><br>
            <label for="certificates">Upload Certificates (Diploma) (PDF only):</label>
            <input type="file" name="certificates" accept=".pdf" required><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
