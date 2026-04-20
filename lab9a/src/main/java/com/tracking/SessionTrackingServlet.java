// 9.a Build a Session Management using Servlet program set with one minute session  to show Session Tracking Information, Session ID,Session Creation Time,Last Access Time,Visit Count

package com.tracking;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create or get session
        HttpSession session = request.getSession(true);

        // Set session expiry to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Get name from textbox
        String name = request.getParameter("userName");

        if (name != null && !name.isEmpty()) {
            session.setAttribute("user", name);
        }

        String user = (String) session.getAttribute("user");

        // Session details (your original logic kept)
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String sessionId = session.getId();

        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);

        // HTML output
        out.println("<html><body>");

        if (user != null) {
            out.println("<h2 style='color:blue;'>Hello " + user + "!</h2>");
            out.println("<p>You visited " + visitCount + " times.</p>");
            out.println("<p>Session ID: " + sessionId + "</p>");
            out.println("<p>Created: " + createTime + "</p>");
            out.println("<p>Last Access: " + lastAccessTime + "</p>");
            out.println("<p style='color:red;'>Session expires after 1 minute of inactivity</p>");
        } else {
            out.println("<h2>Enter your name:</h2>");
            out.println("<form action='SessionTracker' method='get'>");
            out.println("<input type='text' name='userName' required>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}
