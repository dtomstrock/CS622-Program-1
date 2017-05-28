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
	int rectXLocation = 50;
	Group root = new Group();
	Scene scene = new Scene(root, 400, 600);



	public static void main(String[] args) {
		
		Application.launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("My Cool Window");
		
		
		buildRectangle(root);
		buildColorButton(root, rect);
		buildMoveRightButton(root, rect);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void buildRectangle(Group argRoot){
		rect.setX(rectXLocation);
		rect.setY(50);
		rect.setWidth(100);
		rect.setHeight(50);
		rect.setFill(Color.CHARTREUSE);
		
		argRoot.getChildren().add(rect);
	}
	
	private  void buildColorButton(Group argRoot, Rectangle argRect) {
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
	
	private void buildMoveRightButton(Group argRoot, Rectangle argRect){
		Button moveRightButton = new Button();
		moveRightButton.setLayoutX(300);
		moveRightButton.setLayoutY(400);
		moveRightButton.setText("Go Right");
		moveRightButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				rectXLocation += 10;
				rect.setX(rectXLocation);
			}
		});
		argRoot.getChildren().add(moveRightButton);
	}
	
	private void scrollThroughArray(int argIndex, Rectangle argRect) {
		argRect.setFill(rectColors[argIndex]);
	}
	
}
