package model;

import java.time.LocalDateTime;

public class AppointmentInfo {
  private String doctorId;
  private String personId;
  private LocalDateTime apptTime;
  private boolean isNewPatient;

  public AppointmentInfo() {
  }

  public AppointmentInfo(String doctorId, String personId, LocalDateTime apptTime, boolean isNewPatient) {
    this.doctorId=doctorId;
    this.personId=personId;
    this.apptTime=apptTime;
    this.isNewPatient=isNewPatient;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId=doctorId;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId=personId;
  }

  public LocalDateTime getApptTime() {
    return apptTime;
  }

  public void setApptTime(LocalDateTime apptTime) {
    this.apptTime=apptTime;
  }

  public boolean isNewPatient() {
    return isNewPatient;
  }

  public void setNewPatient(boolean newPatient) {
    isNewPatient=newPatient;
  }
}
