package users;

public interface NetworkUsers extends Users<String> {
    String getHost();
    int getPort();
}
