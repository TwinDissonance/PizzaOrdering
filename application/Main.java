package application;
	
import javafx.application.Application;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Main extends Application {
	
	private int CurrentScene = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Pizza Ordering System");
			changeScene(primaryStage);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void changeScene(Stage s){
		s.hide();
		Scene scene;
		if(CurrentScene == 1)
			scene = loadScene1(s);
		else
			scene = loadScene0(s);
		s.setScene(scene);
		s.show();
	}
	//Scene 0 variables
	private Button loadData = new Button("Select Database");
	private Button Scene1_Button = new Button("Next Step");
	private File data; //Will be in the form of a .csv file
	private Text Message = new Text();
	private ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	
	//Scene for loading Customer Database
	private Scene loadScene0(Stage s){
		Message.setText("");
		loadData.setOnAction(e -> {
			data = new FileChooser().showOpenDialog(s);
			loadDatabase();
		});
		Scene1_Button.setOnAction(e -> {
			CurrentScene = 1;
			changeScene(s);
		});
		BorderPane root = new BorderPane();
		root.setCenter(loadData);
		root.setRight(Scene1_Button);
		root.setBottom(Message);
		return new Scene(root, 200, 200);
	}
	
	
	//Loads the customer database into the CustomerList ArrayList
	private void loadDatabase(){
		try {
			Scanner fileInput = new Scanner(data);
			while(fileInput.hasNextLine()){
				CustomerList.add(new Customer(fileInput.nextLine()));
			}
			Message.setText("Customer Database loaded.");
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
			Message.setText("Invalid File Selected");
		}
	}
	
	//Unimplemented right now, will change scene to New/Old Customer scene
	private Scene loadScene1(Stage s){
		Message.setText("");
		Pane p = new Pane();
		return new Scene(p, 100, 100);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
