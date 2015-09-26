package myapp;

import javax.servlet.http.*;
import java.io.IOException;

public class DemoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("{ \"name\": \"Buttonizer Team\" }");
    }
}
