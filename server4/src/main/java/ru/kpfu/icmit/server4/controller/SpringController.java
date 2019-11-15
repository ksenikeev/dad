package ru.kpfu.icmit.server4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.icmit.server4.model.Nomenclature;
import ru.kpfu.icmit.server4.service.NomenclatureService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "/addnomenclature", method = RequestMethod.GET)
    public String addNomenclature(@ModelAttribute("model") ModelMap model) {

        return "/dict/addnomenclature";
    }

    @RequestMapping(value = "/addnewnom", method = RequestMethod.POST)
    public String addNewNom(
            @ModelAttribute("model") ModelMap model,
            @ModelAttribute Nomenclature body
                            ) {
        System.out.println(body.getName());
        String name = body.getName();

        model.put("nomname", name != null ? name : "no name");


        // отправить  в Ц БД
        // получить ответ
        // добавить в Л БД


        System.out.println(name);

        return "/dict/nomsuccess";
    }

    public class NomenclatureForm {
        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}