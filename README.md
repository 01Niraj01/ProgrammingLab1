JavaFX MySQL TableView Project - Niraj Bhandari

Overview

This JavaFX project demonstrates how to:

- Design a GUI using JavaFX components
- Connect to a MySQL database
- Retrieve data from a table
- Display the data in a JavaFX `TableView` with an interactive button

---
 Section A: Design and GUI (120 Marks)

- Created a new **JavaFX Application Project** using Visual Studio Code.
- Named the project: `NirajBhandari_JavaFXProject`
- Designed the GUI with the following components:
  - A `TableView` to display employee records
  - A `Button` labeled `Load Data` to trigger data retrieval

### Screenshot:
> 📸 Screenshot of GUI layout is saved and includes **name**, **student ID**, and **date**.

---

Section B: Database Connection (180 Marks)

- Implemented the database connection using JDBC with the following credentials:
  - **Database URL:** `jdbc:mysql://localhost:3306/studentdb`
  - **Username:** `yourUsername`
  - **Password:** `yourPassword`
- Used `DriverManager.getConnection()` to establish the connection in the `loadDataFromDatabase()` method.

### Screenshot:
> 📸 Screenshot of the connection code (`DriverManager.getConnection(...)`) is included.

---

Section C: Data Retrieval (240 Marks)

- Created a Java class `Employee` representing the table structure with fields:
  - `id` (Integer)
  - `name` (String)
  - `position` (String)
  - `salary` (Double)
- Wrote SQL query: `SELECT id, name, position, salary FROM Employee`
- Loaded the result into an `ObservableList<Employee>` and displayed it in the `TableView`.
- Used a **button click event handler** (`loadBtn.setOnAction`) to trigger data retrieval.

Screenshot:
> 📸 Screenshot of the data retrieval and `TableView` code is included.

---

Technologies Used

- JavaFX
- Java 11+
- MySQL
- JDBC Driver (MySQL Connector/J)
- Visual Studio Code (or any Java IDE)

---

Notes

- Make sure MySQL server is running and accessible.
- Ensure MySQL JDBC driver is correctly added to the project dependencies.
- Modify credentials in the code as per your database setup.

Note: Since the code wasnot running properly, I have to collect the resources from the AI like chatgpt. I also visited W3schools to get some ideas. I did all the research required to make my code best.
---
Author

Niraj Bhandari
