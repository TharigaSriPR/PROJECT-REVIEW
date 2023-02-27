package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository serviceRepository;
	
	@Autowired
	StudentService service;
	
	@GetMapping("/getvalues")
	List<student> getList(){
		return serviceRepository.findAll();

	}
	@PostMapping("/post")
    public student create(@RequestBody student stu) {
	  return serviceRepository.save(stu);
	}
	
	@GetMapping("/getvalues/{id}")
	public Optional<student> getbyid(@PathVariable int id){
		return service.getStudent(id);
	}
	@PutMapping("/student")
	public String update (@RequestBody student stu){
		return service.updateDetails(stu);
	}
	
	@DeleteMapping("/student")
	public String delete(@RequestParam int id) {
		return service.deleteDetails(id);
	}
	@GetMapping("/student/{offset}/{PageSize}")
	public List<student> studentWithPagination(@PathVariable int offset,@PathVariable int PageSize){
		return service.setPages(offset,PageSize);
	}
	@GetMapping("/student/{field}")
	public List<student> studentSortList (@PathVariable String field){
		return service.getSort(field);
	}
}
