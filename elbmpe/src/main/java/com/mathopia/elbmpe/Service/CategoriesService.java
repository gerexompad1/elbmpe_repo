package com.mathopia.elbmpe.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathopia.elbmpe.Entity.CategoriesEntity;
import com.mathopia.elbmpe.Repository.CategoriesRepository;



@Service
public class CategoriesService {
	@Autowired
	CategoriesRepository crepo;
	
	// C - Create or insert a course record
		public CategoriesEntity insertCategories(CategoriesEntity categories) {
			return crepo.save(categories);
		}
		
	//Read all records
	public List<CategoriesEntity> getAllCategories(){
		return crepo.findAll();
		}
	
	//R Read or search student record by Course
		public CategoriesEntity findByCategoryName(String categoryName) {
			if (crepo.findByCategoryName(categoryName)!= null)
				return crepo.findByCategoryName(categoryName);
			else
				return null;
		}
	
	//Update
	public CategoriesEntity putCategories(int categoryid, CategoriesEntity newCategoriesDetails) throws Exception {
		   CategoriesEntity categories = new CategoriesEntity();

		    try {
		        //Step 1 search the ID Num
		    	categories = crepo.findById(categoryid).get(); //find by ID

		        //Step 2 update record
		    	categories.setCategoryName(newCategoriesDetails.getCategoryName());

		        //Step 3 Save Information
		        return crepo.save(categories);
		    } catch(NoSuchElementException nex) {
		        throw new Exception(" ID Number " + categoryid + "Does Not Exist!");
		    }
		}	
	//Delete Record
    public String deleteCategories(int categoryid) {
        String msg;

        if (crepo.findById(categoryid) !=null) { // Find the record
            crepo.deleteById(categoryid);        // Delete the Record

            msg = "Category ID Number" + categoryid + "Is Successfully Deleted!";
        }
        else 
            msg = "Category ID Number" + categoryid + "Is Not Found!";

        return msg;
    }
}
