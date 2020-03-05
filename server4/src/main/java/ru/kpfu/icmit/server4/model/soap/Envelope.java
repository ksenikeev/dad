package ru.kpfu.icmit.server4.model.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "envelope")
public class Envelope {

    private Header header;

    private Body body;

    @XmlElement(name = "header")
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    @XmlElement(name = "body")
    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
