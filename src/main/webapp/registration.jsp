<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">  
<title>Student Registration Page</title>
</head>
<body>

<form action="InsertStudentServlet" method="post">
    <table align="center">
         <tr> <td align="center"><h3>Student Registration Page</h3></td></tr>
    
    </table>

    <table border="2" align="center">
    
    
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstname"  required></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastname" required></td>
        </tr>
        <tr>
            <td>Email Address</td>
            <td><input type="email" name="email" required></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input type="text" name="phno" required></td>
        </tr>
        <tr>
            <td>Date of Birth</td>
            <td><input type="date" name="date" required></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value="Male" required>Male
                <input type="radio" name="gender" value="Female" required>Female
                <input type="radio" name="gender" value="Other" required>Other
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td><textarea name="address" rows="3" cols="30" required></textarea></td>
        </tr>
        <tr>
            <td>Select Course</td>
            <td>
                <select name="course" required>
                    <option value="BCA">BCA</option>
                    <option value="msc_it">M.Sc IT</option>
                    <option value="BTech">BTech</option>
                    <option value="MTech">MTech</option>
                    <option value="MCA">MCA</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Preferred Batch Time</td>
            <td>
                <select name="batchtime" required>
                    <option value="Morning">Morning</option>
                    <option value="Afternoon">Afternoon</option>
                    <option value="Evening">Evening</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Payment Mode</td>
            <td>
                <input type="radio" name="paymentmode" value="credit_card" required>Credit Card
                <input type="radio" name="paymentmode" value="debit_card" required>Debit Card
                <input type="radio" name="paymentmode" value="net_banking" required>Net Banking
            </td>
        </tr>
        <tr>
            <td>Extracurricular Activities</td>
            <td>
                <input type="checkbox" name="sports" value="true">Sports
                <input type="checkbox" name="music" value="true">Music
                <input type="checkbox" name="debate" value="true">Debate
                <input type="checkbox" name="volunteering" value="true">Volunteering
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
