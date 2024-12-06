/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manajemen.model;

import jakarta.persistence.*;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "tugas")
public class ManajemenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nama tugas", nullable = false, length = 30)
    private String namatugas;

    @Column(name = "detail", nullable = false, length = 50)
    private String detail;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "status")
    private String status;
    
    public ManajemenModel() {

    }
    
    public ManajemenModel(int id, String namatugas, String detail, String deadline, String status) {
        this.id = id;
        this.namatugas = namatugas;
        this.detail = detail;
        this.deadline = deadline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamatugas() {
        return namatugas;
    }

    public void setNamatugas(String namatugas) {
        this.namatugas = namatugas;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
