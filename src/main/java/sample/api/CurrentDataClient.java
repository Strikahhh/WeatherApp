package sample.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import okhttp3.*;
import sample.data.CurrentData;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CurrentDataClient {

    public static final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build();

    private static final String apikey = "cf486f6fece615336cd7e630771bfa20";
    private static final String url = "http://api.weatherunlocked.com/forecast/London?app_id=6ecec3cd&api_key=d9c7e8272681f3ed9b90c3e4bdf341f2";

    public static Request createRequest(String cityname) throws NullPointerException {
        final String url = "https://api.openweathermap.org/data/2.5/weather?" + "appid=" + apikey + "&units=metric&q=" + cityname;
        final HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        return new Request.Builder().url(urlBuilder.toString()).build();
    }

    public static CurrentData retrieveData(OkHttpClient client, Request request) throws IOException, JsonSyntaxException {
        try (final Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return null;
            }
            final ResponseBody responseBody = response.body();
            if (responseBody != null) {
                final Gson gson = new Gson();
                return gson.fromJson(responseBody.string(),CurrentData.class);
            }else {
                System.out.println("Response failed");
                return null;
            }
        }
    }
}
