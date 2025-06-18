package demomavinfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Database extends Application {

    TableView<Student> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        Text nameText = new Text("Name: Niraj bhandari");
        Text idText = new Text("Student ID: 23093760");
        Text dateText = new Text("Date: June 18, 2025");

        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Student, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(idCol, nameCol, ageCol, emailCol);

        // You can add sample data like this:
        tableView.getItems().addAll(
            new Student(1, "Alice", 21, "alice@example.com"),
            new Student(2, "Bob", 22, "bob@example.com"),
            new Student(3, "Charlie", 20, "charlie@example.com")
        );

        VBox vbox = new VBox(10, nameText, idText, dateText, tableView);
        vbox.setPadding(new Insets(15));

        Scene scene = new Scene(vbox, 650, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX TableView Example - Suman Khadayat");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // 👇 Inner Student class
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
}
