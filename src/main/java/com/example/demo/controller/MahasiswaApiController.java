package com.example.demo.controller;

import com.example.demo.model.Mahasiswa;
//import com.example.demo.model.Mahasiswa;
import com.example.demo.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import java.util.HashMap;
//import java.util.Map;

@RestController

public class MahasiswaApiController {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping(value = "/mahasiswaapi")
    public ResponseEntity<Object> getMahasiswa() {
        return new ResponseEntity<>(mahasiswaService.listMahasiswa(), HttpStatus.OK);
    }
    
    @RequestMapping(value="/mahasiswaapi/{id}")
    public ResponseEntity<Object> getMahasiswaId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(mahasiswaService.getIdMahasiswa(id), HttpStatus.OK);
    }

    @RequestMapping(value="/mahasiswaapi/{id}", method=RequestMethod.DELETE)
        public ResponseEntity<Object> deleteMahasiswa(@PathVariable("id") Integer id) {
        mahasiswaService.hapus(id);
        return new ResponseEntity<>("Mahasiswa is deleted successsfully",
        HttpStatus.OK);
    }

    @RequestMapping(value = "/mahasiswaapi", method=RequestMethod.POST)
    public ResponseEntity<Object> saveOrUpdateMahasiswa(Model model, Mahasiswa mahasiswa) {
        mahasiswaService.saveOrUpdate(mahasiswa);
        return new ResponseEntity<>("Mahasiswa is created successsfully",
        HttpStatus.OK);
    }

    
    
}