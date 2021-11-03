package sample.data;

import java.util.List;

public class LocationData {

    private List<Results> results;

    public static class Results {
        private Geometry geometry;

        public static class Geometry  {
            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public double getLon() {
                return lng;
            }
        }

        public Geometry getGeometry() {
            return geometry;
        }
    }

    public List<Results> getResults() {
        return results;
    }
}
