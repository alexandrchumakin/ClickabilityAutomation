Feature: ResourceBundle

  Background:
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/"
    When I am on page "Templates"

  Scenario: C1095574 Verification of Templates page opening
    Then I should see grid "Template List" with "TEMPLATE NAME" column

  Scenario: C1095575 Verification of Design bundle page opening
    When I click on "Design Bundles"
    And I am on page "Design Bundles"
    Then I should see grid "Bundle List" with "Design Bundle Name" column

  Scenario: C1095576 creating new RB
    When I click on "Design Bundles"
    And I am on page "Design Bundles"
    And I click on "Create New Bundle"
    And I am on page "Design Manager"
    And I fill in "Name" with "TestName1"
    And I fill in "Description" with "TestDescription1"
    And I click on "Save"
    And I am on page "Save your Design Bundle Changes"
    And I fill in "Comments" with "TestComment1"
    And I click on "Save"
    And I am on page "Design Bundles"
    And I click on "View all"
    Then I should see grid "Bundle List" with "TestName1" in column "Design Bundle Name"

  Scenario: C1095577-1 error messages for mandatory fields
    When I click on "Design Bundles"
    And I am on page "Design Bundles"
    And I click on "Create New Bundle"
    And I am on page "Design Manager"
    And I click on "Save"
    Then I should see "Error message" with "Error occured while saving design bundle"
    And I should see "Name" highlighted
    And I should see "Description" highlighted

  Scenario:  C1095577-2  save completion messages
    When I click on "Design Bundles"
    And I am on page "Design Bundles"
    And I click on "Create New Bundle"
    And I am on page "Design Manager"
    And I fill in "Name" with "TestName2"
    And I fill in "Description" with "TestDescription2"
    And I click on "Save"
    And I am on page "Save your Design Bundle Changes"
    And I fill in "Comments" with "TestComment2"
    And I click on "Save"
#    Then  no success??

  Scenario: C1095578 Assigning RB to different environment
    When I click on "Design Bundles"
    And I am on page "Design Bundles"
    And I click on row 1 in grid "Bundle List"
    And I am on page "Design Manager"
    And I click on "Save"
    And I am on page "Save your Design Bundle Changes"
    And I fill in "Comments" with "test comment"
    And I check "Assign to Development Environment"
    And I check "Assign to Staging Environment"
    And I click on "Save"
    And I am on page "Design Bundles"
    And I click on row 1 in grid "Bundle List"
    And I am on page "Design Manager"
    And I click on "History"
    And I am on page "Bundle History"
    Then I should see row 1 in grid "History" with
      | D S P     | REMARKS     |
      | on on off | test comment|


  Scenario: C1095579 Mapping RB to different template
    When I click on "Create New Template"
    And I am on page "Create New Template"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I fill in "Name" with "testname 04"
    And I fill in "Description" with "testdescription 04"
    And I click on "Resource bundle"
    And I am on page "Template Resources"
    And I click on "Add"
    And I am on page "Add Resources"
    And I select row 1 in grid "Available Bundle List"
    And I click on "Add Resources"
    And I am on page "Template Resources"
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test comments"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    And I click on "Resource bundle"
    And I am on page "Template Resources"
    Then I should see grid "Assigned Bundle List" not empty


  Scenario: C1095580  Editing already mapped RB to different template
    When I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    And I double click on "Resource bundle"
    And I am on page "Template Resources"
    And I select row 1 in grid "Assigned Bundle List"
    And I click on "Remove"
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test comments"
    And I check "Assign to Development Environment"
    And I click on "Save"
    And I am on page "Templates"
    And I click on "Design Bundles"
    And I am on page "Design Bundles"
    And I click on row 1 in grid "Bundle List"
    And I am on page "Design Manager"
    And I click on "Usage"
    And I am on page "References"
    Then I should see grid "Bundle Usage Entity List" empty

