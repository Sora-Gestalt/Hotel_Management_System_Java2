package Projects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HotelEngineApp extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			
			Scene scene = new Scene(root,1280,720);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("KSU_HOTELS.png")));
			primaryStage.setTitle("KSI Hotel Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
