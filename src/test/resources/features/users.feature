Feature: Get list of users

  Scenario: Get list of valid users
    Given users creates an account with following details
    |id|name         |username|email            |phone                | website     |
    |1 |Leanne Graham| Bret   |sincere@april.biz|1-770-736-8031 x56442|hildegard.org|
    Then user is created
