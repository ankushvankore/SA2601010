#Demo for Passing the data to Step Definition via .feature file
Feature: Automobile Test

  Scenario: To validate automobile test
    Given Launch Tricentis Insurance Application
    When Click on Automobile link
    When Select make as "Suzuki"
    When Enter engine performance as "1000"
    When Enter date of manifacture as "05/01/2026"
    When Select no of seats as "3"
    When Select Fuel type as "Petrol"
    When Enter List price as "10000"
    When Enter Licence plate no as "MH09GF1246"
    When Enter annual milage as "10000"
