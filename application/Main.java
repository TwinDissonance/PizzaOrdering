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
import javafx.scene.layout.GridPane;
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
		WindowMessage.setText("");
		WindowMessage2.setText("");
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
				ValidID_0 = true;
				WindowMessage.setText("");
				WindowMessage2.setText("");
			}
			else{
				ValidID_0 = false;
				WindowMessage2.setText("Invalid Employee ID");
			}
			if(ValidID_0){
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
			if(DataEntered){
				CurrentScene = 2;
				changeScene(s);
			}
			else
				Message.setText("No Database Loaded");
		});
		//Stage 2
		NewCustomer_2.setOnAction(e -> {
			Window2(w);
		});
		OldCustomer_2.setOnAction(e -> {
			Window3(w);
		});
		Submit_22.setOnAction(e -> {
			//To Do
		});
		Submit_23.setOnAction(e -> {
			//To Do
		});
	}
	
	//Scene 0 Variables
	private Button Customer_0 = new Button("Customer");
	private Button Employee_0 = new Button("Employee");
	private Button Submit_0 = new Button("Submit");
	private boolean ValidID_0 = false;
	private TextField EmployeeID_0 = new TextField();
	
	//Start of program, Employee/Customer choice
	private Scene loadScene0(Stage s){
		Message.setText("Are you an employee or a customer?");
		BorderPane bp = new BorderPane();
		bp.setTop(Message);
		bp.setLeft(Customer_0); //Leads to Scene 2
		bp.setRight(Employee_0); // Leads to Window 1 and then Scene 1
		return new Scene(bp, 300, 41);
	}
	
	//Window for entering Employee ID
	private void Window1(Stage w){
		WindowMessage.setText("Please enter your Employee ID");
		BorderPane bp = new BorderPane();
		bp.setTop(WindowMessage);
		bp.setCenter(EmployeeID_0);
		VBox vb = new VBox(WindowMessage2, Submit_0); //Submit leads to Scene 1
		bp.setBottom(vb);
		Scene Scene_1 = new Scene(bp);
		w.setScene(Scene_1);
		w.setTitle("Employee Sign In");
		w.show();
	}
	
	//Scene 1 variables
	private Button loadData_1 = new Button("Select Database");
	private boolean DataEntered = false;
	
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
			DataEntered = true;
		} catch (Exception e) {
			e.printStackTrace();
			Message.setText("Invalid File Selected");
		}
	}
	
	//Scene 2 variables
	private Button NewCustomer_2 = new Button("New Customer");
	private Button OldCustomer_2 = new Button("Old Customer");
	private TextField CustomerPhone_2 = new TextField();
	private TextField CustomerName_2 = new TextField();
	private TextField CustomerAddress_2 = new TextField();
	private TextField CustomerAccountType_2 = new TextField();
	private TextField CustomerAddressInfo_2 = new TextField();
	private Button Submit_22 = new Button("Submit");
	private Button Submit_23 = new Button("Submit");
	
	//Scene to choose if Old or New Customer
	private Scene loadScene2(Stage s){
		BorderPane bp = new BorderPane();
		bp.setLeft(NewCustomer_2);
		bp.setRight(OldCustomer_2);
		CustomerPhone_2.setPromptText("Enter your phone number.");
		CustomerName_2.setPromptText("Enter your full name.");
		CustomerAddress_2.setPromptText("Enter your address.");
		CustomerAccountType_2.setPromptText("Enter your Charge Account type (Visa/Mastercard).");
		CustomerAddressInfo_2.setPromptText("Enter any information to help find your address.");
		return new Scene(bp, 200, 200);
	}
	
	
	//New Customer Window
	private void Window2(Stage w){
		WindowMessage.setText("Please enter your customer information.");
		BorderPane bp = new BorderPane();
		bp.setTop(WindowMessage);
		VBox vb = new VBox(CustomerPhone_2, CustomerName_2, CustomerAddress_2, CustomerAccountType_2, CustomerAddressInfo_2);
		bp.setCenter(vb);
		//Text Field Setup
		bp.setBottom(Submit_22);
		Scene Scene_2 = new Scene(bp);
		w.setScene(Scene_2);
		w.show();
	}
	
	//Old Customer Window
	private void Window3(Stage w){
		WindowMessage.setText("Please enter your Phone Number.");
		BorderPane bp = new BorderPane();
		bp.setTop(WindowMessage);
		bp.setCenter(CustomerPhone_2);
		bp.setBottom(Submit_23);
		Scene Scene_2 = new Scene(bp);
		w.setScene(Scene_2);
		w.show();
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
