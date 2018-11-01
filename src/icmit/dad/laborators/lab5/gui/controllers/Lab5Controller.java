package icmit.dad.laborators.lab5.gui.controllers;

import icmit.dad.laborators.lab5.domain.PhoneType;
import icmit.dad.laborators.lab5.gui.models.Lab5Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Класс-контроллер, предназначенный для взаимодействия с элементами макета
 */
public class Lab5Controller {

    private Lab5Model model;

    @FXML
    TableView<PhoneType> tableDict;

    public Lab5Controller(){
        model = new Lab5Model();
    }

    @FXML
    public void initialize(){
        TableColumn<PhoneType,String> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<PhoneType,String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        ObservableList<PhoneType> list = FXCollections.observableArrayList(model.getPhoneType());
        tableDict.setItems(list);
        tableDict.getColumns().addAll(column1,column2);
    }

    @FXML
    public void showInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("О программе ...");
        alert.setContentText("Программа демонстрирует стандартные диалоговые окна");
        alert.show();
    }

    @FXML
    public void showDict(){
        PhoneType p = tableDict.getSelectionModel().getSelectedItem();
        long i=tableDict.getSelectionModel().getSelectedIndex();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Lab5Controller.class.getResource("/icmit/dad/laborators/lab5/gui/views/lab5editdict.fxml"));
            AnchorPane pane = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setWidth(250);
            dialogStage.setHeight(200);
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(mainApp.primaryStage);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);

            DictEditController controller = loader.getController();
            controller.setValue(p);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
