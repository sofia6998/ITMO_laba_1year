import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Json {

    public static void GetGhost(ArrayList ghosts, String input){
        InputStreamReader GhostFile = null;
        //Window.fileproblem.setVisible(false);
        try {
            GhostFile = new InputStreamReader(new FileInputStream(input));
            int data = 0;
            String s = "";
            try {
                data = GhostFile.read();
                while (data != -1) {
                    s += (char) data;
                    data = GhostFile.read();
                }
                GhostFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONParser parser = new JSONParser();
            try {
                Object mainObject = parser.parse(s);
                JSONArray garr = (JSONArray) mainObject;
                for (int i = 0; i < garr.size(); i++) {
                    JSONObject per = (JSONObject) parser.parse(garr.get(i).toString());
                    Ghost perG = new Ghost(per.get("name").toString(), Integer.parseInt(per.get("age").toString()),
                            Integer.parseInt(per.get("height").toString()));
                    if(!ghosts.contains(perG)){
                        ghosts.add(perG);
                    }

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            Window.fileproblem.setVisible(true);
        }

    }

    public static void SaveGhost() {
        try {
        JSONArray arr = new JSONArray();
        for (Ghost per : (Window.shownarr)) {
            JSONObject ob = new JSONObject();
            ob.put("name", per.Gname());
            ob.put("age", per.Gage());
            ob.put("height", per.Gheigh());

            arr.add(ob);
        }
            FileOutputStream out = new FileOutputStream("in.json");
            out.write(arr.toString().getBytes());
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
    }
}
