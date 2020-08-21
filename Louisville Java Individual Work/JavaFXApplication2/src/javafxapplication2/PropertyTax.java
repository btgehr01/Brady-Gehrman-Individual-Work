/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Brady Gehrman
 */
public class PropertyTax extends Application {
    
    private TextField input;
    private Text assessmentValue;
    private Text propertyTax;
    
    @Override
    public void start(Stage primaryStage) {
    	
    	Font font = new Font(16); //create a font object
        GridPane grid = new GridPane(); //create a new grid plane to layout elements nicely
        
        Label nextToInputLabel = new Label("Enter Your Property Value:"); //textbox label
        nextToInputLabel.setFont(font);
        
        input = new TextField(); //create a new text field so the user can type in their property value
        input.setFont(font);
        
        Button getAssessmentValueButton = new Button("Get Assessment Value"); //get assessment value btn
        getAssessmentValueButton.setOnAction(this::processAssessmentButtonPress); //when clicked the program will flow to this function
        getAssessmentValueButton.setFont(font);
        
        Button getTax = new Button("Get Property Tax"); //get property tax button
        getTax.setOnAction(this::processTaxButtonPress); //action the program will take when the button has been clicked
        getTax.setFont(font);
        
        Label assessmentLabel = new Label("Assessment Value:"); //will display assessment value next to this label
        assessmentLabel.setFont(font);
        
        assessmentValue = new Text(""); //assessment value text box
        
        Label taxLabel = new Label("Property Tax:"); //will display property tax next to this
        taxLabel.setFont(font);
        
        propertyTax = new Text(""); //property tax text box
        
        grid.setMinSize(600, 600);
        
        grid.setVgap(10); //set vertical gap between elements
        grid.setHgap(20); //set horizontal gap between elements
        
        grid.setAlignment(Pos.CENTER); //center the grid
        
        grid.add(nextToInputLabel, 0, 0); //top left is the input label
        grid.add(input, 1, 0); //top right is the text field
        grid.add(getAssessmentValueButton, 0, 1); //this is the get assessment button
        grid.add(getTax, 1, 1); //next to the get assessment button is the get tax button
        grid.add(assessmentLabel, 0, 2); //left is the assessment label
        grid.add(assessmentValue, 1	, 2); //to the right of the label is the text box for the actual assessment value
        grid.add(taxLabel, 0, 3); //left is the tax calculation label
        grid.add(propertyTax, 1, 3); //to the right of the label will be the tax calculation
        
        
        Scene scene = new Scene(grid, 600, 600); //put the grid into a scene object
        
        primaryStage.setTitle("Property Calculations");
        primaryStage.setScene(scene);
        primaryStage.show(); //show the scene
    
}
    public static void main(String[] args) {
        launch(args); //launches the javafx program
    }
    

    
    
    public void processAssessmentButtonPress(ActionEvent event){
        String propertyValueString = input.getText(); //get the text from the text field
        double propertyValue = Double.parseDouble(propertyValueString); //convert the input to a double
        double assessmentValueDouble = propertyValue * 0.6; //calculate the assessment value
        NumberFormat format = NumberFormat.getCurrencyInstance(); 
        assessmentValue.setText(format.format(assessmentValueDouble)); //set the assessment value to what the calculation concluded
    }
    
    public void processTaxButtonPress(ActionEvent event){
    	String propertyValueString = input.getText(); //get the text from the text field
        double propertyValue = Double.parseDouble(propertyValueString); //convert input to a double
        double propertyTaxValueDouble = ((propertyValue * 0.6) / 100) * 0.64; //calculate tax
        NumberFormat format = NumberFormat.getCurrencyInstance();
        propertyTax.setText(format.format(propertyTaxValueDouble)); //set property tax to what the calculation concluded
    }	
    

}
