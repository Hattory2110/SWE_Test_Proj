Feature: Events page


  Scenario Outline: Search for Event
    Given the communities portal is opened
    When I click the events button
    And I type "<search-term>" in search on Events Page
    Then I see the "<card-title>" card on Events Page
    And I see <count> card on Events
    Examples:
      | search-term     | card-title                                                   | count |
      | La              | Polish Conversation Club in Wroclaw (offline meetings)       | 12    |
      | Italian         | Italian Speaking Event - May 2024                            | 1     |
      | Latvian         | Latvian Speaking club May 2024                               | 1     |



    Scenario Outline: Location field labels
      Given the events page opened
      When  I click the Location filter
      And I type "<search-location>" in location search
      Then I select each filter
      Then I see <card_count> card on Events
      And I see <count> label
      Examples:
        | search-location   | card_count | count |
#        | ger               | 4         | 6     |
#        | kingdom           | 12         | 2     |
        | hu                | 2         | 10    |

#    Scenario Outline: Navigation bar functionalities
#      Given the events page opened
#      When I click on "<page>" navigation
#      Then the required "<page>" opens
#      Examples:
#        |     page      |
#        | Communities   |
#        | Events        |
#        | Calendar      |
#        | Videos        |
#        | Speakers      |
#        | Articles      |
