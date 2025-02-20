@All
Feature: Register

  @Register
  Scenario Outline: Register with BDD
    Given when user is in the page
    When user click register link
    And user fill name <name>
    And user fill age <age>
    And user fill email <email>
    And user fill phone <phone>
    And user fill pass <pass>
    And user click register button
    Then user got message <result>

  Examples:
    | name | age | email | phone | pass | result |
    | maximan | 17 | maximan@gmail.com | 0815555411 | Password#123 | Your age should be at least around 18 - 45! |
    | Alex    | 18 | alex@gmail.com | 0898555413 | Password#123 | Register Success! |
    | John Cena | 45 | cenaofficial@gmail.com | 0896555537 | Password#123 | Register Success! |
    | Olatunji | 46 | olatunji@gmail.com | 0878555985 | Password#123 | Your age should be at least around 18 - 45! |
    | Olatunji Olajide olayinka alex william | 21 | ksiofficial@gmail.com | 08965556834 | Password#123 | Field name can only contains 35 characters! |
    | Simon Minter | 29 | simonminter@yahoo.com | 0819555492 | Password#123 | Your email format should be @gmail.com
    | Harry | 27 | harrylewis.com | 0854555895 | Password#123 | Your email format should be @gmail.com
    | Vikstar123 | 21 | test123@gmail.com | 0859555232 | Password#123 | Field name can only contains string
    | Joshua     | 31 | joshua@gmail.com  | 081955599  | Password#123 | Your number should be around 10 - 13 characters! |
    | Tobi Brown | 28 | tobibrown@gmail.com | 08115554071 | Password#123 | Register Success!                             |
    | Randy      | 30 | randydolp@gmail.com | 08785558822456 | Password#123 | Your number should be around 10 - 13 characters! |
    | Ethan Bezh | 29 | bezhinga@gmail.com  | 4455555631773  | Password#123 | Your number format doesn't acceptable! |
    | Mandy      | 21 | tobibrown@gmail.com | 085657150024   | Password#123 | Your email already registered!         |
    | Lexyan     | 21 | lexlexy@gmail.com   | 085880046909   | Password123  | Password should be include capital, symbols, and number! |
    | Paul       | 24 | paul@gmail.com      | 08588004430    | pass123      | Password should be at least 8 characters!                |
