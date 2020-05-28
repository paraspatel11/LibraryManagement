package ca.sheridancollege;

import ca.sheridancollege.dao.*;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.beans.*;

@Controller
public class HomeController {

	
	Dao dao = new Dao();
	
	
	@RequestMapping("/")
	public String goHome() {
		
		return "index";
	}
	
	@RequestMapping("/Location")
	public String goLocation(Model model) {
		
		model.addAttribute("location", new Location());
		
		return "Location";
	}
	
	@RequestMapping("/Book")
	public String goBook(Model model) {
		
		model.addAttribute("book", new Book());
		
		List<String> listofLocation = dao.listOfLocation();
		model.addAttribute("listLocation", listofLocation);
		
		
		return "Book";
	}
	
	@RequestMapping("/ViewRecords")
	public String goListBooks(Model model, @ModelAttribute Book book) {
		
		List<String> listofLocation = dao.listOfLocation();
		model.addAttribute("listLocation", listofLocation);
		
		return "Display";
	}
	
// *******************************************************************************************************	
	
	@RequestMapping("/AddLocation")
	public String goAddLocation(Model model, @ModelAttribute Location location ) {
		
		if(dao.addLocation(location)==true)
		{
			model.addAttribute("mess", "!!Location was Successfully Added!!");
			model.addAttribute("location", new Location());
			
			return "Location";
		}
		else {
			model.addAttribute("mess", "!!Location Had ERROR while Adding!!");
			
			return "Location";
		}
		
	}
//-----------------****************---------------------------------
	
	@RequestMapping("/AddBook")
	public String goAddBook(Model model, @ModelAttribute Book book) {
		
		if(dao.addBook(book)==true)
		{
			model.addAttribute("mess", "!!Book was Successfully Added!!");
			
			List<String> listofLocation = dao.listOfLocation();
			model.addAttribute("listLocation", listofLocation);
			
			model.addAttribute("book", new Book());
			return "Book";
		}
		else {
			model.addAttribute("mess", "!!Book Had ERROR while Adding!!");
			
			return "Book";
		}
	}
	
	@RequestMapping("/DummyRecords")
	public String goListLocationName(Model model) {
		
		dao.generateRecords();
		
		model.addAttribute("mess", "!!Dummy Records Generated!! PLZ DO NOT PRESS IT AGAIN");
		
		return "index";
	}
	
//-----------------****************---------------------------------
	
	@RequestMapping("/ListBookName")
	public String goListBookName(Model model, @ModelAttribute Book book, @RequestParam String location) {
		
		List<String> listofLocation = dao.listOfLocation();
		model.addAttribute("listLocation", listofLocation);
		
		List<Book> booklist = dao.getBooks(location);
		model.addAttribute("bookList", booklist);
		
		return "Display";
	}
	
//-----------------****************---------------------------------
	
	@RequestMapping(value = "/delete/{id}")	
	public String delete(Model model, @PathVariable int id) {
		
		
		System.out.println("ID: --> "+id);
		
		dao.deleteBookById(id);
		
		model.addAttribute("messDel", "!!Book with ID: "+id+" was DELETED from the List!!");
		
		
		return "index";
	}
	
	
	
//-----------------****************---------------------------------
	
	@RequestMapping(value = "/BookNameTitle")	
	public String goBookNameTitle(Model model, @RequestParam String search, @ModelAttribute Book book) {
		
		
		
		model.addAttribute("bookList", dao.searchBookName(search));
		
		
		return "BookInfo";
	}
	
	@RequestMapping(value = "/ListOfBookName")	
	public String goBookTitle(Model model, @ModelAttribute Book book) {
		
		return "BookInfo";
	}
	
	
	
	/*
	 * <form:form action="/" method="get"> 
				<input style="background-color: navy;" type="submit" value="Home Page" />
			</form:form>
			
			
		 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
	    
	   <link rel="stylesheet" href="css/style.css">
	 * 
	 * 	
	 */
		
}
