package sample.api;

import com.google.gson.Gson;
import okhttp3.*;
import sample.data.LocationData;

import java.io.IOException;
import java.util.Objects;

public class LocationDataClient {

    private static final String apikey = "64f72ca788fe4529ba4d12e7a6373f8e";

    public static Request createRequest(String cityname) throws NullPointerException {
        final String url = "https://api.opencagedata.com/geocode/v1/json?key=" + apikey + "&q=" + cityname + "&pretty=1&lang=en";
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
