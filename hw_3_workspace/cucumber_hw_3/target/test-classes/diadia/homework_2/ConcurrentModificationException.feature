#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@homework_2
Feature: Gioco a DiaDia

  @stanza_buia
  Scenario: Entro nella stanza buia e raccolgo la lanterna
    Given Lancio DiaDia
    When Comando "vai sud"
		And Comando "prendi lanterna"
    And Comando "guarda"
    And Comando "fine"
    Then Posso leggere "Aula N10"
    And Posso leggere "buio pesto"
  