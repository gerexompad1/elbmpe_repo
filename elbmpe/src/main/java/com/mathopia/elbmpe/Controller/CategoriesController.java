package com.mathopia.elbmpe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathopia.elbmpe.Entity.CategoriesEntity;
import com.mathopia.elbmpe.Service.CategoriesService;


@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {
	@Autowired
	CategoriesService cserv;
	
	//Create or insert a course record
		@PostMapping("/postCategories")
		public CategoriesEntity insertCategories(@RequestBody CategoriesEntity category) {
			return cserv.insertCategories(category);
		}
		
		//Read all records
		@GetMapping("/getAllCategories")
		public List<CategoriesEntity> getAllCategories(){
			return cserv.getAllCategories();
		}
		
		//Read a record by code
		@GetMapping("/getByCategoryName")
		public CategoriesEntity findByCategoryName(@RequestParam String categoryName) {
			return cserv.findByCategoryName(categoryName);
		}
		
		//Update Record
	    @PutMapping("/putCategories")
	    public CategoriesEntity putCategories(@RequestParam int categoryid,@RequestBody CategoriesEntity newCategoriesDetails) throws Exception{
	        return cserv.putCategories(categoryid, newCategoriesDetails);
	    }
	    
	  //Delete Record
	    @DeleteMapping("/deleteCategories/{categoryid}")
	    public String deleteCategories(@PathVariable int categoryid) {
	        return cserv.deleteCategories(categoryid);
	    }
}

