# Event Planner

##### Epicodus Section: Java Week1: Behavior Driven Development 

### By Jessica Sheridan

## Description

This application is an event planner estimate for party planning services. A user will be
prompted with several questions about a party they are interested in having. Based on this
information, an estimate will be calculated. The options for the Event are defined in the
EventMenu class. The EventMenu class includes all the user options for the Event including
food, beverage, and entertainment. A corresponding costSheet in the EventMenu provides cost 
for each item. The Event class uses the costs outlined in the EventMenu to calculate the cost per person for
the event and the grand total less any valid coupon codes.

## Specifications:

| Behavior      | Input | Output |
| ------------- | ------------- | ------------- |
| determine cost for number of people | 50 | 250 |
| determine cost for number of people + light snacks  |  [50,apps]| 400 |
| determine cost for number of people,light snacks,nonalcoholic |[50,apps, nonalcoholic] | 450 |
| determine cost with entertainment included |[50,apps,wine,DJ] | 1200 |
| determine cost with 20% discount coupon |[50,apps,wine,DJ,20%off] |  |
| determine cost with free DJ coupon |[50,apps,wine,DJ,freeDJ] |  |

## Setup
git clone https://github.com/jessicakenney/event-planner.git  

## Support and Contact details
email with any questions: jessicakenney@yahoo.com,

## Known Issues/Bugs

## Technologies Used
JavaScript and jQuery

### Legal
This software is licensed under MIT Copyright (c) 2017 Jessica Sheridan
