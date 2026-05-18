Feature: Fill TutorialsPoint Selenium Practice Form

@smoke
  Scenario: User fills the entire practice form successfully

#    Given user opens the browser

    Given user navigates to "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"

    When user reads test data from excel "TC02"

    # Name
    When user enters first name

    #Fill name from excel
    #When user enters name

    # Email
    And user enters email

    # Gender
    And user selects gender

    # Mobile Number
    And user enters mobile number

#    # Date of Birth
#    And user selects date of birth "23 January 1989"
#
#    # Subjects
   And user enters subject "Computer Science"
#
#    # Hobbies
    And user selects hobby "Reading"
#
#    # Picture Upload
#    And user uploads picture "C:\\Users\\User\\Desktop\\photo.jpg"
#
#    # Address
#    And user enters current address "Kolkata, West Bengal"
#
#    # State
#    And user selects state "Rajasthan"
#
#    # City
#    And user selects city "Kolkata"
#
#    # Submit
#    Then user clicks submit button
#
  #Examples:
#      | firstName | gender | mobileNum  | dOB        |
#      | Tananshi  | female | 9681153429 | 23-01-1989 |
#      | Sajwal    | male   | 9830162343 | 18-04-1989 |