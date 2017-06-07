package application;
	
import javafx.application.Application;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {
	
	//App variables
	private int CurrentScene = 0;
	private Button Scene2_Button = new Button("Next Step");
	private File data; //Will be in the form of a .csv file
	private Text Message = new Text();
	private Text WindowMessage = new Text();
	private Text WindowMessage2 = new Text();
	private ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Pizza Ordering System");
			Stage Window = new Stage();
			setButtons(primaryStage, Window);
			changeScene(primaryStage);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Changes the scene to CurrentScene
	private void changeScene(Stage s){
		s.hide();
		Message.setText("");
		Scene scene;
		if(CurrentScene == 1)
			scene = loadScene1(s);
		else if(CurrentScene == 2)
			scene = loadScene2(s);
		else if(CurrentScene == 3)
			scene = loadScene3(s);
		else if(CurrentScene == 4)
			scene = loadScene4(s);
		else if(CurrentScene == 5)
			scene = loadScene5(s);
		else
			scene = loadScene0(s);
		s.setScene(scene);
		s.show();
	}
	
	//Gives the buttons their intended functions
	private void setButtons(Stage s, Stage w){
		//Stage 0
		Customer_0.setOnAction(e -> {
			CurrentScene = 2;
			changeScene(s);
		});
		Employee_0.setOnAction(e -> {
			Window1(w);
		});
		Submit_0.setOnAction(e -> {
			//Validity Check, Employee IDs can be changed later
			if(EmployeeID_0.getText().equals("1") || EmployeeID_0.getText().equals("2") || EmployeeID_0.getText().equals("3")){
				Win1 = true;
				WindowMessage.setText("");
				WindowMessage2.setText("");
			}
			else{
				Win1 = false;
				WindowMessage2.setText("Invalid Employee ID");
			}
			if(Win1){
				CurrentScene = 1;
				changeScene(s);
				w.hide();
			}
		});
		//Stage 1
		loadData_1.setOnAction(e -> {
			data = new FileChooser().showOpenDialog(s);
			loadDatabase();
		});
		Scene2_Button.setOnAction(e -> {
			CurrentScene = 2;
			changeScene(s);
		});
	}
	
	//Scene 0 Variables
	private Button Customer_0 = new Button("Customer");
	private Button Employee_0 = new Button("Employee");
	private Button Submit_0 = new Button("Submit");
	private boolean Win1 = false;
	private TextField EmployeeID_0 = new TextField();
	
	//Start of program, Employee/Customer choice
	private Scene loadScene0(Stage s){
		Message.setText("Are you an employee or a customer?");
		BorderPane bp = new BorderPane();
		bp.setTop(Message);
		bp.setLeft(Customer_0);
		bp.setRight(Employee_0);
		return new Scene(bp, 300, 41);
	}
	
	//Window for entering Employee ID
	private void Window1(Stage w){
		WindowMessage.setText("Please enter your Employee ID");
		BorderPane bp = new BorderPane();
		bp.setTop(WindowMessage);
		bp.setCenter(EmployeeID_0);
		VBox vb = new VBox(WindowMessage2, Submit_0);
		bp.setBottom(vb);
		Scene Scene_1 = new Scene(bp);
		w.setScene(Scene_1);
		w.show();
	}
	
	//Scene 1 variables
	private Button loadData_1 = new Button("Select Database");
	
	//Scene for loading Customer Database
	private Scene loadScene1(Stage s){
		BorderPane root = new BorderPane();
		root.setCenter(loadData_1);
		root.setRight(Scene2_Button);
		root.setBottom(Message);
		return new Scene(root, 200, 200);
	}
	
	//Loads the customer database into the CustomerList ArrayList
	private void loadDatabase(){
		try {
			Scanner fileInput = new Scanner(data);
			fileInput.nextLine(); //Skips the metadata line
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
	
	//UNIMPLEMENTED
	private Scene loadScene2(Stage s){
		Pane p = new Pane();
		return new Scene(p);
	}
	
	//UNIMPLEMENTED
	private Scene loadScene3(Stage s){
		Pane p = new Pane();
		return new Scene(p);
	}
	
	//UNIMPLEMENTED
	private Scene loadScene4(Stage s){
		Pane p = new Pane();
		return new Scene(p);
	}
	
	//UNIMPLEMENTED
	private Scene loadScene5(Stage s){
		Pane p = new Pane();
		return new Scene(p);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
