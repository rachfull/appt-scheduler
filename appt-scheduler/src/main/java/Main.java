import dao.request.ApptScheduleRequest;
import dao.result.ApptScheduleResult;
import dao.result.InitialScheduleResult;

import java.time.Instant;

public class Main {
  public static void main(String[] args) {
    ServerProxy serverProxy = new ServerProxy();
    // call serverproxy class to handle requests

    // example of interacting with the API

    // start by getting the initial schedule
    InitialScheduleResult initialScheduleResult = serverProxy.getInitialSchedule();
    // try to schedule a new appointment
    ApptScheduleRequest apptScheduleRequest = new ApptScheduleRequest(1, 1, Instant.now(), false, 0);
    ApptScheduleResult apptScheduleResult = serverProxy.scheduleAppt(apptScheduleRequest);
    if (!apptScheduleResult.isSuccess()) {
      // if the appointment failed, print the error
      System.out.println(apptScheduleResult.getMessage());
    }
    
  }
}