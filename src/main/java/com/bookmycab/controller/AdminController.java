package com.bookmycab.controller;

import com.bookmycab.model.Admin;
import com.bookmycab.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins/{id}")
    public Admin getAdmin(@PathVariable("id") Integer id) {
        return adminService.getAdmin(id);
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/admins")
    public Admin insertAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }

    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@PathVariable("id") Integer id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public Admin deleteAdmin(@PathVariable("id") Integer id) {
        return adminService.deleteAdmin(id);
    }
}
