package icmit.dad.laborators.lab5.gui.controllers;

import icmit.dad.laborators.lab5.domain.PhoneType;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DictEditController {

    @FXML
    TextField tfId;

    @FXML
    TextField tfName;

    public void setValue(PhoneType p){
        tfId.setText(String.valueOf(p.getId()));
        tfName.setText(p.getName());
    }


}
