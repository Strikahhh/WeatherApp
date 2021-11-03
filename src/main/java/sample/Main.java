package sample;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import okhttp3.*;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("/sample.fxml")));
        primaryStage.setTitle("Weather App");
        primaryStage.setScene(new Scene(root, 1200, 650));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        root.setOnMousePressed(event ->  {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event ->  {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });


    }


    private static final String citiesPath = "C:\\Users\\Domen\\Desktop\\new\\cities.txt";
    private static final String idPath = "C:\\Users\\Domen\\Desktop\\new\\citiesId.txt";
    private static final String jsonList = "C:\\Users\\Domen\\Desktop\\new\\city.list.json";


    public static void main(String[] args) {
        launch(args);
    }


    // Region fileRelated

    private static void deleteFile(String filename) throws IOException{
        final File cities = new File(filename);
        if (cities.delete()) {
            System.out.println("File deleted");
        }
        else {
            System.out.println("No file found");
        }
    }

    public static void createFile(String filename) throws IOException {
        try {
            final File cities = new File(filename);
            if (cities.createNewFile()) {
                System.out.println("Created file");
            }
            else {
                System.out.println("File already exists");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Data> readFile() throws IOException {
        final Gson gson = new Gson();
         try (final JsonReader reader = new JsonReader(new FileReader(jsonList))) {
             final Type Data_token = TypeToken.getParameterized(ArrayList.class, Data.class).getType();
             return gson.fromJson(reader,Data_token);
         }
    }

    public static ArrayList<String> readCityFile(String filename) throws IOException {
        ArrayList<String> str = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while(reader.ready()) {
                str.add(reader.readLine());
            }
        }
        return str;
    }

    public static void writeToFile(String filename, Boolean sorid) throws IOException {
        try (final FileWriter writer = new FileWriter(filename)) {
            final List<Data> fileData = readFile();
            for (Data data : fileData) {
                if (sorid) writer.write((data.getName() + "\n"));
                else writer.write(data.getId() + " , \n");
            }
        }
    }
    // endregion
}