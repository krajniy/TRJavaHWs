package TRJavaHWs.lesson8;

public class Application {
    SocialNetwork network;
    SocialSpammer spammer;

    public Application(SocialNetwork network, SocialSpammer spammer) {
        this.network = network;
        this.spammer = spammer;
    }

    void sendSpamToFriends(Profile profile){
        ProfileIterator iterator = network.createFriendsIterator(profile.getId());
        spammer.send(iterator, "spam");
    }

    void sendSpamToCoworkers(Profile profile){
        ProfileIterator iterator = network.createCoworkersIterator(profile.getId());
        spammer.send(iterator, "spam");
    }




}
