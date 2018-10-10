package ru.innopolis.stc13.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/addMobile")
    public String addMobile(@RequestParam String name,
                            @RequestParam String price,
                            @RequestParam String id,
                            Model model) {
        int manId = Integer.parseInt(id);
        Float mobPrice = Float.parseFloat(price);
        Manufacturer manufacturer = manufacturerService.get(manId);
        mobileService.add(new Mobile(null, name, mobPrice, manufacturer));
        return "redirect:manufacturer/" + manId;
    }


}
