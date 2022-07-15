import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pizzaorder.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		System.out.println(req.getParameter("crust"));
		System.out.println(req.getParameter("sauce"));
		System.out.println(req.getParameter("size"));
		String[] toppings = req.getParameterValues("toppings");
		for (String str : toppings) {
			System.out.println(str);
		}
		System.out.println(req.getParameter("address"));
	}
}
