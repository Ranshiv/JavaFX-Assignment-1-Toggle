package com.example.assign1;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;

public class helloController {
    @FXML
    private TableView<Data> tableView;

    @FXML
    private TableColumn<Data, Integer> idColumn;

    @FXML
    private TableColumn<Data, Integer> currentRankColumn;

    @FXML
    private TableColumn<Data, Integer> lastYearRankColumn;

    @FXML
    private TableColumn<Data, String> languageNameColumn;

    @FXML
    private TableColumn<Data, Double> ratingColumn;

    @FXML
    private TableColumn<Data, Double> ratingChangeColumn;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    public void initialize() {
//        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        currentRankColumn.setCellValueFactory(cellData -> cellData.getValue().currentRankProperty().asObject());
        lastYearRankColumn.setCellValueFactory(cellData -> cellData.getValue().lastYearRankProperty().asObject());
        languageNameColumn.setCellValueFactory(cellData -> cellData.getValue().languageNameProperty());
        ratingColumn.setCellValueFactory(cellData -> cellData.getValue().ratingProperty().asObject());
        ratingChangeColumn.setCellValueFactory(cellData -> cellData.getValue().ratingChangeProperty().asObject());

        try {
            System.out.println("Loading The Data");
            loadData();
            System.out.println("Loading the Data in the BarGraph");
            populateBarChart();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws SQLException {
        // Connect to MySQL database
        String url = "jdbc:mysql://localhost:3306/programming_languages";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // Execute query
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM languages");

        // Populate TableView
        while (resultSet.next()) {
            tableView.getItems().add(new Data(resultSet.getInt("id"),
                    resultSet.getInt("current_rank"),
                    resultSet.getInt("last_year_rank"),
                    resultSet.getString("language_name"),
                    resultSet.getDouble("rating"),
                    resultSet.getDouble("rating_change")));
        }

        // Close connection
        connection.close();
    }
    private void populateBarChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Populate the series with data from the TableView
        ObservableList<Data> dataList = tableView.getItems();
        for (Data data : dataList) {
            series.getData().add(new XYChart.Data<>(data.getLanguageName(), data.getRating()));
        }

        barChart.getData().add(series);
//        barChart.getStylesheets().add("./Resources/styles.css");

    }

    @FXML
    private Button toggleButton;

    public void toggleView() {
        boolean isTableViewVisible = tableView.isVisible();
        tableView.setVisible(!isTableViewVisible);
        barChart.setVisible(isTableViewVisible);
    }
}
