import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderPost", urlPatterns = "/order-summary")
public class OrderPost extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String product = req.getParameter("prodcutName");
        String quantity = req.getParameter("quantity");
        out.println("<h1> " + product + quantity + " </h1>");
        out.println("<body bgcolor = \"#1d99bb\"></body");
    }
}