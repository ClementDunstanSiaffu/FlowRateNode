/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.waterflowapi.waterflowapi;

/**
 *
 * @author clement
 */

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SwitchRepository extends MongoRepository<SwitchItem,String> {
    SwitchItem findItemById(int id);
    
}
