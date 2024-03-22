package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Patient {

  private String personId;
  private ArrayList<LocalDateTime> appts;

  public Patient(String personId, ArrayList<LocalDateTime> appts) {
    this.personId=personId;
    this.appts=appts;
  }
  public Patient() {}

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId=personId;
  }

  public ArrayList<LocalDateTime> getAppts() {
    return appts;
  }

  public void setAppts(ArrayList<LocalDateTime> appts) {
    this.appts=appts;
  }
}
