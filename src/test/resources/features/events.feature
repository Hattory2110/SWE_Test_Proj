Feature: Events page


  Scenario Outline: Search for Event
    Given the communities portal is opened
    When I click the events button
    And I type "<search-term>" in search on Events Page
    Then I see the "<card-title>" card on Events Page
    And I see <count> card on Events
    Examples:
      | search-term     | card-title                               | count |
      | Hu              | Unifyhub Speaking Events (May)           | 3     |
      | Italian         | Italian Speaking Event - May 2024        | 1     |
      | Latvian         | Latvian Speaking club May 2024           | 1     |



    Scenario Outline: Search for events with location filter
      Given the events page opened
      When  I click the Location filter
      And I type "<search-location>" in filter search
      Then I select each location filter
      And I see <label_num> "<type>" label
      And I see <card_count> card on Events
      Examples:
        | search-location   | label_num | type     | card_count |
        | ger               | 6         | Location | 8          |
        | kingdom           | 2         | Location | 5          |
        | hu                | 10        | Location | 2          |

    Scenario Outline: Navigation bar functionalities
      Given the events page opened
      When I click on "<page>" navigation
      Then the required "<page>" opens
      Examples:
        |     page      |
        | Main_page     |
        | Communities   |
        | Events        |
        | Calendar      |
        | Videos        |
        | Speakers      |
        | Articles      |
        | Login         |

      Scenario Outline: Search for events with speaker filter
        Given the events page opened
        When I click on More Filters
        And I click the Speaker filter
        And I type "<name>" in filter search
        And I select each Speaker filter
        Then I see <label_num> "<type>" label
        And I see <card_num> card on Events
        Examples:
          |   name      | card_num |  label_num |  type    |
          |  Nikanchuk  | 1        |  1         |  Speaker |