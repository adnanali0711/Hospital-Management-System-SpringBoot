package com.example.hospital.management;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository  // This is the class that will contain  the database (HashMap,MySQL)
public class NurseRepository {
    HashMap<Integer,Nurse> nurseDb = new HashMap<>();

    public String addNurse(Nurse nurse){
        int key = nurse.getNurseId();
        nurseDb.put(key,nurse);
        return "Nurse Added Repository";
    }

    public List<Nurse> getALlNurses(){
        List<Nurse> nurses = nurseDb.values().stream().toList();
        return nurses;
    }

}
