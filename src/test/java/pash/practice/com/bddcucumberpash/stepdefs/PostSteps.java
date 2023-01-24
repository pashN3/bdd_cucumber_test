package pash.practice.com.bddcucumberpash.stepdefs;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import pash.practice.com.bddcucumberpash.model.Comment;
import pash.practice.com.bddcucumberpash.model.Post;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostSteps extends AbstractSteps implements En{

    public PostSteps() {
        Given("user creates a post with following attribute", (DataTable postDt) -> {
            testContext().reset();
            List<Post> createPost = postDt.asList(Post.class);
            // First row of DataTable has the post attributes hence calling get(0) method.
            super.testContext()
                    .setPayload(createPost.get(0));
        });

        Given("another user comments the post", (DataTable commentDt) ->{
            String createPostUrl = "/comments";
            // AbstractSteps class makes the POST call and stores response in TestContext
            List<Comment> createComment = commentDt.asList(Comment.class);
            super.testContext()
                    .setPayload(createComment.get(0));
            executePost(createPostUrl);
        });

        When("user publishes the post", () ->{
            String createPostUrl = "/posts";
            // AbstractSteps class makes the POST call and stores response in TestContext
            executePost(createPostUrl);
        });

        Then("the post is visible on user's account", () -> {
            String expectedPost = testContext().getPayload().toString();
            String getPostUrl = "/posts/1";
            executeGet(getPostUrl);
            assertThat(testContext().getResponse()).withFailMessage("Expected post doesn't match the actaul post").isEqualTo(expectedPost);

        });

        Then("the post is not visible on user's account", () -> {
            String expectedPost = testContext().getPayload().toString();
            String getPostUrl = "/posts/1";
            executeGet(getPostUrl);
            assertThat(testContext().getResponse()).withFailMessage("Invalid post is visible").isNotEqualTo(expectedPost);

        });

        Then("the comment is visible on the post", () -> {
            String expectedPost = testContext().getPayload().toString();
            String getCommentUrl = "/posts/1/comments";
            executeGet(getCommentUrl);
            assertThat(testContext().getResponse()).withFailMessage("Expected comment doesn't match the actual comment").isEqualTo(expectedPost);

        });

        Then("the comment is not visible on the post", () -> {
            String expectedPost = testContext().getPayload().toString();
            String getCommentUrl = "/posts/1/comments";
            executeGet(getCommentUrl);
            assertThat(testContext().getResponse()).withFailMessage("Expected comment appears on the post").isNotEqualTo(expectedPost);

        });
    }
}
