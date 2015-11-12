package demo;

import model.BookDAO;
import model.BooksEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by chitboon on 10/29/15.
 */
@WebServlet(name = "BookCatalogServlet", urlPatterns="/bookcatalog")

public class BookCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDAO db = new BookDAO();
            BooksEntity book = db.getBook();
            List<BooksEntity> list = db.getAllBook();
            // store bookdetails object in request scope with attribut name "book"
            // bookdetails.jsp will retrieve this stored object later to display the content
            request.setAttribute("allbooks", list);
            // forward the request to bookdetails.jsp, there must be a "/" before the web resource reference
            getServletContext().getRequestDispatcher("/bookcatalog.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}