package hello.advanced.part1.trace;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = this.createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isFirstLevel() {
        return this.level == 0;
    }

}