import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().println("<h1>Hello, World!</h1>");
        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        } else if (name.equalsIgnoreCase("jeff-bezos")) {
            response.sendRedirect("https://amazon.com");
            return;
        }
        request.setAttribute("name", name);
        request.getRequestDispatcher("/WEB-INF/hello-world.jsp").forward(request, response);
    }
}
