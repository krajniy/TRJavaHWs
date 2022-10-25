package TRJavaHWs.lesson8;

import java.util.List;

public class FaceBookIterator implements ProfileIterator{
    FaceBook faceBook;
    String profileId;
    String type;

    int currentPosition;
    List<Profile> cache;

    public FaceBookIterator(FaceBook faceBook, String profileId, String type) {
        this.faceBook = faceBook;
        this.profileId = profileId;
        this.type = type;
    }

    void lazyInit(){
        if (cache == null){
        //TODO

        }
    }

    public Profile getNext(){
        if (hasMore()){
            currentPosition++;
            return cache.get(currentPosition);
        }
        return null;
    }
    public boolean hasMore(){
        lazyInit();
        return currentPosition < cache.size();
    }

}
