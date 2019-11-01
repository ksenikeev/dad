package ru.kpfu.icmit.server4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.icmit.server4.model.soap.Nomenclature;
import ru.kpfu.icmit.server4.service.NomenclatureService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SpringController {


    @Autowired
    private NomenclatureService nomenclatureService;

    @RequestMapping(value = "/nomenclature", method = RequestMethod.GET)
    public String getNomenclatureList(@ModelAttribute("model") ModelMap model) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SXXX").parse("2019-01-01T00:00:00.0+03:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Nomenclature> nomenclatures = nomenclatureService.getNomenclature(date);

        model.addAttribute("reqdate", "2019-01-01T00:00:00.0+03:00");
        model.addAttribute("nomenclatures", nomenclatures);

        System.out.println("nomenclatures" + nomenclatures);

        return "/dict/nomenclature";
    }

}