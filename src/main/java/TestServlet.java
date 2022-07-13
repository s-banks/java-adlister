import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstName = req.getParameter("name");
//		http://localhost:8080/test?name=Shane will provide the result Hello Shane
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello " + firstName + "</h1>");
		res.sendRedirect("/hello");
	}
}
