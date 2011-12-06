<%@ page import="java.util.*" %>

<html>
    <body valign="middle">
        
        <p>
            <%
            String[] reply = (String[])request.getAttribute("styles");

            if(reply[0].equals("-1")) {
                out.println("<center><font size='5' color='black'><b>A problem has occured while updating the currency rates.</b></font></center>");
            }
            else {
                if(reply[0].equals("-2")) {
                    out.println("<center><font size='5' color='black'><b>Invalid input. The amount must contain only numerical characters.</b></font></center>");
                }
                else {
                    if(reply[0].equals("-3")) {
                        out.println("<center><font size='5' color='black'><b>Invalid input. The amount must be a non negative number.</b></font></center>");
                    }
                    else {
                        out.println("<br><br><br><br><h1 align=\"center\">" + reply[6] + "</h1><br>");
                        out.println("<center><table border=\"1\" bgcolor=\"#646D7E\"><tr><td><center><font size='5' color='black'><b>The current exchange rate is:</b></font></center><br>"
                        + "<center><li><font size='5' color='red'><b>" + reply[2] + " <img src=\"flags/" + reply[0] + ".png\"/>" + " = " + reply[3] + " <img src=\"flags/" + reply[1] + ".png\"/></b></font></center></td></tr></table></center><br><br><br>"
                        + "<center><table border=\"1\" bgcolor=\"#646D7E\"><tr><td><center><font size='5' color='black'><b>The amount requested to be converted is:</b></font></center><br>"
                        + "<center><li><font size='5' color='red'><b>" + reply[4] + " <img src=\"flags/" + reply[0] + ".png\"/>" + " = " + reply[5] + " <img src=\"flags/" + reply[1] + ".png\"/></b></font></center></td></tr></table></center>");
                    }
                }
            }
            
            %>
    </body>
</html>

