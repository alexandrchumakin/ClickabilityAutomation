Feature: Layout

  Background:
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/layout/"
    When I am on page "Layouts"

    Scenario: C1095582 Creating a new layout
      When I click on "Create New Layout"
      And I am on page "Layout Chooser"
      And I click on "New"
      And I am on page "Template Builder"
      And I fill in "Name" with "TestName01"
      And I fill in "Description" with "TestDescription01"
      And I drag "Grid Row" to row 1 of canvas
      And I drag "Grid Row" to row 2 of canvas
      And I drag "Grid Row" to row 3 of canvas
      And I drag "Grid Row" to row 4 of canvas
      And I click on "Save"
      And I am on page "Layouts"
      Then I should see grid "Layout List" with "TestName01" in row 1 column 1


    Scenario: C1095583 Editing of existing Layout
      When I click on row 1 in grid "Layout List"
      And I am on page "Layout Manager"
      And I fill in "Description" with "new description"
      And I click on "Save"
      And I am on page "Layouts"
      And I click on row 1 in grid "Layout List"
      And I am on page "Layout Manager"
      Then I should see "Description" with "new description"


    Scenario: C1095584 Check the usage of "Grid span" in Grid row pop up
      When I click on "Create New Layout"
      And I am on page "Layout Chooser"
      And I click on "New"
      And I am on page "Template Builder"
      And I fill in "Name" with "TestName02"
      And I fill in "Description" with "TestDescription02"
      And I drag "Grid Row" to row 1 of canvas
      And I click "Properties" icon for span in row 1 column 1 in canvas
      And I fill in grid span attribute "Id" with "test_id"
      And I close grid span
      And I click on "Save"
      And I am on page "Layouts"
      And I click on row 1 in grid "Layout List"
      And I am on page "Layout Manager"
      And I click "Properties" icon for span in row 1 column 1 in canvas
      Then I should see grid span attribute "Id" with "test_id"

    Scenario: C1095585 Check whether drag and dropping is happening in the work space as well.
      When I click on "Create New Layout"
      And I am on page "Layout Chooser"
      And I click on "New"
      And I am on page "Template Builder"
      And I fill in "Name" with "TestName03"
      And I fill in "Description" with "TestDescription03"
      And I drag "Grid Row" to row 1 of canvas
      And I drag "Grid Row" to row 1 cell 1 of canvas
      And I drag "Grid Row" to row 1 cell 2 of canvas
      And I drag "Grid Row" to row 1 cell 3 of canvas
#(later) then copy 1st row and drag inner cells of row 2 to inner cells of row 1 - and verify that

    Scenario: C1095586 Check whether Import layouts is happening or not
      When I click on "Import Layout"
      And I am on page "Layout Chooser"
      And I select row with "Content Detail Layout" in column "Name" in grid "System Layout List"
      And I click on "Import Selected Layouts"
      And I am on page "Layouts"
      Then I should see grid "Layout List" with "Content Detail Layout" in column "Name"

#
#     Scenario: C1095587 Check the features availability
#     #Not an auto test
