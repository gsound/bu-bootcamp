import java.util.*;

public class ContactManager {

  public static void main(String[] args) {

    HashMap<String, Contact> contacts = new HashMap<>();

    // Step 4: add contacts here
    contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
    contacts.put("John", new Contact("John", "+1 764 423 8912"));
    contacts.put("Lucy", new Contact("Lucy", "+1 286 567 5732"));
    contacts.put("Mary", new Contact("Mary", "+1 401 463 9975"));

    // Step 5: look up a contact
    Contact c = contacts.get("Mary");
    String msg;
    if (c == null)
      msg = "Contact not found";
    else
      msg = c.toString();
    System.out.println(msg);

    Contact c2 = contacts.get("Not existing");
    if (c2 == null)
      msg = "Contact not found";
    else
      msg = c.toString();
    System.out.println(msg);

    // Step 6: print sorted list
    ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
    sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
    System.out.println("=== All Contacts ===");
    for (Contact sortedC : sorted) {
      System.out.println(sortedC);
    }
  }
}