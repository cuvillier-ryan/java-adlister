import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    private int count;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        count++;
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");

        if (name == null) {
            name = "World";
        }

        out.println("<h1 align =\"center\"> " + " Hello, " + name + "!" + " </h1>");
        out.println("<h1 align =\"center\"> " +  + count + "!" + " </h1>");
        out.println("<body bgcolor = \"CCE5FF\"></body");
    }
}
