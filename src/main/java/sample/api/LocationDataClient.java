package sample.api;

import com.google.gson.Gson;
import okhttp3.*;
import sample.Main;
import sample.data.LocationData;

import java.io.IOException;
import java.util.Objects;

public class LocationDataClient {

    public static Request createRequest(String cityname) throws NullPointerException {
        final String url = "https://api.opencagedata.com/geocode/v1/json?key=" + Main.apikey_location + "&q=" + cityname + "&pretty=1&lang=en";
        final HttpUrl.Builder urlbuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        return new Request.Builder().url(urlbuilder.toString()).build();
    }

    public static LocationData retrieveLocationData(OkHttpClient client, Request request) throws IOException {
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) return null;
            ResponseBody body = response.body();

            if (body != null) {
                Gson gson = new Gson();
                return gson.fromJson(body.string(), LocationData.class);
            }
            else return null;

        }
    }
}
