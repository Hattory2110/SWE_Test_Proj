Feature: Events page


  Scenario Outline: Search for Events
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
    And I see the "<card-title>" card on Events Page
    And I see <card_num> card on Events
    Examples:
      |   name      | card_num |     card-title             | label_num |  type    |
      |  Nikanchuk  | 1        |  Spanish Speaking Events   | 1         |  Speaker |

  Scenario Outline: Search for events with event format filter
    Given the events page opened
    When I click on More Filters
    And I click on Event format
    And I select "<filter_name>" format filter
    Then I see the "<card-title>" card on Events Page
    And I see <card_num> card on Events
    Examples:
      |       filter_name      | card_num |                      card-title                        |
      | Online only            |    66    | Spanish Speaking Events                                |
      | Offline with streaming |    4     | Primer encuentro Club de Lectura                       |
      | Offline only           |    18    | Polish Conversation Club in Wroclaw (offline meetings) |

  Scenario Outline: Search for events with language filter
    Given the events page opened
    When I click on More Filters
    And I click Language filter
    And I select "<filtered_language>" language
    Then I see the "<card-title>" card on Events Page
    And I see <card_num> card on Events
    Examples:
      |   filtered_language    | card_num |           card-title                  |
      | Belarusian             |    1     | WBC: Board Games Wroclaw              |
      | Hungarian              |    1     | Coolest Projects Hungary 2024. tavasz |
      | Spanish                |    4     | Spanish Speaking Events               |

  Scenario Outline: Search for events with event status filter
    Given the events page opened
    When I click on More Filters
    And I click on Event status
    And I select "<filter_name>" status filter
    Then I see the "<card-title>" card on Events Page
    And I see <card_num> card on Events
    Examples:
      |       filter_name              | card_num   |          card-title            |
      | Free registration is available |    81      | Spanish Speaking Events        |
      | Call for speakers is open      |    3       | AWS User Group 3city meetup #7 |
      | Voting for talks is open       |    0       |                                |