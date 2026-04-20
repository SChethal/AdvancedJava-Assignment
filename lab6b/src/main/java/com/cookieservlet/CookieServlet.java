//6b. Build a servlet program to create a cookie to get your name through text box and press submit button( through HTML) to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also.


package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        Cookie[] cookies = request.getCookies();
        String name = null;
        int count = 0;

        // Read cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    name = c.getValue();
                }
                if (c.getName().equals("count")) {
                    try {
                        count = Integer.parseInt(c.getValue());
                    } catch (Exception e) {
                        count = 0;
                    }
                }
            }
        }

        // First time login
        if (userName != null && !userName.isEmpty()) {
            name = userName;
            count = 1;
        } 
        // Returning user
        else if (name != null) {
            count++;
        }

        // Create cookies if user exists
        if (name != null) {
            Cookie userCookie = new Cookie("user", name);
            Cookie countCookie = new Cookie("count", String.valueOf(count));

            // Expiry (30 seconds demo)
            userCookie.setMaxAge(30);
            countCookie.setMaxAge(30);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        // HTML Output
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (name != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + name + "!</h2>");
            out.println("<h2 style='color:green;'>You have visited this page " + count + " times!</h2>");
            out.println("<p>Refresh to increase count. Wait 30 sec to see cookie expiry.</p>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! you have been logged out or kindly login first time</h2>");
            out.println("<form action='CookieServlet' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'/>");
            out.println("<input type='submit' value='Submit'/>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST (form submit)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        // Redirect to GET with parameter
        response.sendRedirect("CookieServlet?userName=" + userName);
    }
}