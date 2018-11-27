package airlinegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class test extends Application{

	Button button;
	Stage window;
	Scene scene1,scene2;
	
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		primaryStage.setTitle("Window Title");
		
		button = new Button("click");
		
		button.setOnAction(event -> {System.out.println("clicked");});
		
		Button buttonSwitch = new Button("Switch scenes");
		
		buttonSwitch.setOnAction(e -> window.setScene(scene2));
		
		Label label1 = new Label("This is a label");
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1,buttonSwitch);
		scene1 = new Scene(layout1, 500, 500);
		
		Button button2 = new Button("switch back");
		button2.setOnAction(e -> window.setScene(scene1));
		
		Button button3 = new Button("Alert");
		button3.setOnAction(e -> AlertBox.display("AlertTitle", "This is an Alert."));
		
		VBox layout2 = new VBox(20);
		layout2.getChildren().add(button2);
		layout2.getChildren().add(button3);
		scene2 = new Scene(layout2,600,300);
		
		window.setScene(scene1);
		window.show();
		
	}

}
