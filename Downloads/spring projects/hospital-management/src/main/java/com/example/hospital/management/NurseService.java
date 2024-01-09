package com.example.hospital.management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nursereposiory = new NurseRepository();

    public String addNurse(Nurse nurse) {
        if (nurse.getNurseId() < 0) return "Enter Valid Nurse Id";

        if (nurse.getName().equals(null)) return "Enter nurse name";
        String ans = nursereposiory.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getAllNurse(int age) {
        List<Nurse> nurses = nursereposiory.getALlNurses();

        List<Nurse> finalList = new ArrayList<>();

        for (Nurse n : nurses) {
            if (n.getAge() > age) {
                finalList.add(n);
            }
        }
        return finalList;
    }

    public List<Nurse> getByQualifications(String qualif) {
        List<Nurse> nurses = nursereposiory.getALlNurses();
        List<Nurse> finalList = new ArrayList<>();
        for (Nurse n : nurses) {
            if (n.getQualifications().equals(qualif)) {
                finalList.add(n);
            }
        }
        return finalList;
    }
}