package dto;

import enums.Status;

public class StatusDto {
    private Status status;

    public StatusDto() {
    }

    public StatusDto(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
