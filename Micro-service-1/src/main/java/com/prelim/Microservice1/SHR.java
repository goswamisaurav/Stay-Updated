package com.prelim.Microservice1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.Document;


public class SHR {

    String url;
    private Object Document;

    public SHR(String url) {
        this.url = url;

    }

    public SHR() {

    }

    public List<Competition> Scrap() throws IOException {

        List<Competition> cms = new ArrayList<>();
        String URL = "https://www.hackerearth.com/challenges";
        final Document document = (Document) Jsoup.connect("https://www.hackerearth.com/challenges").get();
        //int i = 1;
        for (Element row : document.select("div.challenge-card-modern")) {
            // System.out.println(" row for " + row);
            Competition com = new Competition();

             com.title = row.select("span.challenge-list-title.challenge-card-wrapper").text();
             com.rem_time= row.select("div.challenge-list-meta.challenge-card-wrapper").text();
             com.link=URL+row.select("a[href]").attr("href");
             com.source="HackerEarth";
            if(!com.title.isEmpty()){
                cms.add(com);
            }

            //System.out.println("&&&&: "+com.toString());
            //break;

        }
      return cms;

    }
}
