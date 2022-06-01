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

public class FlowRateItems {
    
    @Id
    private int id;
    private double flowRate;
    private boolean buttonControl;
    
    FlowRateItems(int id,double flowRate,boolean buttonControl){
        this.id = id;
        this.flowRate = flowRate;
        this.buttonControl = buttonControl;
    }
    
    void setId(int id){
        this.id = id;
    }
    
    void setFlowRate(double flowRate){
        this.flowRate = flowRate;
    }
    
    void setButtonControl(boolean buttonControl){
        this.buttonControl = buttonControl;
    }
    
    public int getId(){
        return this.id;
    }
    
    public double getFlowRate(){
        return this.flowRate;
    }
    
    public boolean getButtonControl(){
        return this.buttonControl;
    }
    
}
