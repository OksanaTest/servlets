import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {

    private String message;
    private String param1;
    private String param2;
    private String param3;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        param1 = config.getInitParameter("one");
        param2 = config.getInitParameter("two");
        param3 = config.getInitParameter("operation");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter messageWriter = response.getWriter();
        /*messageWriter.println("initial first parameter" +  "=" +  param1);*/


        request.getSession().setAttribute(param1, request.getParameter("one"));
        request.getSession().setAttribute("two", request.getParameter("two"));
        request.getSession().setAttribute(param3, request.getParameter("operation"));

        messageWriter.println();
        String val;
        String val1;
        String val2;
        val = (String) request.getSession().getAttribute(param1);
        val1 = (String) request.getSession().getAttribute("two");
        val2 = (String) request.getSession().getAttribute(param3);


        messageWriter.println("one param from request is: " + val);
        messageWriter.println("two param from request is: " + val1);
        messageWriter.println("three param from request is: " + val2);

        messageWriter.println("current auth is " +
                request.getContextPath());

    }

    public void destroy() {};

    }
