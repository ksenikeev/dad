package ru.kpfu.icmit.server4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.icmit.server4.model.Nomenclature;
import ru.kpfu.icmit.server4.service.NomenclatureService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SpringController {


    @Autowired
    private NomenclatureService nomenclatureService;

    @RequestMapping(value = "/nomenclature")
    public String getNomenclatureList(@RequestParam(required = false) String dateFrom,
                                      @ModelAttribute("model") ModelMap model) {

        if (dateFrom == null || dateFrom.length() == 0) {
            dateFrom = "2019-01-01T00:00:00.0+03:00";
        }

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SXXX").parse(dateFrom);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Nomenclature> nomenclatures = nomenclatureService.getNomenclature(date);

        model.addAttribute("reqdate", dateFrom);
        model.addAttribute("nomenclatures", nomenclatures);

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

    @RequestMapping(value = "/pagenomenclature")
    public String getNomenclatureList(@RequestParam(required = false, defaultValue = "0") int from,
                                      @RequestParam(required = false, defaultValue = "100") int to,
                                      @ModelAttribute("model") ModelMap model) {

        System.out.println();

        List<Nomenclature> nomenclatures = nomenclatureService.getNomenclatureFromTo(from, to);

        model.addAttribute("reqdate", "");
        model.addAttribute("nomenclatures", nomenclatures);

        return "/dict/nomenclature";
    }

}