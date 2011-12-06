package CurrencyConverter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona
 */
public class CurrencyConverter {
    
    public String[] convert(String From, String To, double amount) {

        URL rate, convert;
        BufferedReader in, in2;
        String answer, answer_rate;
        String[] reply_to_user = new String[6];
        reply_to_user[0] = From;
        reply_to_user[1] = To;
        reply_to_user[2] = "";
        reply_to_user[3] = "";
        reply_to_user[4] = "";
        reply_to_user[5] = "";
        
        try {

            convert = new URL("http://www.google.com/ig/calculator?hl.0=en&q=" + amount + From + "=?" + To);
            rate = new URL("http://www.google.com/ig/calculator?hl=en&q=1.0" + From + "=?" + To);
            
            in = new BufferedReader(new InputStreamReader(convert.openStream()));
            in2 = new BufferedReader(new InputStreamReader(rate.openStream()));
            
            answer = in.readLine();
            answer = answer.substring(7);
            
            answer_rate = in2.readLine();
            answer_rate = answer_rate.substring(7);
                      
            int i;
            for(i = 0; answer.charAt(i) != '\"'; i++) {
                reply_to_user[4] += answer.charAt(i);
            }
            
            reply_to_user[4] = reply_to_user[4].replace('?', ',');
            
            answer = answer.substring(i + 8);
            
            for(i = 0; answer.charAt(i) != '\"'; i++) {
                reply_to_user[5] += answer.charAt(i);
            }
            
            reply_to_user[5] = reply_to_user[5].replace('?', ',');
            
            for(i = 0; answer_rate.charAt(i) != '\"'; i++) {
                reply_to_user[2] += answer_rate.charAt(i);
            }
            
            reply_to_user[2] = reply_to_user[2].replace('?', ',');
            
            answer_rate = answer_rate.substring(i + 8);
            
            for(i = 0; answer_rate.charAt(i) != '\"'; i++) {
                reply_to_user[3] += answer_rate.charAt(i);
            }
            
            reply_to_user[3] = reply_to_user[3].replace('?', ',');
  
        } 
        catch (MalformedURLException ex) {
            reply_to_user[0] = "-1";
        }
        catch (IOException ex) {
            reply_to_user[0] = "-1";
        }
        
        return reply_to_user;
        
    }
         
}
