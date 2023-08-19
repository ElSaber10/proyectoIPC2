package com.ipc2.todoweb.TransformandoObjeto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TransformarObjeto {
    private String json;
    private static String jsonFile="/tmp/entrada.json";

    public TransformarObjeto(String json) throws FileNotFoundException {
        this.json = json;
    }

    public TransformarObjeto() {
    }

    public static void analizar() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("/tmp/entrada.json");
        Object obj = parser.parse(reader);
        JSONObject pJsonObj = (JSONObject)obj;
        JSONArray Aadmins = (JSONArray)pJsonObj.get("admins");
        //JSONArray admins = (JSONArray) parser.parse(new FileReader(jsonFile));


        for (Object o : Aadmins) {
            JSONObject admins = (JSONObject) o;

            Long codigo = (Long) admins.get("codigo");
            System.out.println(codigo);

            String nombre = (String) admins.get("nombre");
            System.out.println(nombre);

            String user = (String) admins.get("username");
            System.out.println(user);

            String password = (String) admins.get("password");
            System.out.println(password);

            JSONArray admin = (JSONArray) admins.get("admins");

            for(int i = 0; i < Aadmins.size(); i++) {
                {
                    System.out.println(Aadmins + "");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException, ParseException {
    analizar();
    }
}
