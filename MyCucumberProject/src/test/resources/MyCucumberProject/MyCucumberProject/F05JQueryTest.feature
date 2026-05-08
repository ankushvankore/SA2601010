@AllLinks
Feature: JQuery Links test

  Background: 
    Given Open JQuery Site

	@DraggableTest
  Scenario: To validate Draggable Link
    When Click on Draggable Link
    Then Draggable page should open

	@DroppableTest
  Scenario: To validate Droppable Link
    When Click on Droppable Link
    Then Droppable page should open

	@ResizableTest
  Scenario: To validate Resizable Link
    When Click on Resizable Link
    Then Resizable page should open

	@SelectableTest
  Scenario: To validate Selectable Link
    When Click on Selectable Link
    Then Selectable page should open
