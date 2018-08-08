<%@ page import="java.util.List" %>
<html>
<head>
    <title>Servlet Registration Form</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">

<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Add contact</h2>
    </div>
    <%
        List<String> errors = (List<String>) request.getAttribute("errors");
        if (errors != null && !errors.isEmpty()) {
            out.println("<ul class=\"w3-ul\">");
            for (String s : errors) {
                out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
            }
            out.println("</ul>");
        }
    %>
    <%
        if (request.getAttribute("contact") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green " +
                    "   w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Contact " + request.getAttribute("contact") + " added!</h5>\n" +
                    "</div>");
        }
    %>
    <span style="color: red; ">${message}</span>
    <span style="color: red; ">${sqlerror}</span>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>First name:
            <input type="text" name="firstName" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Second Name:
            <input type="text" name="secondName" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Middle name:
            <input type="text" name="middleName" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Login:
            <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Comment:
            <input type="text" name="comment" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Home phone:
            <input type="tel" name="homePhone" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Mobile phone:
            <input type="tel" name="mobile" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Email:
            <input type="email" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Skype:
            <input type="text" name="skype" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Postcode:
            <input type="number" name="postcode" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>City:
            <input type="text" name="city" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Street:
            <input type="text" name="street" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>House number:
            <input type="number" name="houseNumber" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <label>Apartment number:
            <input type="number" name="apartmentNumber" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>
        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Add</button>
    </form>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>

</body>
</html>