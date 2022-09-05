package com.blz.admin.service;
import java.util.List;
import java.util.Optional;
import com.blz.admin.DTO.AdminDTO;
import com.blz.admin.model.AdminModel;
import com.blz.admin.util.Response;

public interface IAdminService {
	
	AdminModel addAdmin(AdminDTO adminDTO);
	
	AdminModel updateAdmin(AdminDTO adminDTO,Long id,String token);
	
	List<AdminModel> getAllAdmins(String token);
	
	Optional<AdminModel> getAdminById(Long id,String token);
	
	AdminModel deleteAdmin(Long id,String token);
	
	Response login(String emailId, String password);

	Response resetPassword(String emailId);

	AdminModel changePassword(String token, String password);

	AdminModel addProfilePath(Long id,String profilePath,String token);

	Boolean validateUser(String token);
}
