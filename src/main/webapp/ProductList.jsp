<%-- 
    Document   : ProductList
    Created on : Feb 13, 2018, 2:43:35 AM
    Author     : Nick
--%>

<%@page import="edu.wctc.dj.week4.model.Product"%>
<%@page import="edu.wctc.dj.week4.model.Name"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>s
        <title>Store Front</title>
        <link rel="stylesheet" href="style.css">
        <meta name="viewport" content="width=device-width, initial scale=1.0">
        <script src="
                http://html5shim.googlecode.com/svn/trunk/html5.js">
        </script>
    </head>

    <body>
        <div id="wrapper">
            <header>
                <h1>Store Front</h1>
            </header>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="ProductList.jsp">Product List</a></li>
                    <li><a href="ProductDetail.jsp">Product Details</a></li>
                    <li><a href="ShoppingCart.jsp">Shopping Cart</a></li>
                </ul>
            </nav>
            <main id="hero">	


                <div>

                    <h2>Product List</h2>
                    <table>
                        <tr>
                            <th> Product Name </th>
                            <th> Price </th>
                            
                        </tr>
			<%
			List<Product> productList =
				(List<Product>) request.getAttribute("productList");
			for (Product product : productList){
			%>
                        
                        <tr>
				<td><%= product.getProductName()%></td>
				<td>
		<a href="?id=<%= product.getProductId()%>"><%= product.getProductPrice()%></a>
				</td>
			</tr>
			<%
			}
			%>
		</table>

            </main>
            <footer>
                Copyright &copy; 2016 Store Front<br>
                <a href="mailto:nrieck@wctc.edu">Nicholas@Rieck.com</a>
            </footer>
        </div>
    </body>
</html>
