Feature: Communities page

  Scenario Outline: Search for communities
    Given the communities portal is opened
    When I click the communities button
    And I type "<search-term>" in search
    Then I see the "<card-title>" card
    And I see <count> card
    Examples:
      | search-term | card-title                   | count |
      | Idea Pool   | Idea Pool                    | 1     |
      | Java        | JavaScript Competency Center | 12    |

  Scenario Outline:
    Given the communities portal is opened
    When I click the communities button
    And I type "<search-term>" in search
    Then I see the "<card-title>" card
    And I see <count> card
    Examples:
      | search-term | card-title              | count |
      | EngX        | EngX Community          | 4     |
      | C++         | EPAM C++ Community      | 1     |
      | Assembly    | EPAM Assembly Community | 1     |