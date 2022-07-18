import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PickColorServlet", urlPatterns = "/pickcolor")
public class PickColorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pickcolor.jsp").forward(req, res);
	}

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	String color = req.getParameter("color");
	if (color != "") {
		//System.out.println(color);
		//req.setAttribute("color", color);
	//req.getRequestDispatcher("/WEB-INF/viewcolor.jsp").forward(req, res);
	res.sendRedirect("/viewcolor?color=" + color);
	} else {
		res.sendRedirect("/pickcolor");
	}
}
}
