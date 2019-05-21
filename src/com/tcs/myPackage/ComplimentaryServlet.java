package com.tcs.myPackage;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
public class ComplimentaryServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{	    

     ComplimentaryBean ComplimentaryPackage = new ComplimentaryBean();
     ComplimentaryPackage.setPackageID(request.getParameter("un"));
     ComplimentaryPackage.setPackageName(request.getParameter("pw"));

     ComplimentaryPackage = ComplimentaryDAO.login(ComplimentaryPackage);
	   		    
     if (ComplimentaryPackage.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionComplimentaryPackage",ComplimentaryPackage); 
          response.sendRedirect("ComplimentaryPackage.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("invalidLogin.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
}
}




