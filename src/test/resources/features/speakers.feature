Feature: Speakers page

  Scenario Outline: Search for speakers
    Given the speakers portal is opened
    When I click the speakers search bar
    And I type "<search-term>" in speakers search
    Then I see the "<card-title>" card on Speakers Page
    And I see <count> speaker cards
    Examples:
      | search-term | card-title  | count   |
      | maxim       | Maxim Batalin | 16      |
      | adam        | Adam Auerbach  | 16      |
      | peter       | Pal Peter | 10      |
