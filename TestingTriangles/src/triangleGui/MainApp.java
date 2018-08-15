package triangleGui;
	

import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import model.TriangleService;

public class MainApp extends Application {
	
	private TriangleService service = new TriangleService();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	 @Override
	  public void start(Stage stage) {
	    Scene scene = new Scene(new Group(), 700, 250);
	    

	    //inputfields
	    TextField inputATextField = new TextField ();
	    TextField inputBTextField = new TextField ();
	    TextField inputCTextField = new TextField ();
	    
	    //result label
	    Label result = new Label("");
	    
	    //execute button and clear fields button
	    Button btnCheck = new Button("Check inputs");
	    Button btnClear = new Button("Clear fields");
	    
	    GridPane grid = new GridPane();
	    grid.setVgap(4);
	    grid.setHgap(10);
	    grid.setPadding(new Insets(5, 5, 5, 5));
	    
	    //add textfields and labels
	    grid.add(new Label("Input A: "), 0, 0);
	    grid.add(inputATextField, 1, 0);
	    
	    grid.add(new Label("Input B: "), 2, 0);
	    grid.add(inputBTextField, 3, 0);
	    
	    grid.add(new Label("Input C: "), 4, 0);
	    grid.add(inputCTextField, 5, 0);
	    
	    grid.add(result, 0, 2, 2, 2);
	    
	    //add buttons to grid
	    grid.add(btnCheck, 0, 1);
	    grid.add(btnClear, 1, 1);
	    
	    //set button action
	    btnCheck.setOnAction(e -> {
	    	
	    	
	    	try {
	    		
	    		Integer inputA = Integer.valueOf(inputATextField.getText());
		    	Integer inputB = Integer.valueOf(inputBTextField.getText());
		    	Integer inputC = Integer.valueOf(inputCTextField.getText());
		    	
	    		result.setText(service.checkState(
	    				addInputsToList(inputA, inputB, inputC)).toString());	
	    	}
	    	
	    	catch (IllegalArgumentException error) {
	    		
	    		result.setText("Error: "+error.getMessage());
	    		
	    		return;
	    	} 
	    	
	    });
	    
	    btnClear.setOnAction(e -> {
	    	inputATextField.clear();
	    	inputBTextField.clear();
	    	inputCTextField.clear();
	    });
	    
//	    grid.setGridLinesVisible(true);
	    
	    Group root = (Group) scene.getRoot();
	    root.getChildren().add(grid);
	    stage.setScene(scene);
	    stage.setTitle("Testing Triangles");
	    stage.show();
	  }
	 
	 //method for addin inputs to a list so it can be used with the triangleService class
	 private List<Integer> addInputsToList(int a, int b, int c) {
		 
		 List<Integer> inputDimensions = new ArrayList<>(3);
		 inputDimensions.add(a);
		 inputDimensions.add(b);
		 inputDimensions.add(c);
		 
		 return inputDimensions;
	 }
	 
}
