package pro.dbro.glance.events;

/**
 * Created by Ed on 4/25/2017.
 */

public class ScrubSelectedEvent {
    private final int mPos;

    public ScrubSelectedEvent(int pos) {
        this.mPos = pos;
    }

    public int getPos() {
        return this.mPos;
    }
}
