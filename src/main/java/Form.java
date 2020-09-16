import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//1. Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.

@WebServlet(name = "Form", urlPatterns = "/order-form")
public class Form extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        res.setHeader("content-type", "text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><form action=\"order-summary\" method=\"POST\">\n" +
                "Product Name: <input type=\"text\" name=\"productName\">\n" +
                "<br />\n" +
                "Quantity: <input type=\"text\" name=\"quantity\" />\n" +
                "<input type=\"submit\" value=\"Submit\" />\n" +
                "</form></html>");
        out.println("<body bgcolor = \"#1d99bb\"></body");
    }
}