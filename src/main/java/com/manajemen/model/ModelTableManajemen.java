/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manajemen.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author USER
 */
public class ModelTableManajemen extends AbstractTableModel {
    private List<ManajemenModel> tugasList;
    private String[] columnNames = {"ID", "Nama Tugas", "Detail", "Deadline", "Status"};

    public ModelTableManajemen(List<ManajemenModel> tugasList) {
        this.tugasList = tugasList;
    }

    @Override
    public int getRowCount() {
        return tugasList.size(); // Jumlah baris sesuai dengan jumlah data mahasiswa
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ManajemenModel tugas = tugasList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tugas.getId();
            case 1:
                return tugas.getNamatugas();
            case 2:
                return tugas.getDetail();
            case 3:
                return tugas.getDeadline();
            case 4:
                return tugas.getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setTugasList(List<ManajemenModel> tugasList) {
        this.tugasList = tugasList;
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}
