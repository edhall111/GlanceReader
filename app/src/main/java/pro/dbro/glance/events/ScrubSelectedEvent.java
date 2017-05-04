package pro.dbro.glance.events;

/**
 * Created by Ed on 4/25/2017.
 */

public class ScrubSelectedEvent {
    private final float mPos;

    public ScrubSelectedEvent(float pos) {
        this.mPos = pos;
    }

    public float getPos() {
        return this.mPos;
    }
}
