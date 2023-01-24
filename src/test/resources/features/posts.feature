Feature: Create post and comment on it

  Scenario: Create post with valid data
    Given user creates a post with following attribute
    |userId| id|title      |body        |
    |1     |1  | some title| some body  |
    When user publishes the post
    Then the post is visible on user's account

  Scenario: Create comment with valid data
    Given user creates a post with following attribute
      |userId| id|title      |body        |
      |1     |1  | some title| some body |
    When another user comments the post
    |postId|id|name    |email                |body            |
    |1     |1 |someName|someone@something.com| some comments |
    Then the comment is visible on the post

  Scenario: Create post with invalid data
    Given user creates a post with following attribute
      |userId| id      | title          |body                      |
      |@     |skdjksf! | 屈 齐 D'Emanuele|屈 齐 D'Emanuele 荆 O' Gara|
    When user publishes the post
    Then the post is not visible on user's account

  Scenario: Create comment with invalid data
    Given user creates a post with following attribute
      |userId| id|title      |body      |
      |1     |1  | some title| some body|
    When another user comments the post
      |postId|id|name    |email                |body                       |
      |#     |^ |someName|someone@something.com| 屈 齐 D'Emanuele 荆 O' Gara|
    Then the comment is not visible on the post