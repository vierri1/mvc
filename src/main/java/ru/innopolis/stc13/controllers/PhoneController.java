package ru.innopolis.stc13.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc13.pojo.Manufacturer;
import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.service.ManufacturerService;
import ru.innopolis.stc13.service.MobileService;

@Controller
public class PhoneController {

    private MobileService mobileService;
    private ManufacturerService manufacturerService;

    @Autowired
    public void setService(MobileService service) {
        this.mobileService = service;
    }

    @Autowired
    public void setManufacturerService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping("/manufacturers")
    public String getAllManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAll());
        return "manufacturers";
    }

    @RequestMapping("/manufacturer/{id}")
    public String getManufacturerMobiles(@PathVariable int id, Model model) {
        model.addAttribute("mobiles", mobileService.getAllWithManufacturers(id));
        model.addAttribute("manId", id);
        return "mobiles";
    }

}
