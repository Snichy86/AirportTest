Feature: United airlines page test

Scenario: Flight search test
  Given homepage
  When choose one-way flight
  And set flights From New York JFK to Miami all airports
  And choose departure date August 20
  And choose economy class
  And click Find flights
  And sort flights by Economy class
  Then collect and print Depart, Arrive, Stops, Duration, Price data