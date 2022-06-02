/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.waterflowapi.waterflowapi;

/**
 *
 * @author clement
 */

import org.springframework.data.annotation.Id;

public class SwitchItem {
    
    @Id
    private int id;
    private boolean switchStatus;
    
    SwitchItem(int id,boolean switchStatus){
        this.id = id;
        this.switchStatus = switchStatus;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setSwitchStatus(boolean switchStatus){
        this.switchStatus = switchStatus;
    }
    
    public boolean getSwitchStatus(){
        return this.switchStatus;
    }
    
}
