import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//1. Create a servlet that returns your first and last name in a heading element to the user if navigating to ```/name```.

@WebServlet(name = "Name", urlPatterns = "/name")
public class Name extends HttpServlet {
    String firstName = "Ryan";
    String lastName = "Cuvillier";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1 align =\"center\"> " + "Mr. " + firstName + " " + lastName + " </h1>");
        out.println("<body bgcolor = \"FFBB33\"></body");
    }
}