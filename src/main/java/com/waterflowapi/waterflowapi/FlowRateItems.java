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
import java.time.LocalDate;
import java.time.LocalTime;

public class FlowRateItems {
    
    @Id
    private int id;
    private double flowRate;
    private LocalDate date;
    private LocalTime time;
    
    FlowRateItems(
            int id,
            double flowRate,
            LocalDate date,
            LocalTime time
    ){
        this.id = id;
        this.flowRate = flowRate;
        this.date = date;
        this.time = time;
    }
    
    void setId(int id){
        this.id = id;
    }
    
    void setFlowRate(double flowRate){
        this.flowRate = flowRate;
    }
       
    void setDate(LocalDate date){
        this.date = date;
    }
    
    void setTime(LocalTime time){
        this.time = time;
    }
    
    public int getId(){
        return this.id;
    }
    
    public double getFlowRate(){
        return this.flowRate;
    }
        
    public LocalDate getDate(){
        return this.date;
    }
    
    public LocalTime getTime(){
        return this.time;
    }
}
