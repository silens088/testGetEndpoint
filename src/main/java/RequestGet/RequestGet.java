package RequestGet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 ===========================================================================
    GET /company/%companyId%/users?name=%someName%
    String url = "globaldb.com/company/100/users?name=Vitalii";
    Убедитесь, что пользователь может искать только члена своей компании.
 ===========================================================================
 */

public class RequestGet {
    private int Code;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }


    public void requestGet(String url, String token) {

        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization:", "Bearer " + token); //"Bearer " - HTTP authentication (токен авторизации)
            connection.setDoInput(true);
            connection.connect();
            setCode(connection.getResponseCode());

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println("connection successful | Response Code : " + getCode());
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                System.out.println(sb.toString());

            } else {
                System.out.println("Response Code : " + connection.getResponseCode()+ " " + connection.getResponseMessage());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
                System.out.println("close connection");
            }
        }
    }
}
