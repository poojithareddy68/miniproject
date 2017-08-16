package com.infor.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class BookController {
	 @Autowired
	    private DBBookDao dbbookdao;
	 
	    // handler methods go here...
	 
	 //handler method for listing all the books (it will serve as the home page)
	 @RequestMapping(value="/")
	 public ModelAndView listdbbook(ModelAndView model) throws IOException{
	     List<DBBook> listdbbook = dbbookdao.list();
	     model.addObject("listdbbook", listdbbook);
	     model.setViewName("home");
	  
	     return model;
	 }
	 
	 //handler method for displaying new  form
	 @RequestMapping(value = "/newbook", method = RequestMethod.GET)
	 public ModelAndView newDBBook(ModelAndView model) {
	     DBBook newDBBook = new DBBook();
	     model.addObject("dbbook", newDBBook);
	     model.setViewName("DBBookForm");
	     return model;
	 }
	 
	 //handler method for inserting/updating the form
	 @RequestMapping(value = "/saveDBBook", method = RequestMethod.POST)
	 public ModelAndView saveDBBook(@ModelAttribute DBBook dbbook) {
	     dbbookdao.save(dbbook);
	     return new ModelAndView("redirect:/");
	 }
	 
	 //handler method for deleting a contact
	 @RequestMapping(value = "/deleteDBBook", method = RequestMethod.GET)
	 public ModelAndView deleteDBBook(HttpServletRequest request) {
	     int id = Integer.parseInt(request.getParameter("id"));
	     dbbookdao.delete(id);
	     return new ModelAndView("redirect:/");
	 }
	 
	 //handler method for retrieving details of a particular contact for editing
	 @RequestMapping(value = "/editDBBook", method = RequestMethod.GET)
	 public ModelAndView editDBBook(HttpServletRequest request) {
	     int id = Integer.parseInt(request.getParameter("id"));
	     DBBook dbbook = dbbookdao.get(id);
	     ModelAndView model = new ModelAndView("DBBookForm");
	     model.addObject("dbbook", dbbook);
	  
	     return model;
	 }
	 
}
