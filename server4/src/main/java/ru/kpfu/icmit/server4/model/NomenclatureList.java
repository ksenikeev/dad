package ru.kpfu.icmit.server4.model;

import ru.kpfu.icmit.server4.model.soap.Content;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class NomenclatureList extends Content {

    private List<Nomenclature> nomenclatureList;

    public NomenclatureList(List<Nomenclature> nomenclatures) {
        nomenclatureList = nomenclatures;
    }

    public NomenclatureList() {
    }

    @XmlElementWrapper(name = "nomenclatures")
    @XmlElement(name = "nomenclature")
    public List<Nomenclature> getNomenclatureList() {
        return nomenclatureList;
    }

    public void setNomenclatureList(List<Nomenclature> nomenclatureList) {
        this.nomenclatureList = nomenclatureList;
    }
}
