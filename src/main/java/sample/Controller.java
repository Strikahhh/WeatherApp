package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import okhttp3.*;
import sample.api.CurrentDataClient;
import sample.api.LocationDataClient;
import sample.api.WeeklyDataClient;
import sample.data.CurrentData;
import sample.data.WeeklyData;
import sample.enums.Country;
import sample.data.LocationData;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {


    @FXML
    private ImageView weatherimage, country, temp, weather1, weather2,weather3,weather4,
                dailyw1,dailyw2,dailyw3,dailyw4,dailyw5,dailyw6,dailyw7,dailyw8,
    arrowr,arrowl;
    @FXML
    private TextField searchField;

    @FXML
    private Label curCity, currentTime, description, curTemp, feels, pressure, humidity, windspeed, winddir, except, clouds
            ,date1, date2, date3, date4,desc1,desc2,desc3,desc4,humid1,humid2,humid3,humid4,
            max_temp1,max_temp2,max_temp3,max_temp4,min_temp1,min_temp2,min_temp3,min_temp4,
            precip1,precip2,precip3,precip4,sDescr,
            hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,
            descw1,descw2,descw3,descw4,descw5,descw6,descw7,descw8,
            temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,
            feels1,feels2,feels3,feels4,feels5,feels6,feels7,feels8,
            precipw1,precipw2,precipw3,precipw4,precipw5,precipw6,precipw7,precipw8,
            wspeed1,wspeed2,wspeed3,wspeed4,wspeed5,wspeed6,wspeed7,wspeed8,
            percprob1,percprob2,percprob3,percprob4,percprob5,percprob6,percprob7,percprob8
    ;

    @FXML
    private Node empty, wreport, weeklyForecast, hourlyPane, weeklyPane, dailyPane1, dailyPane2,currentPane,homePane;

    @FXML
    private Button home, cForecast, wForecast, weeklyMore1, weeklyMore2, weeklyMore3, weeklyMore4;

    @FXML
    private Label label1,label2,label3,label4;

    private boolean searched = false;
    //private boolean searched2 = false;

    //private List<WeeklyData.Days> days;
    private final List<WeeklyData.Days.Timeframes> timeframes = new ArrayList<WeeklyData.Days.Timeframes>();

    public void searchCurrently(String cityName) {
        try {
            final Request request = CurrentDataClient.createRequest(cityName);
            final CurrentData data = CurrentDataClient.retrieveData(CurrentDataClient.client, request);
            double slon;
            double slat;

            if (data != null) {
                moveToFront(currentPane);
                try {
                    System.out.println(data.getSys().getCountry());
                    final Country countryLink = Country.getById(data.getSys().getCountry());
                    Image image = new Image("/images/flags/" + countryLink.getName().replace(" ", "-") + ".png");
                    country.setImage(image);
                    //System.out.println(data.getWeather().get(0).getIcon());
                    if (data.getMain().getTemp() > 20) {
                        temp.setImage(new Image("/images/hm.png"));
                    }
                    else temp.setImage(new Image("/images/cm.png"));

                    Image weather = new Image("/images/weather/" + data.getWeather().get(0).getIcon() + ".png");
                    weatherimage.setImage(weather);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                //searched = true;
                long hours = data.getTimezone()/3600L;
                searched = true;
                OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
                OffsetDateTime c = utc.plusHours(hours);
                final String date = c.toString();
                int start = date.indexOf("T");
                int end = date.indexOf(".");
                final String countryDate = date.substring(start+1,end);
                final String descr = data.getWeather().get(0).getDescription();
                final String des = Character.toUpperCase(descr.charAt(0)) + descr.substring(1);

                curCity.setText("Current weather for " + data.getName());
                currentTime.setText("Local time " + countryDate);
                description.setText(des);
                curTemp.setText("Currently: " + data.getMain().getTemp());
                feels.setText("Feels like: "+ data.getMain().getFeels_like());
                pressure.setText("Pressure: "+ data.getMain().getPressure()+ " hPa");
                humidity.setText("Humidity: " + data.getMain().getHumidity() + " %");
                windspeed.setText("Speed: " + data.getWind().getSpeed() + " m/s");
                winddir.setText("Direction: " + data.getWind().getDeg());
                clouds.setText("Clouds: " + data.getClouds().getAll() + " %");

                slon = (double) Math.round(data.getCoord().getLon() * 100) / 100;
                slat = (double) Math.round(data.getCoord().getLat() * 100) / 100;

                weekly(slat,slon);
            }
            else
            {
                moveToFront(empty);
                except.setText("Found no city by that name");
                System.out.println("Error with name");
            }





        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dailySearch(WeeklyData.Days.Timeframes timeframes, int vals, Label hour, ImageView dailyw, Label desc, Label temp, Label feels, Label precip, Label wind, Label percprob) {
        hour.setText((vals*3+3) + ":00");
        dailyw.setImage(new Image("/images/weekly/" + timeframes.getWx_icon().replace(".gif", ".png")));
        desc.setText(timeframes.getWx_desc());
        temp.setText("Temperature: "+ timeframes.getTemp_c());
        feels.setText("Feels like: " + timeframes.getFeelslike_c());
        precip.setText("" + timeframes.getPrecip_mm()+ " mm");
        wind.setText("Wind: "+ timeframes.getWindspd_kmh() + " km/h");
        percprob.setText("Rain: " + timeframes.getProb_precip_pct() + "%");
    }

    public void handleDailySearch(javafx.event.ActionEvent event) {
        moveToFront(hourlyPane);
        final Map<Button, Integer> weeklySearch = Map.of(weeklyMore1, 0, weeklyMore2, 1, weeklyMore3, 2, weeklyMore4, 3);

        int mult = weeklySearch.getOrDefault(event.getSource(), null);
        int start = mult*8;
        int tstart = (mult-1)/8;
        dailySearch(timeframes.get(start), tstart , hour1, dailyw1, descw1, temp1, feels1, precipw1, wspeed1, percprob1);
        dailySearch(timeframes.get(start+1), tstart+1 , hour2, dailyw2, descw2, temp2, feels2, precipw2, wspeed2, percprob2);
        dailySearch(timeframes.get(start+2), tstart+2 , hour3, dailyw3, descw3, temp3, feels3, precipw3, wspeed3, percprob3);
        dailySearch(timeframes.get(start+3), tstart+3 , hour4, dailyw4, descw4, temp4, feels4, precipw4, wspeed4, percprob4);
        dailySearch(timeframes.get(start+4), tstart+4 , hour5, dailyw5, descw5, temp5, feels5, precipw5, wspeed5, percprob5);
        dailySearch(timeframes.get(start+5), tstart+5 , hour6, dailyw6, descw6, temp6, feels6, precipw6, wspeed6, percprob6);
        dailySearch(timeframes.get(start+6), tstart+6 , hour7, dailyw7, descw7, temp7, feels7, precipw7, wspeed7, percprob7);
        dailySearch(timeframes.get(start+7), tstart+7 , hour8, dailyw8, descw8, temp8, feels8, precipw8, wspeed8, percprob8);


    }

    public void switchRight() {
        moveToFront(dailyPane2);
    }
    public void switchLeft() {
        moveToFront(dailyPane1);
    }

    public void enableLabels() {
        final Label[] labels = {label1,label2,label3,label4};
        for (int k = 0; k < 4; k++) {
            labels[k].setText("");
        }
        try {
            ArrayList<String> names = Main.readCityFile("C:\\Users\\Domen\\IdeaProjects\\Weather App\\src\\main\\resources\\citynames.txt");
            final String txt = searchField.getText();
            int j = 0;
            for (String name : names) {
                if (!txt.equals("") && name.startsWith(txt)) {

                    if (j==4) break;
                    labels[j].setText(name);
                    labels[j].setVisible(true);
                    j++;
                }
                for (Label lbl : labels) {
                    if (lbl.getText().equals("")) lbl.setVisible(false);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByLabel1() {
        final String txt = label1.getText();
        if (!txt.equals("")) {
            final String toSearch = txt.substring(0,txt.indexOf(","));
            searchCurrently(toSearch);
        }
    }
    public void searchByLabel2() {
        final String txt = label2.getText();
        if (!txt.equals("")) {
            final String toSearch = txt.substring(0,txt.indexOf(","));
            searchCurrently(toSearch);
        }
    }
    public void searchByLabel3() {
        final String txt = label3.getText();
        if (!txt.equals("")) {
            final String toSearch = txt.substring(0,txt.indexOf(","));
            searchCurrently(toSearch);
        }
    }
    public void searchByLabel4() {
        final String txt = label4.getText();
        if (!txt.equals("")) {
            final String toSearch = txt.substring(0,txt.indexOf(","));
            searchCurrently(toSearch);
        }
    }

    public void searchByButton() {
        final String txt = searchField.getText();
        if (txt.equals("")) {
            searchField.setText("You need to enter a name");
        }
        else {
            searchCurrently(txt);
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void weekly(double lat, double lon) throws IOException {
        final Request wRequest = WeeklyDataClient.createRequest(lat,lon);
        final WeeklyData weeklyData = WeeklyDataClient.retrieveLocationData(CurrentDataClient.client, wRequest);

        if (weeklyData != null) {
            //moveToFront(weeklyPane);
            setupWeeklyLayers(weeklyData.getDays().get(1), date1, precip1, humid1, max_temp1, min_temp1, desc1, weather1);
            setupWeeklyLayers(weeklyData.getDays().get(2), date2, precip2, humid2, max_temp2, min_temp2, desc2, weather2);
            setupWeeklyLayers(weeklyData.getDays().get(3), date3, precip3, humid3, max_temp3, min_temp3, desc3, weather3);
            setupWeeklyLayers(weeklyData.getDays().get(4), date4, precip4, humid4, max_temp4, min_temp4, desc4, weather4);

            int i = 0;
            if (timeframes.size() != 0) timeframes.clear();
            for (WeeklyData.Days dataDays : weeklyData.getDays()) {
                if (i > 0) {
                    if (i < 5) {
                        for (int j = 0; j < 8; j++) {
                            timeframes.add(dataDays.getTimeframes().get(j));
                        }
                    }
                }
                i++;
            }
        }
    }

    public void setupWeeklyLayers(WeeklyData.Days dataDays, Label date, Label precip, Label humid, Label maxTemp, Label minTemp, Label desc, ImageView weather) {
        date.setText(dataDays.getDate());
        precip.setText("Precipitation: " + dataDays.getPrecip_total_mm() + " mm");
        humid.setText(dataDays.getHumid_min_pct() + "%");
        maxTemp.setText("Daily max: " + dataDays.getTemp_max_c());
        minTemp.setText("Daily min: " + dataDays.getTemp_min_c());
        desc.setText(dataDays.getTimeframes().get(3).getWx_desc());
        weather.setImage(new Image("/images/weekly/" + dataDays.getTimeframes().get(3).getWx_icon().replace(".gif", ".png")));
    }


    private static void moveToFront(Node pane) {
        pane.setStyle("-fx-background-color : #2e3847");
        pane.toFront();
    }

    public void clicks(javafx.event.ActionEvent actionEvent) {

        if (actionEvent.getSource() == cForecast) {
            if (searched) moveToFront(currentPane);
            else  {
                moveToFront(empty);
                except.setText("No search has been initiated");
            }
        }
        else if (actionEvent.getSource() == wForecast) {
            if (searched) moveToFront(weeklyPane);
            else  {
                moveToFront(empty);
                except.setText("No search has been initiated");
            }
        }
        else if (actionEvent.getSource() == home) {
            moveToFront(homePane);
        }
    }
}
