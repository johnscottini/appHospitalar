package br.edu.infnet.apphospitalar.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

public class HospitalQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    public HospitalQueue() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hospital Queue:\n");
        return stringBuilder.toString();
    }

}
