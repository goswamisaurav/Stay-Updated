package com.prelim.user.userinterface;

import okhttp3.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@RestController
@RequestMapping("/ui")
public class User {
    @CrossOrigin(origins = "*")
//    @CrossOrigin(origins = "file:///C:/Users/KIIT/Desktop/pp/WebSite/bootstrapEg.html")
    @RequestMapping("/get_comp")
    public String geRequest(@RequestParam String offset) throws IOException {
        OkHttpClient client;
        client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        System.out.println(offset);
        Request request = new Request.Builder()
                .url("http://localhost:8086/store/get_comp?offset="+offset)
                .method("GET",null)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();

        return  response.body().string();
    }
}
