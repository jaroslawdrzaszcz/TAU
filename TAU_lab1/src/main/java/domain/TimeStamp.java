package domain;

import java.time.LocalDate;

public class TimeStamp {
    private LocalDate timeStamp;

    public TimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TimeStamp() {

    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
}
