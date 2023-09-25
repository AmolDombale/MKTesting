Feature: Test data table

  Scenario: signgle row with no heards
    Given user enter username and pwd
      | AmolDombale | Amol@5793 |
    When user hover mous on contact
    When user select new contact
    When user fill new conatct form
      | Mr. | Ganesh | daad | Gharat | MD | Ganu | 89098 | xyz@gmail.com |
    When User clicked on save

  
