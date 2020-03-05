package ru.kpfu.icmit.client4;

import ru.kpfu.icmit.server4.model.Nomenclature;
import ru.kpfu.icmit.server4.model.soap.Body;
import ru.kpfu.icmit.server4.model.soap.Envelope;
import ru.kpfu.icmit.server4.model.soap.Header;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class SOAPMain {

    public static void main(String[] args) {

        createEnveope();

        //Envelope envelope = readEnvelope();
        //System.out.println(envelope);
        SOAPSender sender = new SOAPSender();

        List<Nomenclature> lst = sender.getNomenclatures();
        lst.forEach(System.out::println);
    }

    public static void createEnveope() {

        Envelope envelope = new Envelope();
        Header header = new Header();
        Body body = new Body();
        envelope.setHeader(header);
        envelope.setBody(body);

        Nomenclature nomenclature = new Nomenclature("Ж/Д вагон", null, null);

        body.setContent(nomenclature);

        try {
            JAXBContext context = JAXBContext.newInstance(Envelope.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(envelope, new File("envelope.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Envelope readEnvelope() {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Envelope) un.unmarshal(new File("envelope.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
   }
}
