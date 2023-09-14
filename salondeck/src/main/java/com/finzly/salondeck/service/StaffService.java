package com.finzly.salondeck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.salondeck.dao.StaffDao;
import com.finzly.salondeck.entity.StaffInformation;



@Service
public class StaffService {

    @Autowired 
	 StaffDao staffDao;
	
	

	public ResponseEntity<String> signUp(Map<String, String> entity) {
		
		 return staffDao.signUp(entity);
	}



	public ResponseEntity<Map<String, String>> loginByPhonenumber(Map<String, String> entity) {
		
		return staffDao.loginByPhonenumber(entity);
	}



	public ResponseEntity<Map<String, String>> loginByEmail(Map<String, String> entity) {
	
		return staffDao.loginByEmail(entity);
	}



	public ResponseEntity<String> getQuestion(Map<String, String> entity) {
		
		return staffDao.getQuestion(entity);
	}



	public ResponseEntity<String> updatePassword(Map<String, String> entity) {
		
		return staffDao.updatePassword(entity) ;
	}



	public ResponseEntity<Map<String, String>> updateProfile(Map<String, String> entity) {
	
		return staffDao. updateProfile(entity);
	}



	public ResponseEntity<List<StaffInformation>> getAll() {
		
		return staffDao. getAll();
	}



	public ResponseEntity<List> getByGender(Map<String, String> entity) {
		
		return staffDao.getByGender(entity);
	}



	public ResponseEntity<List> getByPhonenumber(Map<String, String> entity) {
		
		return staffDao.getByPhonenumber(entity);
	}



	public ResponseEntity<List> getByEmail(Map<String, String> entity) {
		
		return staffDao.getByEmail(entity);
	}



	public ResponseEntity<List> getByCity(Map<String, String> entity) {
		
		return staffDao.getByCity(entity);
	}



	public ResponseEntity<List> getByLogin(Map<String, String> entity) {
		
		return  staffDao.getByLogin(entity);
	}


	public ResponseEntity<List<StaffInformation>> getByPosition(Map<String, String> entity) {
		return staffDao.getByPosition(entity);
	}



    public ResponseEntity<List<StaffInformation>> getByHireDate(Map<String, String> entity) {
        return staffDao.getByHireDate(entity);
    }


	public ResponseEntity<String> logOut(Map<String, String> entity) {
		
		return staffDao.logOut(entity);
	}

/*
 *   13 Sept
 */

	
 public ResponseEntity<List<StaffInformation>> getByLeaves(Map<String, String> entity) {
		
		return staffDao.getByLeaves(entity) ;
	}



	public ResponseEntity<List<StaffInformation>> getBySalary(Map<String, String> entity) {
		return staffDao.getBySalary(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByLessthanSalary(Map<String, String> entity) {
		return staffDao.getByLessthanSalary(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByGreaterthanSalary(Map<String, String> entity) {
		return staffDao.getByGreaterthanSalary(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByBetweenSalary(Map<String, String> entity) {
		return staffDao.getByBetweenSalary(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByLessthanLeaves(Map<String, String> entity) {
		 return staffDao.getByLessthanLeaves(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByGreaterthanLeaves(Map<String, String> entity) {
		return staffDao.getByGreaterthanLeaves(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByBetweenLeaves(Map<String, String> entity) {
		return staffDao.getByBetweenLeaves(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByBeforeHireDate(Map<String, String> entity) {
		return staffDao.getByBeforeHireDate(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByAfterHireDate(Map<String, String> entity) {
		return staffDao.getByAfterHireDate(entity);
	}



	public ResponseEntity<List<StaffInformation>> getByBetweenHireDate(Map<String, String> entity) {
		return staffDao.getByBetweenHireDate(entity);
	}



	public ResponseEntity<Map<String, String>> updateName(Map<String, String> entity) {
		return staffDao.updateName(entity);
	}



	public ResponseEntity<Map<String, String>> updatePhonenumber(Map<String, String> entity) {
		return staffDao.updatePhonenumber(entity);
	}



    public ResponseEntity<Map<String, String>> updateEmail(Map<String, String> entity) {
        return staffDao.updateEmail(entity);
    }



    public ResponseEntity<Map<String, String>> updateCity(Map<String, String> entity) {
        return staffDao.updateCity(entity);
    }



    public ResponseEntity<Map<String, String>> updatePosition(Map<String, String> entity) {
        return staffDao.updatePosition(entity);
    }



    public ResponseEntity<Map<String, String>> updateSalary(Map<String, String> entity) {
        return staffDao.updateSalary(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployee(Map<String, String> entity) {
        return staffDao.deleteEmployee(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByName(Map<String, String> entity) {
        return staffDao.deleteEmployeeByName(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByCity(Map<String, String> entity) {
        return staffDao.deleteEmployeeByCity(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByPhonenumber(Map<String, String> entity) {
        return staffDao.deleteEmployeeByPhonenumber(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByEmail(Map<String, String> entity) {
        return staffDao.deleteEmployeeByEmail(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByPosition(Map<String, String> entity) {
       return staffDao.deleteEmployeeByPosition(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeBySalary(Map<String, String> entity) {
        return staffDao.deleteEmployeeBySalary(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByHireDate(Map<String, String> entity) {
        return staffDao.deleteEmployeeByHireDate(entity);
    }



    public ResponseEntity<Map<String, String>> deleteEmployeeByLeaves(Map<String, String> entity) {
        return staffDao. deleteEmployeeByLeaves(entity);
    }



    public ResponseEntity<List> getAllStartwithName(Map<String, String> entity) {
        return staffDao.getAllStartwithName(entity);
    }



    public ResponseEntity<List> getAllStartwithCity(Map<String, String> entity) {
        return staffDao.getAllStartwithCity(entity);
    }



    public ResponseEntity<List> getAllStartwithEmail(Map<String, String> entity) {
        return staffDao.getAllStartwithEmail(entity);
    }



    public ResponseEntity<List> getAllStartwithPhonenumber(Map<String, String> entity) {
        return staffDao.getAllStartwithPhonenumber(entity);
    }



    public ResponseEntity<List> getAllStartwithPosition(Map<String, String> entity) {
        return  staffDao.getAllStartwithPosition(entity);
    }



    public ResponseEntity<List> getAllStartwithHireDate(Map<String, String> entity) {
        return staffDao.getAllStartwithHireDate(entity);
    }






}
