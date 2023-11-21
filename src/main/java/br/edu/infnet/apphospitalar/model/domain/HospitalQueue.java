package br.edu.infnet.apphospitalar.model.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospitalQueue {

    public HospitalQueue() {
        patientsQueue = new ArrayList<>();
    }

    @Getter
    private int position;

    @Getter
    private List<Patient> patientsQueue;


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hospital Queue:\n");

        for (int i = 0; i < patientsQueue.size(); i++) {
            stringBuilder.append(String.format("%d. %s%n", i + 1, patientsQueue.get(i).getFullName()));
        }
        return stringBuilder.toString();
    }
}
