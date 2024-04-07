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
@homework_2
Feature: Lancio di DiaDia

  @guarda
  Scenario: Leggo il messaggio di uscita
    Given Lancio DiaDia
    When Comando "guarda"
    And Comando "fine"
    Then Posso leggere "Grazie di aver giocato"
    
  @vinci
  Scenario: Vado subito a nord e vinco
    Given Lancio DiaDia
    When Comando "vai nord"
    Then Posso leggere "Hai vinto"
    
  @fine
  Scenario: Chiudo subito il gioco
    Given Lancio DiaDia
    When Comando "fine"
    Then Posso leggere "Grazie di aver giocato"
    
  @sconfitta
  Scenario: Giro nel labirinto e perdo
    Given Lancio DiaDia
    When Ripeti "20" volte il comando "vai ovest"
    Then Posso leggere "Hai perso"
    
  @test_comandi
  Scenario Outline: Prova generale comandi
    Given Lancio DiaDia
    When Comando "<comando>"
    And Comando "fine"
    Then Posso leggere "<messaggio>"

	Examples:    
    | comando					| messaggio							|
    | prendi osso			| Hai preso osso				|
    | guarda					| Atrio									|
    | assaggia				| Comando sconosciuto 	|
    | vai							| Dove vuoi andare			|
    | vai sudest   		| Direzione inesistente	|
    