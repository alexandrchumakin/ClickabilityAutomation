Feature: Template

  Scenario: C1095588 Creation of a New Sub Template
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I select "Sub-template" from "Template Type"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName06"
    And I fill in "Description" with "TestDescription06"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I drag "UX sub template" to row 1 of canvas
    And I click on "Sub-Templates"
    And I click on "Widgets"
    And I drag "Set" to row 2 of canvas
    And I click on "Widgets"
    And I click on "HTML"
    And I drag "Button" to row 3 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Home...About...Contact...Crumb...Click!...cm-set...variable-name...expression"

  Scenario: C1095589 Creation of a New Content Template
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I select "Content Template" from "Template Type"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName07"
    And I fill in "Description" with "TestDescription07"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I drag "Author" to row 1 of canvas
    And I click on "Content Fields"
    And I click on "Sub-Templates"
    And I drag "UX sub template" to row 2 of canvas
    And I click on "Sub-Templates"
    And I click on "Widgets"
    And I drag "Set" to row 3 of canvas
    And I click on "Widgets"
    And I click on "HTML"
    And I drag "Button" to row 4 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Author...Home...About...Contact...Crumb...Click!...cm-set...variable-name...expression"

  Scenario: C1095590 Creation of a New Hub Template
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I select "Hub Template" from "Template Type"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName08"
    And I fill in "Description" with "TestDescription08"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I drag "UX sub template" to row 1 of canvas
    And I click on "Sub-Templates"
    And I click on "Widgets"
    And I drag "Set" to row 2 of canvas
    And I click on "Widgets"
    And I click on "HTML"
    And I drag "Button" to row 3 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Home...About...Contact...Crumb...Click!...cm-set...variable-name...expression"


  Scenario: C1095591-1 Check whether created Content templates can be edited.
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I refresh current page
    And I click on row with "TestName06" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
#    And I refresh current page
    And I click on "Page Components"
    And I am on page "Page Components"
    And I click on "HTML"
    And I drag "Link" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row with "TestName06" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Link"

  Scenario: C1095591-2 Check whether created Content templates can be edited.
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I refresh current page
    And I click on row with "TestName07" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
#    And I refresh current page
    And I click on "Page Components"
    And I am on page "Page Components"
    And I click on "HTML"
    And I drag "Link" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row with "TestName07" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Link"

  Scenario: C1095591-3 Check whether created Content templates can be edited.
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I refresh current page
    And I click on row with "TestName08" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
#    And I refresh current page
    And I click on "Page Components"
    And I am on page "Page Components"
    And I click on "HTML"
    And I drag "Link" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row with "TestName08" in column "Template Name" in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Link"


  Scenario: C1095592 Copying of a the existing Template
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I select row 1 in grid "Template List"
    And I click on "Copy"
    And I am on page "Copy Template"
    And I click on "OK"
    And I am on page "Template Builder"
    Then I should see "Name" with ""
    And I should see "Description" with ""
    And Canvas contains text "Link"


  Scenario: C1095593 Deleting of the existing Template
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I select row with "TestName08" in column "Template Name" in grid "Template List"
    And I click on "Trash"
    And I am on page "Delete Template"
    And I click on "OK"
    And I am on page "Templates"
    Then I should not see grid "Template List" with "TestName08" in column "Template Name"

  Scenario: C1095594 Check Content Fields and Media placements options under creation of content Template.
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName09"
    And I fill in "Description" with "TestDescription09"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I drag "Author" to row 1 of canvas
    And I click on "Media"
    And I am on page "Media"
    And I drag "header_logo" to row 2 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "Test Comments"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    Then Canvas contains text "Author"
    And Canvas contains image


  Scenario: C1095595 Usage of  HTML option under the Page components
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I select "Sub-template" from "Template Type"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName10"
    And I fill in "Description" with "TestDescription10"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I click on "Sub-Templates"
    And I click on "HTML"
    And I drag "Nav" to row 1 of canvas
    And I drag "Nav Bar" to row 1 of canvas
    And I drag "Button" to row 1 of canvas
    And I drag "Button Group" to row 1 of canvas
    And I drag "Breadcrumbs" to row 2 of canvas
    And I drag "Breadcrumb Item" to row 2 of canvas
    And I drag "Label" to row 2 of canvas
    And I drag "Text Input" to row 2 of canvas
    And I drag "Heading" to row 4 of canvas
    And I drag "Page Header" to row 5 of canvas
    And I drag "Link" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains text "Button 1Button 2Button 3Click!...Label...Crumb...Home /...Products /...Specials...Top of the mornin' to ya!...Heading...Brand...Home...About...Contact...Link"


  Scenario: C1095596 Usage of  Widgets option under the Page components
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I select "Sub-template" from "Template Type"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName11"
    And I fill in "Description" with "TestDescription11"
    And I click on "Page Components"
    And I am on page "Page Components"
    And I click on "Sub-Templates"
    And I click on "Widgets"
    And I drag "Set" to row 1 of canvas
    And I drag "For each" to row 3 of canvas
    And I drag "Conditional" to row 3 of canvas
    And I drag "Elseif" to row 1 of canvas
    And I drag "Else" to row 1 of canvas
    And I drag "Code" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "test"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
#bug is blocking, verify later
    Then Canvas contains widgets "cm-foreach,cm-set,cm-elseif,cm-code,cm-else,cm-conditional"

  Scenario: C1095597 Check whether media can be added to templates
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/design/#!/template/"
    When I am on page "Templates"
    And I click on "Create New Template"
    And I am on page "Create New Template"
    And I click on "Continue"
    And I am on page "Template Builder"
    And I refresh current page
    And I fill in "Name" with "TestName12"
    And I fill in "Description" with "TestDescription12"
    And I click on "Media"
    And I am on page "Media"
    And I select "Image" from "Media type"
    And I click on "Search"
    And I drag "header_logo" to row 2 of canvas
    And I select "Audio" from "Media type"
    And I click on "Search"
    And I drag "02 Track 2" to row 1 of canvas
    And I select "Video" from "Media type"
    And I click on "Search"
    And I drag "ROUND1" to row 1 of canvas
    And I click on "Save"
    And I am on page "Confirm Save"
    And I fill in "Comments" with "Test Comments"
    And I click on "Save"
    And I am on page "Templates"
    And I click on row 1 in grid "Template List"
    And I am on page "Template Builder"
    Then Canvas contains image
    And Canvas contains audio
    And Canvas contains video

