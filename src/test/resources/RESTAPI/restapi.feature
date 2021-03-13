Feature: https://github.com/public-apis/public-apis
  Scenario: https://github.com/davemachado/public-api
    #https://api.publicapis.org/
    #When I call Get to receive all "API" entries
    Then I call to get health status of the service
    When I call to get all the animals


    Scenario: https://jokeapi-v2.p.rapidapi.com/joke/Any
      When I call for the random joke, I get it