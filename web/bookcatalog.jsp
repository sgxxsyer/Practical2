<html>
<head><title>Duke's Bookstore</title></head>
<%@ page import="demo.*, java.util.*" %>
<%
  BookDBAO db = new BookDBAO();
  List<BookDetails> books =db.getAllBook();
%>
<body bgcolor="#ffffff">
<center>
  <hr>
  <br> &nbsp;<h1><font size="+3" color="#CC0066">Duke's </font> <img src="./duke.books.gif" alt="Duke holding books">
  <font size="+3" color="black">Bookstore</font></h1>
  <br> &nbsp;
  <hr>
</center>
<br>
<h3>Please Choose from our selection</h3>
<br>
<center>
  <table summary="layout">
    <%
      for (BookDetails book : books) {
    %>
    <tr>
      <td bgcolor="#ffffaa"><a href="/bookdetails?bookId=<%= book.getBookId() %>"> <strong><%= book.getTitle()%></strong></a></td>
      <td bgcolor="#ffffaa" rowspan=2><%= book.getPrice() %></td>
      <td bgcolor="#ffffaa" rowspan=2><a href="/bookcatalog?bookId=<%= book.getBookId() %>"> Add to Cart</a></td>
    </tr>
    <tr>
      <td>by<em><%= book.getFirstName() %></em></td>
    </tr>
    <%
      }
    %>
  </table>
</center>
</body>
</html>