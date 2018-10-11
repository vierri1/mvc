package ru.innopolis.stc13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc13.pojo.Manufacturer;
import ru.innopolis.stc13.pojo.Mobile;
import ru.innopolis.stc13.service.ManufacturerService;
import ru.innopolis.stc13.service.MobileService;

@Controller
@RequestMapping(value = "/admin**")
public class AdminController {
    @Autowired
    private MobileService mobileService;
    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/addMobile", method = RequestMethod.POST)
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
    @RequestMapping(value = "/addMobile/{id}", method = RequestMethod.GET)
    public String addMobilePage(@PathVariable int id, Model model){
        model.addAttribute("id", id);
        return "addMobile";
    }
}
