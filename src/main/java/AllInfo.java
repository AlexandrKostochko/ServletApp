import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/allInfo")
public class AllInfo extends HttpServlet {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (inMemoryUserStorage.getInfo() != null) {
            for (int i = 0; i < inMemoryUserStorage.getInfo().size(); i++) {
                resp.getWriter().println("name - " + inMemoryUserStorage.getInfo().get(i).getName() +
                        ", login - " + inMemoryUserStorage.getInfo().get(i).getLogin() +
                        ", password - " + inMemoryUserStorage.getInfo().get(i).getPassword() +
                        ", id - " + inMemoryUserStorage.getInfo().get(i).getUserid());
            }
        } else {
            resp.getWriter().println("no registered users");
        }
    }
}
