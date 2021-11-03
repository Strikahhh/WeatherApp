package sample.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeeklyData {

    @SerializedName("Days")
    private List<Days> days;

    public List<Days> getDays() {
        return days;
    }

    public static class Days {
        private String date;
        private double temp_max_c;
        private double temp_min_c;
        private double precip_total_mm;
        private int humid_min_pct;
        private int windspd_max_kmh;

        @SerializedName("Timeframes")
        private List<Timeframes> timeframes;

        public String getDate() {
            return date;
        }

        public double getTemp_max_c() {
            return temp_max_c;
        }

        public double getTemp_min_c() {
            return temp_min_c;
        }

        public double getPrecip_total_mm() {
            return precip_total_mm;
        }

        public int getHumid_min_pct() {
            return humid_min_pct;
        }

        public int getWindspd_max_kmh() {
            return windspd_max_kmh;
        }

        public List<Timeframes> getTimeframes() {
            return timeframes;
        }

        public static class Timeframes {
            private String wx_desc;
            private double temp_c;
            private String wx_icon;
            private double feelslike_c;
            private double windspd_kmh;
            private int cloud_mid_pct;
            private double precip_mm;
            private int humid_pct;
            private int vis_km;
            private String prob_precip_pct;

            public String getWx_icon() {
                return wx_icon;
            }

            public String getWx_desc() {
                return wx_desc;
            }

            public double getTemp_c() {
                return temp_c;
            }

            public double getFeelslike_c() {
                return feelslike_c;
            }

            public double getWindspd_kmh() {
                return windspd_kmh;
            }

            public int getCloud_mid_pct() {
                return cloud_mid_pct;
            }

            public double getPrecip_mm() {
                return precip_mm;
            }

            public int getHumid_pct() {
                return humid_pct;
            }

            public int getVis_km() {
                return vis_km;
            }

            public String getProb_precip_pct() {
                return prob_precip_pct;
            }
        }

    }
}
