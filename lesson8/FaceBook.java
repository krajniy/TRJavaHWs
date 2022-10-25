package TRJavaHWs.lesson8;

public class FaceBook implements SocialNetwork{
    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FaceBookIterator(this, profileId, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FaceBookIterator(this, profileId, "coworkers");

    }
}
