import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;



/**
 * Created by mostafa7azem on 12/05/17.
 */
public class FileManagerGui extends GridPane {
private int x=0;
    public FileManagerGui(){
    setRow(this);
    setCol(this);
    VBox hb= new VBox();
    Label l=new Label("File Manager");
    l.setFont(new Font("Ariel",24));

    ListView lv =new ListView();
    lv.getItems().addAll("List Files","change permissons","create symbolic Link");
    lv.setMaxHeight(200);
    Label status=new Label();

    lv.setOnMouseClicked((e) ->{
    String msg= (String) lv.getSelectionModel().getSelectedItem();
    if(msg!=null && this.x==0){
        BorderPane borderpane = new BorderPane();
        this.setConstraints(borderpane,1,1);
        HBox hBox = new HBox();
        Label path =new Label("path : ");
        TextField textField = new TextField ();
        textField.setMinWidth(500);
        hBox.getChildren().addAll(path,textField);
        borderpane.setTop(hBox);
        this.x++;
        this.getChildren().add(borderpane);
    }else{
        status.setText("plz choose an option or fill path");
    }
    });
    Button submit =new Button("start");
    hb.getChildren().addAll(lv,status,submit);

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



