#Author: ale.manias@stud.uniroma3.it
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
@homework_3
Feature: Test homework_3

  @vado @nord
  Scenario: Vado a nord e vinco subito con labirinto standard.
    Given Crea Labirinto Standard
    And Lancio DiaDia
    When Comando "vai nord"
    Then Posso leggere "Hai vinto"

  Scenario: Guardo oggetti vado a nord e vinco
		Given Crea Labirinto
		  * Aggiungi Stanza Iniziale "Atrio" 
			* Aggiungi Oggetto "osso"
			* Aggiungi Oggetto "piedediporco"
			* Aggiungi Stanza Vincente "Biblioteca" 
			* Aggiungi Oggetto "osso"
			* Aggiungi Oggetto "piedediporco"
			* Aggiungi Adiacenza "Atrio" "Biblioteca" "nord"
			* Lancio DiaDia
		When Comando "guarda"
		 And Comando "vai nord"
		Then Posso leggere "osso" 
		 And Posso leggere "Hai vinto"