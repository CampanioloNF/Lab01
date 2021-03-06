package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	private Parole model ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtTime;


    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

	
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	
    	if(this.txtParola.getText().trim().equals("") || this.model.isEmpty() ){
		
			this.txtTime.appendText("Seleziona una Parola!\n");
		}
    	
		else{
    	
    	model.elimina(this.txtParola.getText());
    	this.txtParola.clear();
    	
    	String s ="";
    	
    	for(String st : model.getElenco()) {
    		
    		s+=st+"\n";
    	}
        
    	this.txtResult.setText(s);
    	
    	this.txtTime.appendText(System.nanoTime()+"\n");
    	}

    }

    @FXML
    void doInsert(ActionEvent event) {
    	
        model.addParola(this.txtParola.getText());
    	
        this.txtParola.clear();
    	
    	String s ="";
    	
    	for(String st : model.getElenco()) {
    		
    		s+=st+"\n";
    	}
        
    	this.txtResult.setText(s);
    	
    	this.txtTime.appendText(System.nanoTime()+"\n");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	model.reset();
    	this.txtResult.clear();
    	
    	this.txtTime.appendText(System.nanoTime()+"\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

       // model = new Parole() ;
        
    }

	public void setModel(Parole model) {
		this.model=model;
		
	}
}
