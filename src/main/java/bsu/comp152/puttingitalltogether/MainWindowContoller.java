package bsu.comp152.puttingitalltogether;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowContoller implements Initializable {
    private DataModel dataModel;
    @FXML
    private ListView<DataModel.UniversityData> displayList;

    @FXML
    protected void quitButtonClick() {
        System.exit(0);
    }

    public void loadData(){
        String searchTerm = getQueryParams();
        var dataURI = dataModel.API_LOC + searchTerm;
        dataModel = new DataModel(dataURI);
        var data = dataModel.getData();
        ObservableList<DataModel.UniversityData> list = FXCollections.observableArrayList(data);
        displayList.setItems(list);
        displayList.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DataModel.UniversityData>() {
                    @Override
                    public void changed(ObservableValue<? extends DataModel.UniversityData> observableValue,
                                        DataModel.UniversityData oldselection,
                                        DataModel.UniversityData newselection) {
                        var moreInfo = new Alert(Alert.AlertType.INFORMATION);
                        moreInfo.setTitle("Information for "+newselection.getName());
                        moreInfo.setHeaderText(newselection.getCountry() + " "+ newselection.getAlphaTwoCode());
                        moreInfo.setContentText("First Web Page: "+newselection.getFirstWebPage());
                        moreInfo.showAndWait();
                    }
                }
        );
    }

    private String getQueryParams() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("University Search");
        dialog.setHeaderText("Enter University Search Term:");
        dialog.setContentText("Search Term:");
        var result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }else {
            return "No where";
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
}
