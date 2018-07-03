package com.bridgelabz.servlets;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
public class LoginListener implements HttpSessionListener 
{

	/*ServletContext context=null;
	int total_users=0;
	int current_users=0;*/


	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  
    {
    	System.out.println("new session cerated");
    	/*total_users++;
    	current_users++;
    	context=se.getSession().getServletContext();
    	context.setAttribute("total_users", total_users);
    	context.setAttribute("current_users", current_users);*/

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  
    {
    	//current_users--;
    	System.out.println("session destroyed");
    	/*context.setAttribute("current_users", current_users);
    	System.out.println( "total users= "+total_users);
    	System.out.println("current users= "+current_users);*/
    }
	
}
