package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {


	private void initUI(Stage stage) {

		
		String src = "data.txt";

		DataClass data = new DataClass(src);
		
		var root = new Pane();
		var btn1 = new Button("btn");
		var canvas = new Canvas(500,500);
		var gc = canvas.getGraphicsContext2D();

		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				data.setSrc("data.txt");
				drawRectsFromArr(gc, data.getIntegerData(), data.getStringData());
			}
		};
		btn1.setOnAction(event);
		
		root.getChildren().add(canvas);
		root.getChildren().add(btn1);
		
		var scene = new Scene(root, 300, 250, Color.WHITESMOKE);
		
		stage.setTitle("Lines");
		stage.setScene(scene);
		stage.show();
	}

	private void drawLines(GraphicsContext gc) {
		gc.beginPath();

		gc.moveTo(499, 0);
		gc.lineTo(499, 250);

		gc.moveTo(300, 0);
		gc.lineTo(300, 250);

		gc.moveTo(335, 0);
		gc.lineTo(335, 250);
		gc.setFill(Color.RED);

		gc.stroke();
	}

	private void drawRectsFromArr(GraphicsContext gc, Integer[] arr, String[] str_arr) {
		
		gc.beginPath();
		
		gc.clearRect(0, 0, 800, 600);
		final int SPACE_WIDTH = 5;

		int xPos = 5;
		int spaces = arr.length + 2;
		double width = 300 / (arr.length + 1);
		width -= SPACE_WIDTH;

		for (int i = 0; i < arr.length; i++) {
			int e = arr[i];
			gc.rect(xPos, 400, width, -e * 10); // TODO: check the height for real elements!!

			gc.fillText(str_arr[i], xPos + (width / 4), 415, width / 2);

			xPos += width + SPACE_WIDTH;
		}
		gc.setFill(Color.BLACK);

		gc.stroke();

	}


	@Override
	public void start(Stage stage) {
		initUI(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}
