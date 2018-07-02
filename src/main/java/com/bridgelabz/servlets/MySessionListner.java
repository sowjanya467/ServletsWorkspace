/*package com.bridgelabz.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

*//**
 * Application Lifecycle Listener implementation class MySessionListner
 *
 *//*
public class MySessionListner implements HttpSessionListener 
{
	ServletContext context=null;
	int total_users=0;
	int current_users=0;
	

    *//**
     * Default constructor. 
     *//*
    public MySessionListner() {
        // TODO Auto-generated constructor stub
    }

	*//**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     *//*
    public void sessionCreated(HttpSessionEvent se) 
    {
    	total_users++;
    	current_users++;
    	context=se.getSession().getServletContext();
    	context.setAttribute("total_users", total_users);
    	context.setAttribute("current_users", current_users);
    }

	*//**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     *//*
    public void sessionDestroyed(HttpSessionEvent se)  
    {
    	current_users--;
    	context.setAttribute("current_users", current_users);

    
    }
	
}
*/