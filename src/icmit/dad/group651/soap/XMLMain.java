package icmit.dad.group651.soap;

import icmit.dad.group651.soap.model.Body;
import icmit.dad.group651.soap.model.Envelope;
import icmit.dad.group651.soap.model.Header;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class XMLMain {

    public static void main(String[] args) {

        createEnveope();

        //Envelope envelope = readEnvelope();
        //System.out.println(envelope);
        SOAPSender sender = new SOAPSender();

        sender.sendNomenclature(new File("envelope.xml"));
    }

    public static void createEnveope() {

        Envelope envelope = new Envelope();
        Header header = new Header();
        Body body = new Body();
        envelope.setHeader(header);
        envelope.setBody(body);

        Nomenclature nomenclature = new Nomenclature("Холодильник", null, null);

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
