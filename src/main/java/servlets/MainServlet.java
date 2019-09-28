package servlets;

import util.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        Integer val;
        String value = request.getParameter("value");
        if (value == null || value.isEmpty()) {
            val = 0;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            val = Integer.parseInt(value) * 2;
            response.setStatus(HttpServletResponse.SC_OK);
        }
        pageVariables.put("value", val);
        response.getWriter().println(val);
        response.setContentType("text/html;charset=utf-8");
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        return pageVariables;
    }
}
