package sample.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import sample.data.LocationData;
import sample.data.WeeklyData;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WeeklyDataClient {
    private static final String apikey = "d9c7e8272681f3ed9b90c3e4bdf341f2";
    private static final String appid = "6ecec3cd";

    public static Request createRequest(Double lat, Double lng) throws NullPointerException {
        //http://api.weatherunlocked.com/api/forecast/73.13,33.71?app_id=6ecec3cd&app_key=d9c7e8272681f3ed9b90c3e4bdf341f2
        final String url = "http://api.weatherunlocked.com/api/forecast/" + lat + "," + lng + "?app_id=" + appid + "&app_key=" + apikey;
        final HttpUrl.Builder urlbuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        return new Request.Builder().url(urlbuilder.toString()).addHeader("Accept","application/json").build();
    }

    public static WeeklyData retrieveLocationData(OkHttpClient client, Request request) throws IOException {
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Response unsuccessful");
                return null;
            }
            ResponseBody body = response.body();
            if (body != null) {
                //final Type Data_token = TypeToken.getParameterized(ArrayList.class, WeeklyData.class).getType();
                Gson gson = new Gson();
                return gson.fromJson(body.string(), WeeklyData.class);
            }
            else return null;

        }
    }
}
