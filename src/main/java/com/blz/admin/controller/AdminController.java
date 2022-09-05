package com.blz.admin.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.admin.DTO.AdminDTO;
import com.blz.admin.model.AdminModel;
import com.blz.admin.service.IAdminService;
import com.blz.admin.util.Response;

/**
 * Purpose: Admin controller to process Admin Data APIs.
 * @version: 4.15.1.RELEASE
 * @author: Pavan Kumar G V  
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	/**
	 * Purpose: Create Admin
	 * @Param: adminDTO
	 */
	@PostMapping("/addadmin")
	public AdminModel addAdmin(@Valid@RequestBody AdminDTO adminDTO) {
		return adminService.addAdmin(adminDTO);
	}

	/**
	 * Purpose:Update Admin details
	 * @Param: id
	 */
	@PutMapping("/updateadmin/{id}")
	public ResponseEntity<Response> updateAdmin(@Valid@RequestBody AdminDTO adminDTO,@PathVariable Long id ,@RequestHeader String token) {
		AdminModel adminModel = adminService.updateAdmin(adminDTO,id, token);
		Response response = new Response("Admin updated successfully", 200, adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}

	/**
	 * Purpose:To get all the Admin data
	 * @Param: token
	 */
	@GetMapping("/getalladmins")
	public ResponseEntity<Response> getAllAdmins(@RequestHeader String token) {
		List<AdminModel> adminModel = adminService.getAllAdmins(token);
		Response response = new Response("Getting all the Admins successfully", 200, adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}

	/**
	 * Purpose:TO get Admin data by id
	 * @Param: id and token
	 */
	@GetMapping("/getadminbyid/{id}")
	public ResponseEntity<Response> getAdminById(@PathVariable Long id,@RequestHeader String token) {
		Optional<AdminModel> adminModel = adminService.getAdminById(id, token);
		Response response = new Response("Getting Admin by id successfully", 200, adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Purpose:TO delete Admin data by id 
	 * @Param: id and token
	 */
	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<Response> deleteAdmin(@PathVariable Long id,@RequestHeader String token) {
		AdminModel adminModel = adminService.deleteAdmin(id, token);
		Response response = new Response("Admin deleted successfully", 200, adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}

	/**
	 * Purpose:Login method 
	 * @Param: email and password
	 */
	@PostMapping("/login")
	public Response login(@RequestParam String emailId,@RequestParam String password) {
		return adminService.login(emailId, password);
	}

	/**
	 * Purpose:TO reset the password
	 * @Param: emailid
	 */
	@PostMapping("/resetpassword")
	public Response resetPassword(@RequestParam String emailId) {
		return adminService.resetPassword(emailId);
	}

	/**
	 * Purpose:To change the password
	 * @Param: token and password
	 */
	@PutMapping("/changepassword/{token}")
	public AdminModel changePassword(@PathVariable String token, @RequestParam String password) {
		return adminService.changePassword(token,password);
	}

	/**
	 * Purpose:TO create profilepath
	 * @Param: id,profilepath and token
	 */
	@PostMapping("/addprofilepath")
	public ResponseEntity<Response> addProfilePath(@RequestBody Long id,@RequestParam String profilePath,@RequestHeader String token) {
		AdminModel adminModel = adminService.addProfilePath(id,profilePath, token);
		Response response = new Response("Admin profile fath added successfully", 200, adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/validateuser/{token}")
	public Boolean validateUser(@PathVariable String token) {
		return adminService.validateUser(token);
	}
}