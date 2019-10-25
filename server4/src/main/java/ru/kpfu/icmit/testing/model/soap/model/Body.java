package ru.kpfu.icmit.testing.model.soap.model;

import ru.kpfu.icmit.testing.model.soap.Nomenclature;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class Body {
    private Content content;

    @XmlElements({
            @XmlElement(name = "nomenclature", type = Nomenclature.class)
    })
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
