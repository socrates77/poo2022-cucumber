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
Feature: Entro nella stanza magica e gioco con osso fino a non poterlo raccogliere

  @stanza_magica
  Scenario: Entro nella stanza magica e gioco con osso
    Given Lancio DiaDia
    When Comando "prendi osso"
		And Comando "vai ovest"
    And Comando "vai sud"
    And Comando "posa osso" 
		And Comando "prendi osso"
		And Comando "posa osso"  
		And Comando "prendi osso"
		And Comando "posa osso" 
		And Comando "prendi osso"
		And Comando "posa osso" 
		And Comando "prendi osso"
		And Comando "posa osso" 
		And Comando "prendi osso"
		And Comando "posa osso" 
    And Comando "prendi osso"
    And Comando "fine"
    Then Posso leggere "Laboratorio IA"
    And Posso leggere "Non puoi trasportare osso"