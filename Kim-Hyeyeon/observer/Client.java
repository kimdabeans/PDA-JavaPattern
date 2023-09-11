package observer;

//Client.java
public class Client {
private String name;
private String email;

public Client(String name, String email) {
   this.name = name;
   this.email = email;
}

public String getEmail() {
   return email;
}

public String getName() {
   return name;
}
}
