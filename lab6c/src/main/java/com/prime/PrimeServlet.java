//6c. Build a servlet program to check the given number is prime number or not using HTML with step by step procedure.

package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numStr = request.getParameter("num");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(numStr);
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                out.println("<h2 style='color:green;'>" + num + " is a Prime Number</h2>");
            } else {
                out.println("<h2 style='color:red;'>" + num + " is NOT a Prime Number</h2>");
            }

        } catch (Exception e) {
            out.println("<h2 style='color:red;'>Invalid Input! Please enter a number.</h2>");
        }

        out.println("<br><a href='index.html'>Try Again</a>");
        out.println("</body></html>");
    }
}