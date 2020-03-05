package ru.kpfu.icmit.server4.model.soap;

import ru.kpfu.icmit.server4.model.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class Body {
    private Content content;

    @XmlElements({
            @XmlElement(name = "nomenclature", type = Nomenclature.class),
            @XmlElement(name = "nomenclatures", type = NomenclatureList.class),
            @XmlElement(name = "items", type = XmlList.class),
            @XmlElement(name = "contract", type = Contract.class),
           @XmlElement(name = "offer", type = Offer.class),
            @XmlElement(name = "organization", type = Organization.class)    })
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Body{" +
                "content=" + content +
                '}';
    }
}
