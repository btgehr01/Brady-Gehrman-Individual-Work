/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Brady Gehrman
 */
public class CoinJarPane extends HBox{
    private RadioButton quartersB, dimesB, nickelsB, penniesB;
    private TextField input;
    private Text txtQuarters, txtDimes, txtNickels, txtPennies, valueOutput;
    
    
    public CoinJarPane(){
        
        Font font = new Font(16);
        
        ToggleGroup group = new ToggleGroup();
        //group for the radio buttons
        quartersB = new RadioButton("Quarters");
        quartersB.setSelected(true);
        //this one is selcted as the program is 
        quartersB.setToggleGroup(group);
        quartersB.setOnAction(this::processRadioButton);
        
        dimesB = new RadioButton("Dimes");
        dimesB.setToggleGroup(group);
        dimesB.setOnAction(this::processRadioButton);
        
        nickelsB = new RadioButton("Nickels");
        nickelsB.setToggleGroup(group);
        nickelsB.setOnAction(this::processRadioButton);
        
        penniesB = new RadioButton("Pennies");
        penniesB.setToggleGroup(group);
        penniesB.setOnAction(this::processRadioButton);
        
        VBox radioButtons = new VBox(quartersB, dimesB, nickelsB, penniesB);
        radioButtons.setAlignment(Pos.CENTER_LEFT);
        radioButtons.setSpacing(10);
        //allign the radio buttons vertically
        txtQuarters = new Text();
        txtDimes = new Text();
        txtNickels = new Text();
        txtPennies = new Text();
        //set all quanity text object text's to "0"
        txtQuarters.setText("0");
        txtDimes.setText("0");
        txtNickels.setText("0");
        txtPennies.setText("0");
        
        VBox RadioButtonValues = new VBox(txtQuarters, txtDimes, txtNickels, txtPennies);
        RadioButtonValues.setAlignment(Pos.CENTER_LEFT);
        RadioButtonValues.setSpacing(10);
        //allign the objects vertically
        
        input = new TextField();
        input.setFont(font);
        input.setText("0");
        input.setOnAction(this::processRadioButton);
        
        Button getValueButton = new Button("Total Value in Dollar");
        getValueButton.setOnAction(this::processValueButton);
        
        valueOutput = new Text();
        valueOutput.setText("Total: ");
        //align these objects vertically too
        VBox valueVbox = new VBox(input, getValueButton, valueOutput);
        valueVbox.setSpacing(10);
        valueVbox.setAlignment(Pos.CENTER);
        
        setSpacing(20);
        getChildren().addAll(radioButtons, RadioButtonValues, valueVbox);
        //add these object to HBox which this class extends/creates 
    }
    //method that the program flows to when the user hits the enter key or a radio button
    public void processRadioButton(ActionEvent event){
        String inputToSet = input.getText();
        if(quartersB.isSelected()){
            txtQuarters.setText(inputToSet);
            input.setText("0");
        }else if(dimesB.isSelected()){
            txtDimes.setText(inputToSet);
            input.setText("0");
        }else if(nickelsB.isSelected()){
            txtNickels.setText(inputToSet);
            input.setText("0");
        }else{
            txtPennies.setText(inputToSet);
            input.setText("0");
        }
        //gets input from text field and then displays it in the respective text object next to whatever radio button is selected
    }
    
    public void processValueButton(ActionEvent event){
        //get the values from each of the four text quanity objects
        int quarters = Integer.parseInt(txtQuarters.getText());
        int dimes = Integer.parseInt(txtDimes.getText());
        int nickels = Integer.parseInt(txtNickels.getText());
        int pennies = Integer.parseInt(txtPennies.getText());
        CoinsJar coinJar = new CoinsJar(quarters, dimes, nickels, pennies);
        //create a coinJar object
        String amount = coinJar.getAmount();
        valueOutput.setText("Total: " + amount);
        //display the amount in the coinsJar object onto the screen
    }
    
}
