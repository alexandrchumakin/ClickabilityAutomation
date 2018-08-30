Feature: Content


  Scenario: C1099752 Check the features availability
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Add filter"
    And I am on page "Manage Filters"
    And I check "All Fields"
    And I click on "Update Filters"
    And I am on page "Contents"
    Then I should see row 1 in grid "Content List" with
    | Content Type |
    | All Fields   |
    And I should see "Create New Content" enabled
    And I should see "Copy" enabled
    And I should see "Trash" enabled


  Scenario: C1099753 Create a new content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Create New Content"
    And I am on page "Select Template"
    And I fill in "Filter" with "subhadra"
    And I click on "subhadra (Area 51 Article)"
    And I click on "Select"
    And I am on page "Content Editor"
    Then Canvas is not empty
    When I fill in "Title" with "TestContent01"
    And I click on "Category"
    And I am on page "Category"
    And I select "Standard" from "Area 51 Content"
    And I click on "Save"
    And I am on page "Save Options"
    And I fill in "Comments" with "test comments"
    And I click on "Save"
    And I am on page "Contents"
    And I click on "Edit Date"
    And I click on "Edit Date"
    And I should see row 1 in grid "Content List" with
      | Title         |
      | TestContent01 |


  Scenario: C1099786 Different content field association with content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Create New Content"
    And I am on page "Select Template"
    And I fill in "Filter" with "All Fields"
    And I click on "Dest (All Fields)"
    And I click on "Select"
    And I am on page "Content Editor"
    And I fill in "Title" with "TestContent02"
    And I fill in "ewqw" with "test"
    And I click on "more options"
    And I am on page "Distribution Schedule"
    And I check "www.area51orca.com (/)"
    And I click on "Close"
    And I am on page "Content Editor"
    And I click on "Media"
    And I am on page "Media"
    And I click on "Media Placement"
    And I click on "Audio - No Assignment"
    And I am on page "Media Placements - Audio (Audio)"
    And I fill in "Name" with "mozart_minuet"
    And I click on "Search"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Image - No Assignment"
    And I am on page "Media Placements - Image (Images)"
    And I fill in "Name" with "jpg284"
    And I click on "Search"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Category"
    And I am on page "Category"
    And I select "Standard" from "Area 51 Content"
    And I select "Orca" from "Area 51 Media"
    And I select "Application" from "Topic"
    And I select "test" from "media-category"
    And I click on "Calendar"
    And I am on page "Calendar"
    And I click on "Add Schedule"
    And I am on page "Assigned Category"
    And I click on "Add"
    And I click on "OK"
    And I am on page "Calendar"
    And I click on "Subscriptions"
    And I am on page "Subscription"
    And I check "Fixed"
    And I click on "Packages"
    And I am on page "Packages"
    And I check "bulk media testing Package"
    And I click on "Save"
    And I am on page "Save Options"
    And I fill in "Comments" with "test comments"
    And I click on "Save"
    And I am on page "Contents"
    And I refresh current page
    And I should see row 1 in grid "Content List" with
      | Title         |
      | TestContent02 |




  Scenario: C1099754 Media association with content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Create New Content"
    And I am on page "Select Template"
    And I fill in "Filter" with "All Fields"
    And I click on "All media fields in canvas (All Fields)"
    And I click on "Select"
    And I am on page "Content Editor"
    And I fill in "Title" with "TestContent03"
    And I click on "Media"
    And I am on page "Media"
    And I click on "Media Placement"
    And I click on "testNewUI - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Image - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Audio - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Video - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Doc - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Binary - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "AdImages - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "AdFlash - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "sizecheck - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "sub-audio - No Assignment"
    And I am on page "Media Placements"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Category"
    And I am on page "Category"
    And I select "Application" from "Topic"
    And I select "test" from "media-category"
    And I click on "Save"
    And I am on page "Contents"
    And I refresh current page
    And I should see row 1 in grid "Content List" with
      | Title         |
      | TestContent03 |


  Scenario: C1099755 target content and publish it
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Create New Content"
    And I am on page "Select Template"
    And I fill in "Filter" with "Zonkeymedia"
    And I click on "Zonkeymedia (Area 51 Article)"
    And I click on "Select"
    And I am on page "Content Editor"
    And I fill in "Title" with "TestContent04"
    And I fill in "ewqw" with "test"
    And I click on "more options"
    And I am on page "Distribution Schedule"
    And I check "www.area51orca.com (/)"
    And I click on "Close"
    And I am on page "Content Editor"
    And I click on "Media"
    And I am on page "Media"
    And I click on "Media Placement"
    And I click on "Audio - No Assignment"
    And I am on page "Media Placements - Audio (Audio)"
    And I fill in "Name" with "mozart_minuet"
    And I click on "Search"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Thumbnail - No Assignment"
    And I am on page "Media Placements"
    And I fill in "Name" with "jpg284"
    And I click on "Search"
    And I check "radio"
    And I click on "Select and Close"
    And I am on page "Media"
    And I click on "Category"
    And I am on page "Category"
    And I select "Standard" from "Area 51 Content"
    And I click on "Subscriptions"
    And I am on page "Subscription"
    And I check "Fixed"
    And I click on "Packages"
    And I am on page "Packages"
    And I check "bulk media testing Package"
    And I click on "Save"
    And I am on page "Save Options"
    And I fill in "Comments" with "test comments"
    And I click on "Save"
    And I am on page "Contents"
    And I refresh current page
    And I should see row 1 in grid "Content List" with
      | Title         |
      | TestContent04 |




  Scenario: C1099756 Editing a content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on row with "TestContent04" in column "Title" in grid "Content List"
    And I am on page "Content Editor"
    And I click on "Packages"
    And I am on page "Packages"
    And I check "PP2 in progress"
    And I click on "Save"
    And I am on page "Save Options"
    And I fill in "Comments" with "test comments"
    And I click on "Save"
    And I am on page "Contents"
    And I refresh current page
    And I should see row 1 in grid "Content List" with
      | Title         |
      | TestContent04 |




  #Scenario: C1099757 copying a content
  #  Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
  #  When I am on page "Contents"
  #  And I select row with "TestContent04" in column "Title" in grid "Content List"
  #  And I click on "Copy"
  #functionality is broken


  Scenario: C1099758 Deleting a content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I select row with "TestContent04" in column "Title" in grid "Content List"
    And I click on "Trash"
    And I am on page "Delete Confirmation"
    And I click on "OK"
    Then I should not see grid "Content List" with "TestContent04" in column "Title"


  Scenario: C1099760 Category association with content
    Given Login as QA Clone customer into "https://preview-ui.clickability.com/cm/content/#!/"
    When I am on page "Contents"
    And I click on "Create New Content"
    And I am on page "Select Template"
    And I fill in "Filter" with "1 subhadra"
    And I click on "1 subhadra (Area 51 Article)"
    And I click on "Select"
    And I am on page "Content Editor"
    And I click on "Category"
    And I am on page "Category"
    Then I should see "Area 51 Content" enabled
    And I should see "Area 51 Content Multi" enabled
    And I should see "Topic" enabled
    And I should see "Animal Type" enabled
    And I should see "Sandy Set" enabled
    And I should see "Test_A" enabled
    And I should see "Test_B" enabled


#  Scenario: C1099773 Previewing a content
#
