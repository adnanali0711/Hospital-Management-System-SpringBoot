package com.example.hospital.management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
@RequestMapping("/doctor")
public class DoctorController {
    private HashMap<Integer,Doctor> doctorDb = new HashMap<>();
    @PostMapping("/addDoctor")
    public String addDoctor(@RequestParam("doctorId")Integer doctorId,@RequestParam("name")String name,@RequestParam("age")Integer age,@RequestParam("degree")String degree,@RequestParam("specialization")String specialization){
        Doctor dr = new Doctor(doctorId,name,age,degree,specialization);
        doctorDb.put(doctorId,dr);
        return "Doctor Added Successfully";
    }

}

