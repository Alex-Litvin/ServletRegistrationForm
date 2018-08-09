<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${!empty errors}">
        <table class="w3-table w3-bordered w3-striped">
            <c:forEach var="error" items="${errors}">
                <jsp:useBean id="error" class="java.lang.String"/>
                <tr>
                    <td><c:out value="${error}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">
        <c:if test="${!contact == null}">
        <p>Contact <c:out value= "${contact}" /> added!</p>
        </c:if>
    </div>

    <%--<div class="w3-panel w3-green w3-display-container w3-card-4 w3-round">--%>
        <%--<span onclick="this.parentElement.style.display='none'" --%>
        <%--class="w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green>×</span>--%>
        <%--<h5>Contact " <p><c:out value= "${contact}" /></p>+ " added!</h5>--%>
    <%--</div>--%>

    <span style="color: red; ">${message}</span>
    <span style="color: red; ">${sqlerror}</span>
    <span style="color: red; ">${notUnique}</span>
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