package sample.api;

import com.google.gson.Gson;
import okhttp3.*;
import sample.Main;
import sample.data.WeeklyData;

import java.io.IOException;
import java.util.Objects;

public class WeeklyDataClient {

    public static Request createRequest(Double lat, Double lng) throws NullPointerException {
        final String url = "http://api.weatherunlocked.com/api/forecast/" + lat + "," + lng + "?app_id=" + Main.apikey_weekly + "&app_key=" + Main.appid_weekly;
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
