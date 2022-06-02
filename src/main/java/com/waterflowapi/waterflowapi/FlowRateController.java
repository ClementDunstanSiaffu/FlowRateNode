/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.waterflowapi.waterflowapi;

/**
 *
 * @author clement
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;


@Controller
@RequestMapping("/")

public class FlowRateController {
    
    private FlowRateRepository flowRateRepository;
    
    @Autowired
    FlowRateController(FlowRateRepository flowRateRepository){
        this.flowRateRepository = flowRateRepository;
    }
    
    @CrossOrigin
    @RequestMapping(
            value = "/master/{id}/{flowRate}/{buttonControl}",
            method = RequestMethod.GET
    )
    @ResponseBody
    
    public double getMasterFlowRate(
            @PathVariable double flowRate,
            @PathVariable int id,
            @PathVariable boolean buttonControl
    ){
        FlowRateItems items = flowRateRepository.findItemById(id);
        if (items != null){
            items.setFlowRate(flowRate);
            items.setButtonControl(buttonControl);
            items.setDate(LocalDate.now());
            items.setTime(LocalTime.now());        
            flowRateRepository.save(items);
        }else{
            flowRateRepository.save(
                    new FlowRateItems(
                            id,
                            flowRate,
                            buttonControl,
                            LocalDate.now(),
                            LocalTime.now()
                    ));
        }
        List<FlowRateItems> tempArr;
        double returnedFlowRate = 0;
        tempArr = this.flowRateRepository.findAll();
        
        if (tempArr != null){
            List<FlowRateItems> lists = new ArrayList<FlowRateItems>();
            for (int i =0;i < tempArr.size();i++){
                if (tempArr.get(i).getId() != 1){
                    lists.add(tempArr.get(i));
                }
            }
            
            if(lists != null && lists.size() > 0){
                returnedFlowRate = lists.get(lists.size()-1).getFlowRate();
            }
        }
        return returnedFlowRate;
    }
    
    @CrossOrigin
    @RequestMapping (
            value = "/minor/{id}/{flowRate}/{buttonControl}",
            method = RequestMethod.GET
    )
    @ResponseBody
    
    public String getMinorFlowRate(
            @PathVariable int id,
            @PathVariable double flowRate,
            @PathVariable boolean buttonControl
            
    ){
        FlowRateItems items = flowRateRepository.findItemById(id);
        if(items != null ){
            items.setFlowRate(flowRate);
            items.setButtonControl(buttonControl);
            items.setDate(LocalDate.now());
            items.setTime(LocalTime.now()); 
            flowRateRepository.save(items);
        }else{
             flowRateRepository.save(
                new FlowRateItems(
                        id,
                        flowRate,
                        buttonControl,
                        LocalDate.now(),
                        LocalTime.now()
                ));
        }
       
        return "SUCCESS";
    }
    
    @CrossOrigin
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    
    public List<FlowRateItems> getAllContents(){
        return flowRateRepository.findAll();
    } 
    
    @CrossOrigin
    @RequestMapping(value = "/switch",method = RequestMethod.GET)
    @ResponseBody
            
    public boolean getSwitchStatus (){
        FlowRateItems items = flowRateRepository.findItemById(1);
        return items.getButtonControl();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/set/{switchValue}",method = RequestMethod.GET)
    @ResponseBody
    
    public String setSwitchStatus(
            @PathVariable boolean switchValue
    ){
        FlowRateItems items = flowRateRepository.findItemById(1);
        items.setButtonControl(switchValue);
        flowRateRepository.save(items);
        return "success";
    }
    
}
