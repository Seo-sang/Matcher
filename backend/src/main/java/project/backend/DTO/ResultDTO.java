package project.backend.DTO;

import lombok.Data;

@Data
public class ResultDTO {
    private String message;

    public ResultDTO(String message) {
        this.message = message;
    }
}
