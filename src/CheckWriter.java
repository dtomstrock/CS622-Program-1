/** CheckWriter Class */

/** EDIT HISTORY
 * 2/17/17: Class created
 * 2/18/17: Class tested - minor changes made to delete redundant code
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckWriter extends Application {
	
	public static Color[] rectColors = {Color.AZURE, Color.LIGHTCYAN, Color.PLUM};
	static int currentColorIndex = 0;
	Rectangle rect = new Rectangle();


	public static void main(String[] args) {
		
		Application.launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("My Cool Window");
		
		Group root = new Group();
		Scene scene = new Scene(root, 400, 600);
		
		buildRectangle(root);
		buildButton(root, rect);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void buildRectangle(Group argRoot){
		rect.setX(50);
		rect.setY(50);
		rect.setWidth(100);
		rect.setHeight(50);
		rect.setFill(Color.CHARTREUSE);
		
		argRoot.getChildren().add(rect);
	}
	
	private  void buildButton(Group argRoot, Rectangle argRect) {
		Button colorButton = new Button();
		colorButton.setLayoutX(200);
		colorButton.setLayoutY(300);
		colorButton.setText("CB");
		colorButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				currentColorIndex++;
				if(currentColorIndex >= rectColors.length)
					currentColorIndex = 0;
				scrollThroughArray(currentColorIndex, rect);
				System.out.println(currentColorIndex);
			}
		});
		argRoot.getChildren().add(colorButton);
	}
	
	private void scrollThroughArray(int argIndex, Rectangle argRect) {
		argRect.setFill(rectColors[argIndex]);
	}
	
}
