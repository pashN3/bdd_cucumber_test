package pash.practice.com.bddcucumberpash.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize
public class Post {
    int id;
    int userId;
    String title;
    String body;

    @Override
    public String toString() {
        return String.format("id: %s", "userId: %s", this.getId(), this.getUserId());
    }
}
