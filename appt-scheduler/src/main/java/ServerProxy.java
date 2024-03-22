import java.io.*;
import java.net.*;

import com.google.gson.Gson;
import dao.request.ApptScheduleRequest;
import dao.result.ApptResult;
import dao.result.ApptScheduleResult;
import dao.result.InitialScheduleResult;

import javax.net.ssl.HttpsURLConnection;

public class ServerProxy {
  private String url= "https://scheduling.interviews.brevium.com/api/Scheduling/";
  private String token = "?token=" + Credential.API_TOKEN;

  public ServerProxy() {
  }

  private HttpsURLConnection accessApi(String requestMethod, String requestUrl, boolean doOutput) throws IOException {
      URL newUrl = new URL(this.url + requestUrl + token);
      HttpsURLConnection http = (HttpsURLConnection)newUrl.openConnection();
      http.setRequestMethod(requestMethod);
      http.setDoOutput(doOutput);	// There is not a request body
      http.addRequestProperty("Accept", "application/json");

      http.connect();
      return http;
  }

  public void startAPI() {
    try {
      HttpsURLConnection http=accessApi("POST", "Start", false);
      if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
        System.out.println("Successfully restarted API.");
      } else {
        System.out.println("ERROR: " + http.getResponseMessage());
      }
    } catch (IOException e) {
      e.printStackTrace();
//      throw new RuntimeException(e);
    }
  }

  public ApptScheduleResult scheduleAppt(ApptScheduleRequest request) {
    try {
      HttpsURLConnection http = accessApi("POST", "Schedule", true);

      // send request
      Gson gson = new Gson();
      String reqData = gson.toJson(request);
      OutputStream reqOut = http.getOutputStream();

      writeString(reqData, reqOut);

      reqOut.close();

      if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
        InputStream reqInput = http.getInputStream();
        String resInput = readString(reqInput);

        return gson.fromJson(resInput, ApptScheduleResult.class);
      } else {
        System.out.println("ERROR: " + http.getResponseMessage());
        InputStream respBody = http.getErrorStream();
        String respData = readString(respBody);
        return new ApptScheduleResult(respData, false);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return new ApptScheduleResult(e.getMessage(), false);
    }
  }

  public InitialScheduleResult getInitialSchedule() {
    try {
      HttpsURLConnection http=accessApi("GET", "Schedule", true);
      if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
        InputStream reqInput = http.getInputStream();
        String resInput = readString(reqInput);
        Gson gson = new Gson();
        return gson.fromJson(resInput, InitialScheduleResult.class);
      } else {
        System.out.println("ERROR: " + http.getResponseMessage());
        InputStream respBody = http.getErrorStream();
        String respData = readString(respBody);
        return new InitialScheduleResult(respData, false);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return new InitialScheduleResult(e.getMessage(), false);
//      throw new RuntimeException(e);
    }
  }

  public ApptResult getNextAppt() {
    try {
      HttpsURLConnection http=accessApi("GET", "AppointmentRequest", true);
      if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
        InputStream reqInput = http.getInputStream();
        String resInput = readString(reqInput);
        Gson gson = new Gson();
        return gson.fromJson(resInput, ApptResult.class);
      } else {
        System.out.println("ERROR: " + http.getResponseMessage());
        InputStream respBody = http.getErrorStream();
        String respData = readString(respBody);
        return new InitialScheduleResult(respData, false);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return new InitialScheduleResult(e.getMessage(), false);
//      throw new RuntimeException(e);
    }
  }

  /*
      The readString method shows how to read a String from an InputStream.
  */
  private static String readString(InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    InputStreamReader sr = new InputStreamReader(is);
    char[] buf = new char[1024];
    int len;
    while ((len = sr.read(buf)) > 0) {
      sb.append(buf, 0, len);
    }
    return sb.toString();
  }

  /*
      The writeString method shows how to write a String to an OutputStream.
  */
  private static void writeString(String str, OutputStream os) throws IOException {
    OutputStreamWriter sw = new OutputStreamWriter(os);
    sw.write(str);
    sw.flush();
  }

}
