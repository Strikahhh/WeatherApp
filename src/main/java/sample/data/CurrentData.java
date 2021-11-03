package sample.data;

import java.util.List;

public class CurrentData {
    private String name;
    private Integer id;
    private Integer timezone;
    private String message;
    private Double dt;
    private List<Weather> weather;
    private Main main;
    private Sys sys;
    private Wind wind;
    private Clouds clouds;
    private Coord coord;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Sys getSys() {
        return sys;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public static final class Coord {
        private double lon;
        private double lat;

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }
    }

    public static final class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;

        public int getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }


    public static final class Main {
        private double temp;
        private double feels_like;
        private double pressure;
        private double humidity;

        public double getTemp() {
            return temp;
        }

        public double getFeels_like() {
            return feels_like;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }
    }

    public static final class Wind {
        private double speed;
        private double deg;

        public double getSpeed() {
            return speed;
        }

        public double getDeg() {
            return deg;
        }
    }

    public static final class Sys {
        private String country;
        private double sunrise;
        private double sunset;

        public String getCountry() {
            return country;
        }

        public double getSunrise() {
            return sunrise;
        }

        public double getSunset() {
            return sunset;
        }
    }

    public static final class Clouds {
        private int all;

        public int getAll() {
            return all;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTimezone() {
        return timezone;
    }

    public double getDt() {
        return dt;
    }

    public String getMessage() {
        return message;
    }
}
