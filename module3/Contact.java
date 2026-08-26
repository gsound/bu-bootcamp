public class Contact {
  private String name;
  private String phone;
  private String address;

  public Contact(String name, String phone) {
    this.name = name;
    this.phone = phone;
    this.address = "";
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public String getPhone() {
    return this.phone;
  }

  @Override
  public String toString() {
    return name + " | " + phone;
  }

}
