package TRJavaHWs.lesson8;

public class SocialSpammer {
    void send(ProfileIterator iterator, String message) {
        while (iterator.hasMore()) {
            System.out.println(iterator.getNext().getEmail() + " " + message);
        }
    }
}
