package it.polito.tdp.alien;

import it.polito.tdp.traduzione.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtParole;

	private Dizionario model;

    @FXML
    void handleClear(ActionEvent event) {
    	txtArea.setText("");
    	txtParole.setText("");

    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String input= txtParole.getText();
    	input.toLowerCase();
    	
    	if(input.matches("[a-z]")){
    	if(input.contains(" ")) {
    	 	String [] parole= input.split(" ");
        	String alieno=parole[0];
        	String italiano=parole[1];
        	if(model.esisteGia(alieno)==false) {
        		model.addNuovaTraduzione(alieno, italiano);
        		txtArea.setText("");
            	txtParole.setText("");
        	}
        	else {
        		model.addTraduzione(alieno, italiano);
        	txtArea.setText("");
        	txtParole.setText("");
        	}
    	}
    	else {
    		
    		if(model.esisteGia(input)==true) {
    			txtArea.setText(model.getTraduzioni(input));
    			
    		}
    	}
    	}
    	else {
    		txtArea.setText("ERRORE: INSERIRE SOLO LETTERE");
    	}
    }

	public void setModel(Dizionario model) {
		this.model=model;
	}
	   

}

