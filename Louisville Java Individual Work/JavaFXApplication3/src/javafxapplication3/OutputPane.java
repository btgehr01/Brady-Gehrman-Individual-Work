/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Brady Gehrman
 */
public class OutputPane extends VBox{
    private TextField input;
    private ChoiceBox fontChoice;
    private ColorPicker colorPicker;
    private Text text;
    
    public OutputPane(){
        
        input = new TextField();
        input.setOnAction(this::processPress);
        
        colorPicker = new ColorPicker();
        
        fontChoice = new ChoiceBox<String>();
        for(int i = 1; i < 51; i++){
            fontChoice.getItems().add(i + "");
        }
        fontChoice.getSelectionModel().selectFirst();
        
        Button button = new Button("Change Text");
        button.setOnAction(this::processPress);
        
        HBox options = new HBox(fontChoice, colorPicker, button);
        options.setSpacing(20);
        
        text = new Text("");
        
        setSpacing(20);
        getChildren().addAll(input, options, text);
        
    }
    public void processPress(ActionEvent event){
        String stringInput = input.getText();
        Color selectedColor = colorPicker.getValue();
        int fontChoices = fontChoice.getSelectionModel().getSelectedIndex();
        Font newFont = new Font(fontChoices);
        text.setText(stringInput);
        text.setFill(selectedColor);
        text.setFont(newFont);
    }
    
    }
    

