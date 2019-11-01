package ru.kpfu.icmit.server4.model.soap;

import ru.kpfu.icmit.server4.model.soap.model.Content;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NomenclatureList extends Content {

    @XmlElementWrapper(name = "nomenclatures")
    @XmlElement(name = "nomenclature")
    private List<Nomenclature> nomenclatureList;

    public NomenclatureList(List<Nomenclature> nomenclatures) {
        nomenclatureList = nomenclatures;
    }

    public NomenclatureList() {
    }

    public List<Nomenclature> getNomenclatureList() {
        return nomenclatureList;
    }

    public void setNomenclatureList(List<Nomenclature> nomenclatureList) {
        this.nomenclatureList = nomenclatureList;
    }
}
