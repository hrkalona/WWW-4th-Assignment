/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author than
 */
package CurrencyConverter2;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;

public class CurrencyServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String amount = request.getParameter("input_money");
            CurrencyConverter obj = new CurrencyConverter();
            String[] reply = new String[7];
            
            double double_amount;
            try {
                 double_amount = Double.valueOf(amount);
                 if(double_amount >= 0) {
                     String[] temp = obj.convert(from, to, double_amount);
                     for(int i = 0; i < temp.length; i++) {
                         reply[i] = temp[i]; 
                     }                     
                 }
                 else {
                     reply[0] = "-3"; 
                 }
            } 
            catch(NumberFormatException ex)  {
                reply[0] = "-2";
            }
            
            Date today = new Date();
            
            reply[6] = today.toString();
                     
            request.setAttribute("styles", reply);
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
           
        }
        catch (ServletException ex) {}
        catch (IOException ex) {}
            
           

    }
}
