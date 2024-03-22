package dao.result;

import model.AppointmentInfo;

public class InitialScheduleResult {
  private AppointmentInfo[] initialAppts;

  private boolean isSuccess;
  private String message;

  public InitialScheduleResult(AppointmentInfo[] initialAppts, boolean isSuccess) {
    this.initialAppts=initialAppts;
    this.isSuccess=isSuccess;
  }

  public InitialScheduleResult(boolean isSuccess, String message) {
    this.isSuccess=isSuccess;
    this.message=message;
  }

  public AppointmentInfo[] getInitialAppts() {
    return initialAppts;
  }

  public void setInitialAppts(AppointmentInfo[] initialAppts) {
    this.initialAppts=initialAppts;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess=success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message=message;
  }
}
