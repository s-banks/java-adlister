import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAdsServlet", urlPatterns = "/ads")
public class ShowAdsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Ads ListAdsDao = DaoFactory.getAdsDao();
		List<Ad> ads = ListAdsDao.all();
		req.setAttribute("ads", ads);
		req.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(req, res);
	}
}
