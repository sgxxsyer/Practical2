package demo;

import model.BookDAO;
import model.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 144320d on 10/29/2015.
 */
@WebServlet(name = "BookDetailsServlet", urlPatterns = "/bookdetails")
public class BookDetailsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookId = request.getParameter("bookId");
            if (bookId != null) {
                BookDAO db = new BookDAO();
                BooksEntity bd = db.getBookDetails(Integer.parseInt(bookId));
                // store bookdetails object in request scope with attribut name "book"
                // bookdetails.jsp will retrieve this stored object later to display the content
                request.setAttribute("book", bd);
                // forward the request to bookdetails.jsp, there must be a "/" before the web resource reference
                getServletContext().getRequestDispatcher("/bookdetails.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}