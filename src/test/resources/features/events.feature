Feature: Events page


  Scenario Outline: Search for Event
    Given the communities portal is opened
    When I click the events button
    And I type "<search-term>" in search on Events Page
    Then I see the "<card-title>" card on Events Page
    And I see <count> card in Events
    Examples:
      | search-term     | card-title                                                   | count |
      | La              | Polish Conversation Club in Wroclaw (offline meetings)       | 12    |
      | Italian         | Italian Speaking Event - May 2024                            | 1     |
      | Latvian         | Latvian Speaking club May 2024                               | 1     |



    Scenario Outline: Location field labels
      Given the communities portal is opened
      When I click the events button
      And  I click the Location filter
      And I type "<search-location>" in location search
      Then I see <count> label
      Examples:
        | search-location   | count |
        | ger               | 2     |
        | un                | 5     |
        | hu                | 2     |