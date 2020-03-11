package com.prelim.jdbc.Storedb;

import org.springframework.web.bind.annotation.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.StringReader;
import java.sql.*;
import java.util.Iterator;

@RestController
@RequestMapping("/store")
public class JdbcStore {
    private Object Json;
    @GetMapping("/get_comp")
    public  String  getCompetition(@RequestParam String offset) throws ClassNotFoundException, SQLException, JSONException {
        Competition com = new Competition();
        String url="jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
        String uname="root";
        String pass="saurav@99";
        String query="select * from mstable9 limit 10 offset "+offset;
        //System.out.println(query);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        String jsonString;
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
        while (rs.next()){
             //jsonString = rs.getString(1) + ":" + rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getInt(5);
            JSONObject oneCom = new JSONObject();
            oneCom.put("TITLE",  rs.getString(1));
            oneCom.put("TIME",rs.getString(2));
            oneCom.put("LINK", rs.getString(3));
            oneCom.put("SOURCE", rs.getString(4));
            jsonArray.put(oneCom);
        }
       return  jsonArray.toString();
    }

    @PostMapping("/new_comp")
    public void postCompetition(@RequestBody String coms) throws JSONException, SQLException, ClassNotFoundException {
        JSONArray ja = new JSONArray(coms);
        //System.out.println(ja);
        JSONObject jsonObject;
        for (int i = 0; i < ja.length(); i++) {
            jsonObject = new JSONObject(ja.get(i).toString());
            //System.out.println(jsonObject.get("TITLE"));
            insertDb(jsonObject);
        }



    }

    private void insertDb(JSONObject jsonObject) throws ClassNotFoundException, SQLException, JSONException {

        String url="jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
        String uname="root";
        String pass="saurav@99";
        String query="insert into mstable9 values(\""+jsonObject.get("TITLE")+"\",\""+jsonObject.get("TIME")+"\",\""+jsonObject.get("LINK")+"\",\""+jsonObject.get("SOURCE")+"\",1,UUID_TO_BIN(UUID()))";
       // String query = "select rem_time from mstable where id = 1 ";
        // System.out.println(query);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        Statement st = con.createStatement();

        st.executeUpdate(query);
//
//       rs.next();
//       String name = rs.getString("rem_time");
//       System.out.println(name);
//
//       st.close();
//       con.close();

    }

}
