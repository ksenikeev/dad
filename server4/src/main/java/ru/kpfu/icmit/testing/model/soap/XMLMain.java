package ru.kpfu.icmit.testing.model.soap;

import ru.kpfu.icmit.testing.model.soap.model.Body;
import ru.kpfu.icmit.testing.model.soap.model.Envelope;
import ru.kpfu.icmit.testing.model.soap.model.Header;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class XMLMain {

    public static void main(String[] args) {

        //createEnveope();

        Envelope envelope = readEnvelope();
        System.out.println(envelope);
    }

    public static void createEnveope() {

        Envelope envelope = new Envelope();
        Header header = new Header();
        Body body = new Body();
        envelope.setHeader(header);
        envelope.setBody(body);

        Nomenclature nomenclature = new Nomenclature("Холодильник", new Date(), new Date());

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
