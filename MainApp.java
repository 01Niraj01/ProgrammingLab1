package demomavinfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

    private TableView<Student> tableView = new TableView<>();
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    // Database credentials
    private final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    private final String USER = "root";
    private final String PASSWORD = "NJRnir123$"; // Set your MySQL password here if any

    @Override
    public void start(Stage primaryStage) {
        Text nameText = new Text("Name: Niraj Bhandari");
        Text idText = new Text("Student ID: 23093760");
        Text dateText = new Text("Date: June 18, 2025");

        // Define table columns
        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Student, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(idCol, nameCol, ageCol, emailCol);

        // Button to load data
        Button loadButton = new Button("Load Data");
        loadButton.setOnAction(e -> fetchDataFromDatabase());

        VBox vbox = new VBox(10, nameText, idText, dateText, loadButton, tableView);
        vbox.setPadding(new Insets(15));

        Scene scene = new Scene(vbox, 700, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView + MySQL - Suman Khadayat");
        primaryStage.show();
    }

    private void fetchDataFromDatabase() {
        studentList.clear(); // Clear old data

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to MySQL database!");

            String query = "SELECT * FROM students";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                studentList.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("email")
                ));
            }

            tableView.setItems(studentList); // Show data in table

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Student {
        private int id;
        private String name;
        private int age;
        private String email;

        public Student(int id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getEmail() { return email; }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
