<%--
  Created by IntelliJ IDEA.
  User: Shane
  Date: 7/15/22
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order</title>
    <%@ include file="../partials/head.jsp" %>
</head>
<body>
<%@ include file="../partials/navbar.jsp" %>
<form action="/pizza-order" method="POST">
    <div class="form-group">
        <label for="crust">Choose a crust:</label>
        <select name="crust" id="crust">
            <option value="">--Please choose an option--</option>
            <option value="thin-crust">Thin and Cripy</option>
            <option value="deep-crust">Deep Dish</option>
            <option value="ny-crust">NY Style</option>
            <option value="stuffed-crust">Stuffed Crust</option>
        </select>
    </div>
    <br>
    <div class="form-group">
        <label for="sauce">Choose a sauce:</label>
        <select name="sauce" id="sauce">
            <option value="">--Please choose an option--</option>
            <option value="marinara-sauce">Marinara</option>
            <option value="wht-sauce">White Sauce</option>
            <option value="garlic-sauce">Garlic Sauce</option>
            <option value="buffalo-sauce">Buffalo Sauce</option>
        </select>
    </div>
    <br>
    <div class="form-group">
        <label for="size">Choose a size:</label>
        <select name="size" id="size">
            <option value="">--Please choose an option--</option>
            <option value="personal">Personal</option>
            <option value="small">Small</option>
            <option value="large">Large</option>
            <option value="nysize">NY Sized (only available with NY Style crust)</option>
        </select>
    </div>
    <br>
    <div class="form-group">
        <input type="checkbox" id="pepperoni" name="toppings" value="pepperoni">
        <label for="pepperoni">Pepperoni</label>
        <br>
        <input type="checkbox" id="mushrooms" name="toppings" value="mushrooms">
        <label for="mushrooms">Mushrooms</label>
        <br>
        <input type="checkbox" id="x-cheese" name="toppings" value="x-cheese">
        <label for="x-cheese">Extra Cheese</label>
        <br>
        <input type="checkbox" id="sausage" name="toppings" value="sausage">
        <label for="sausage">Sausage</label>
        <br>
        <input type="checkbox" id="onion" name="toppings" value="onion">
        <label for="onion">Onion</label>
        <br>
        <input type="checkbox" id="olives" name="toppings" value="olives">
        <label for="olives">Black Olives</label>
        <br>
        <input type="checkbox" id="grnpeppers" name="toppings" value="grnpeppers">
        <label for="grnpeppers">Green Peppers</label>
        <br>
        <input type="checkbox" id="garlic" name="toppings" value="garlic">
        <label for="garlic">Fresh Garlic</label>
        <br>
        <input type="checkbox" id="tomato" name="toppings" value="tomato">
        <label for="tomato">Tomato</label>
        <br>
        <input type="checkbox" id="basil" name="toppings" value="basil">
        <label for="basil">Fresh Basil</label>
    </div>
    <br>
    <div class="form-group">
        <textarea rows="4" cols="50" name="address" id = "address" placeholder="Enter your address here..."></textarea>
    </div>
    <br>
    <input type="submit" class="btn btn-primary" value="Place Order">
</form>
</body>
</html>
