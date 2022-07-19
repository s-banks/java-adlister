import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Ads adsDao = DaoFactory.getAdsDao();
        List<Ad> ads = adsDao.all();
        String username;
        if (session.getAttribute("user") == null) {
            username = " there";
        } else {
            username = ", " + session.getAttribute("user");
        }
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.setAttribute("user", username);
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
