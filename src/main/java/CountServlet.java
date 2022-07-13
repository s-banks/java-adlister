import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


	@WebServlet(name = "CountServlet", urlPatterns = "/count")
	public class CountServlet extends HttpServlet {
		int hitCount = 0;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String reset = req.getParameter("reset");
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			if (reset == null) {
				hitCount += 1;
				out.println("<h1>Page visit count: " + hitCount + "</h1>");
			} else if (reset.equalsIgnoreCase("y")){
				out.println("<h1>Visit Count Reset</h1>");
				hitCount = 0;
			} else {
				hitCount += 1;
				out.println("<h1>Page visit count: " + hitCount + "</h1>");
			}
		}
	}
