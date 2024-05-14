Feature: Speakers page

  Scenario Outline: Search for speakers
    Given the speakers portal is opened
    When I click the speakers search bar
    And I type "<search-term>" in speakers search
    Then I see the "<card-titlex>" card on Speakers Page
    And I see <count> speaker cards
    Examples:
      | search-term | card-titlex  | count   |
      | maxim       | Maxim Batalin | 16      |
      | adam        | Adam Auerbach  | 16      |
      | peter       | Pal Peter | 10      |
  Scenario Outline: Search for tags
    Given the speakers portal is opened
    When I click the tags search Button
    And I click into the tags search Bar
    And I type "<search-term>" in tags search
    Then I see the "<label>" label on Speakers Page
    Examples:
      | search-term | label|
      | polish       | Polish|
      | french        | French|
      | english       | English|