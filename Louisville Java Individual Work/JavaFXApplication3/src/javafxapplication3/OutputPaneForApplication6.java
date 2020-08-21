/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author Brady Gehrman
 */
public class OutputPaneForApplication6 extends HBox{
    
    
    private ListView<String> listView;
    private Text quote;
    
    public OutputPaneForApplication6(){
        Font font = new Font(12);
        
        String[] categories = {"Philosophy", "Biology", "Chemisry", "Physics", "Computer Science", "Calculus"};
        
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(categories);
        
        listView = new ListView<String>(list);
        listView.setMinWidth(100);
        listView.setMinHeight(200);
        listView.getSelectionModel().select(0);
        listView.getSelectionModel().selectedItemProperty().addListener(
                this::processListSelection);
        
        quote = new Text("");
        quote.setFont(font);
        quote.setText("Excellence is not a gift");
        
        setSpacing(20);
        getChildren().addAll(listView, quote);
        
    }
    
    public void processListSelection(ObservableValue<? extends String> val, String oldValue, String newValue)
    {
        if(newValue != null && oldValue != null && val != null){
        String[] quotes = new String[6];
        quotes[0] = "Excellence is not a gift";
        quotes[1] = "Biology transends society";
        quotes[2] = "Chemistry is the dirty part of physics";
        quotes[3] = "All science is either physics or stamp collecting";
        quotes[4] = "01001010 01100001 01110110 01100001";
        quotes[5] = "If it seems easy you're doing it wrong";
        int indexSelected = listView.getSelectionModel().getSelectedIndex();
        quote.setText(quotes[indexSelected]);
        }
    }   

}
