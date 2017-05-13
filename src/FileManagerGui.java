import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import  javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.text.Font;



/**
 * Created by mostafa7azem on 12/05/17.
 */
public class FileManagerGui extends GridPane {
public FileManagerGui(){
    setRow(this);
    setCol(this);
    VBox hb= new VBox();
    Label l=new Label("File Manager");
    l.setFont(new Font("Ariel",24));
    ListView lv =new ListView();
    lv.getItems().addAll("List Files","change permissons","make/delete directiories","create symbolic Link");
    lv.setMaxHeight(200);
    Button b =new Button("choose");
    Label status=new Label();

    b.setOnMouseClicked(e->{
    String msg= (String) lv.getSelectionModel().getSelectedItem();
    if(msg==null){
        status.setText("plz choose an option");
    }
    });
    hb.getChildren().addAll(lv,status,b);
    this.setConstraints(hb,0,1);
    this.setConstraints(l, 0, 0);
    this.getChildren().addAll(l,hb);

}
    private void setCol(GridPane gridPane)
    {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(30);
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(80);
        gridPane.getColumnConstraints().addAll(columnConstraints,columnConstraints1);

    }
    private void setRow(GridPane gridPane)
    {
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(20);
        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setPercentHeight(80);
        gridPane.getRowConstraints().addAll(rowConstraints,rowConstraints1);
    }
}
