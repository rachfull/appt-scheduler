package model;

import java.time.*;
import java.util.ArrayList;

public class Doctor {
  private String doctorId;
  private ArrayList<LocalDateTime> apptTimes;

  public Doctor() {
  }

  public Doctor(String doctorId, ArrayList<LocalDateTime> apptTimes) {
    this.doctorId=doctorId;
    this.apptTimes=apptTimes;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId=doctorId;
  }

  public ArrayList<LocalDateTime> getApptTimes() {
    return apptTimes;
  }

  public void setApptTimes(ArrayList<LocalDateTime> apptTimes) {
    this.apptTimes=apptTimes;
  }
}
