package com.prelim.Microservice1;

import okhttp3.OkHttpClient;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public final class SendBatchData {

    public static String getJSONString(List<Competition> coms) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for(Competition c : coms){
            JSONObject oneCom = new JSONObject();
            oneCom.put("TITLE", c.title);
            oneCom.put("TIME", c.rem_time);
            oneCom.put("LINK", c.link);
            oneCom.put("SOURCE", c.source);
            jsonArray.put(oneCom);
        }
        return jsonArray.toString();
    }

    public static boolean sendBatchData(List<Competition> coms) {
        OkHttpClient client;
        try {
            client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");

            RequestBody body = RequestBody.create(mediaType, getJSONString(coms));

            Request request = new Request.Builder()
                    .url("http://localhost:8086/store/new_comp")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();

            return true;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return false;
        }

    }
}
