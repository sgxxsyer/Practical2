<html>


<%@ page import="demo.*" %>
<%
  BookDBAO db = new BookDBAO();
  BookDetails book = db.getBook();
%>

<body bgcolor="#ffffff">
<%@include file="header.html"%>
<center>
  <hr>
  <br> &nbsp;<h1><font size="+3" color="#CC0066">Duke's </font> <img src="./duke.books.gif" alt="Duke holding books">
  <font size="+3" color="black">Bookstore</font></h1>
  <br> &nbsp;
  <hr>
</center>
<br> <b>What we are reading</b>
<blockquote><em><a href="bookdetails?bookId=<%= book.getBookId() %>"><%= book.getTitle() %></a></em> What a cool book.
</blockquote>
<p><a href="bookcatalog"><b>Start Shopping</b></a></p>
</body>
</html>
