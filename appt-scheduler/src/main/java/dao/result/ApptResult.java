package dao.result;

public class ApptResult {
  private int requestId;
  private int personId;
  private String[] preferredDays;
  private int[] preferredDocs;
  private boolean isNew;

  private boolean isSuccess;
  private String message;

  public ApptResult(int requestId, int personId, String[] preferredDays, int[] preferredDocs, boolean isNew, boolean isSuccess) {
    this.requestId=requestId;
    this.personId=personId;
    this.preferredDays=preferredDays;
    this.preferredDocs=preferredDocs;
    this.isNew=isNew;
    this.isSuccess = isSuccess;
  }

  public ApptResult(String message, boolean isSuccess) {
    this.message = message;
    this.isSuccess = isSuccess;
  }

  public int getRequestId() {
    return requestId;
  }

  public void setRequestId(int requestId) {
    this.requestId=requestId;
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId=personId;
  }

  public String[] getPreferredDays() {
    return preferredDays;
  }

  public void setPreferredDays(String[] preferredDays) {
    this.preferredDays=preferredDays;
  }

  public int[] getPreferredDocs() {
    return preferredDocs;
  }

  public void setPreferredDocs(int[] preferredDocs) {
    this.preferredDocs=preferredDocs;
  }

  public boolean isNew() {
    return isNew;
  }

  public void setNew(boolean aNew) {
    isNew=aNew;
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
