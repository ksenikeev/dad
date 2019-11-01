package ru.kpfu.icmit.server4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.icmit.server4.model.soap.Nomenclature;
import ru.kpfu.icmit.server4.model.soap.NomenclatureList;
import ru.kpfu.icmit.server4.model.soap.model.Body;
import ru.kpfu.icmit.server4.model.soap.model.Envelope;
import ru.kpfu.icmit.server4.repository.NomenclatureRepository;
import ru.kpfu.icmit.server4.service.NomenclatureService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class EnvelopeController {

    @Autowired
    private NomenclatureService nomenclatureService;

    @RequestMapping(value = "/addnomenclature", method = RequestMethod.POST)
    @ResponseBody
    public Envelope addNomenclature(@RequestBody Envelope envelope) {

        System.out.println("envelope" + envelope);

        if (envelope != null) {
            System.out.println(envelope.getBody().getContent());
        }
        return envelope;
    }

    @RequestMapping(value = "/getnomenclature", method = RequestMethod.POST)
    @ResponseBody
    public Envelope addNomenclature(@RequestParam(name = "datefrom") String datefrom) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2019-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Nomenclature> nomenclatures = nomenclatureService.getNomenclature(date);

        System.out.println("nomenclatures" + nomenclatures);

        Envelope envelope = new Envelope();
        Body body = new Body();

        NomenclatureList nomenclatureList = new NomenclatureList(nomenclatures);
        body.setContent(nomenclatureList);
        envelope.setBody(body);

        return envelope;
    }

}