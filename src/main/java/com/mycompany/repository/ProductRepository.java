/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.entities.MatHang;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hophu
 */
public interface ProductRepository extends JpaRepository<MatHang, String>{
    
}