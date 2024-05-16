Feature: Articles page

  Scenario Outline: Search for articles
    Given the articles portal is opened
    When I click the articles search bar
    And I type "<search-term>" in articles search
    Then I see the "<card-titlex>" card on Articles Page
    Examples:
      | search-term | card-titlex                                                    |
      | master      | Mastering Presentation Design: 5 Tips to Dodge Common Mistakes |
      | poland      | A short story of Java Poland Community
      | python      | PySpark Automation with Python

  Scenario Outline: Search for tags
    Given the articles portal is opened
    When I click the tags search Button
    And I click into the tags search Bar
    And I type "<search-term>" in tags search
    Then I see <count> speaker cards
    Examples:
      | search-term | count |
      | french      | 0     |
      | english     | 77    |
      | profit and  | 1     |