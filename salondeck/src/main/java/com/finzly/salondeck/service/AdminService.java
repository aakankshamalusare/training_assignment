package com.finzly.salondeck.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.salondeck.dao.AdminDao;
import com.finzly.salondeck.entity.ServiceInformation;


@Service
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public ResponseEntity<Map<String, String>> addService(ServiceInformation service) {
        return adminDao.addService(service);
    }

    public ResponseEntity<Map<String, String>> updateService(Map<String, String> entity) {
        return adminDao.updateService(entity);
    }

    public ResponseEntity<Map<String, String>> updateServiceName(Map<String, String> entity) {
        return adminDao.updateServiceName(entity);
    }

    public ResponseEntity<Map<String, String>> updateDescription(Map<String, String> entity) {
        return adminDao.updateDescription(entity);
    }

    public ResponseEntity<Map<String, String>> updatePrice(Map<String, String> entity) {
        return adminDao.updatePrice(entity);
    }

    public ResponseEntity<Map<String, String>> updateCategory(Map<String, String> entity) {
        return adminDao.updateCategory(entity);
    }

    public ResponseEntity<Map<String, String>> updateDuration(Map<String, String> entity) {
        return adminDao.updateDuration(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getAll() {
        return adminDao.getAll();
    }

    public ResponseEntity<List<ServiceInformation >> getByServiceName(Map<String, String> entity) {
        return adminDao.getByServiceName(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByPrice(Map<String, String> entity) {
        return adminDao.getByPrice(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByLessthanPrice(Map<String, String> entity) {
        return adminDao.getByLessthanPrice(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByGreaterthanPrice(Map<String, String> entity) {
        return adminDao.getByGreaterthanPrice(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByBetweenPrice(Map<String, String> entity) {
        return adminDao.getByBetweenPrice(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getAllStartwithServiceName(Map<String, String> entity) {
        return adminDao.getAllStartwithServiceName(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByCategory(Map<String, String> entity) {
        return adminDao.getByCategory(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getAllStartwithCategory(Map<String, String> entity) {
         return adminDao.getAllStartwithServiceCategory(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByDuration(Map<String, String> entity) {
        return adminDao.getByDuration(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByLessthanDuration(Map<String, String> entity) {
        return adminDao.getByLessthanDuration(entity);
    }

    public ResponseEntity<List<ServiceInformation >> getByGreaterthanDuration(Map<String, String> entity) {
        return adminDao.getByGreaterthanDuration(entity);
    }

    public ResponseEntity<Map<String, String>> deleteService(Map<String, String> entity) {
        return adminDao.deleteService(entity);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByServiceName(Map<String, String> entity) {
        return adminDao.deleteServiceByServiceName(entity);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByCategory(Map<String, String> entity) {
        return adminDao.deleteServiceByCategory(entity);
    }
    

    public ResponseEntity<Map<String, String>> deleteServiceByPrice(Map<String, String> entity) {
        return adminDao.deleteServiceByPrice(entity);
    }
    

    public ResponseEntity<Map<String, String>> deleteServiceByDuration(Map<String, String> entity) {
        return adminDao.deleteServiceByDuration(entity);
    }

    public ResponseEntity<Map<String, String>> deleteServiceByDescription(Map<String, String> entity) {
        return adminDao.deleteServiceByDescription(entity);
    }
    


    
}
