package ru.kpfu.icmit.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.icmit.testing.model.soap.model.Envelope;

@Controller
public class EnvelopeController {

    @RequestMapping(value = "/addnomenclature", method = RequestMethod.POST)
    @ResponseBody
    public Envelope addNomenclature(@RequestBody Envelope envelope) {

        System.out.println("envelope" + envelope);

        if (envelope != null) {
            System.out.println(envelope.getBody().getContent());
        }
        return envelope;
    }


}