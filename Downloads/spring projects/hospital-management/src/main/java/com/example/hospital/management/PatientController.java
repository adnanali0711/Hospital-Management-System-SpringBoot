package com.example.hospital.management;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @PostMapping("/addViaParameters")
    public String  addPatient(@RequestParam("PatientId") Integer patientId,@RequestParam("name") String name,@RequestParam("age") Integer age,@RequestParam("disease") String disease){
        Patient patient = new Patient(patientId,name,disease,age);
        patientDb.put(patientId,patient);
        return "Patient Added.";
    }
    @PostMapping("/addViaBody")
    public String addPatient(@RequestBody Patient patient){
        patientDb.put(patient.getPatient_id(),patient);
        return "Patient Added Succesfully Via Body.";
    }

    @GetMapping("/getInfoFromPathVariable/{patientId}")
    public Patient getPatientFromPath(@PathVariable("patientId") Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getList/{age}/{disease}")
    public List<Patient> getPatients(@PathVariable("age")Integer age,@PathVariable("disease")String disease){
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDb.values()){
            if(p.getAge()>age && disease.equals(p.getDisease())){
                patients.add(p);
            }
        }
        return patients;
    }


    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("PatientId") Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        List<Patient> ArrayList;
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDb.values()){
            patients.add(p);
        }
        return patients;
    }

    @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam("name")String name){
        for(Patient p : patientDb.values()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    @GetMapping("/getListGreaterThanAge")
    public List<Patient> getPatientListGreaterThanAge(@RequestParam("age")Integer age){
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDb.values()){
            if(p.getAge()>age){
                patients.add(p);
            }
        }
        return patients;
    }

    @PutMapping("/updateDetails")
    public String updatePatient(@RequestParam("Patient")Patient patient){
        int key = patient.getPatient_id();
        if(patientDb.containsKey(key)){
            patientDb.put(key,patient);
            return "Patient Details Updated Successfully.";
        }else{
            return "Patient doesn't exists";
        }

    }

    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId")Integer patientId){
        if(patientDb.containsKey(patientId)){
            patientDb.remove(patientId);
            return "patient deleted successfullly.";
        }else{
            return "patient is not present in the database";
        }
    }





}
