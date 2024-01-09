package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")


public class NurseController {

    NurseService nurseservice = new NurseService();


    @PostMapping("/add")
    public String addNurse(@RequestParam("Nurse")Nurse nurse){

       String ans = nurseservice.addNurse(nurse);
       return ans;
    }

    @GetMapping("/getByAge")
    public List<Nurse> getAllGreaterThanAge(@RequestParam("age")Integer age){
        List<Nurse> nurses = nurseservice.getAllNurse(age);
        return nurses;
    }

    @GetMapping("/getByQualificatino")
    public List<Nurse> getByQualifications(@RequestParam("Qualificaitons")String qualifications){
        List<Nurse> nurses = nurseservice.getByQualifications(qualifications);
        return nurses;
    }


}
