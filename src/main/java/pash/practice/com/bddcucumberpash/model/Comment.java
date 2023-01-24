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
public class Comment {
    int postId;
    int id;
    String name;
    String email;
    String body;

    @Override
    public String toString() {
        return String.format("postId: %s", "id: %s", this.getPostId(), this.getId());
    }
}