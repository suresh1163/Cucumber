$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Sameple1.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "customer is on Booking page",
  "keyword": "Given "
});
formatter.match({
  "location": "oneDimensional.customer_is_on_Booking_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "customer enters booking details with firstname lastname  email address mobno",
  "rows": [
    {
      "cells": [
        "suresh",
        "d",
        "suresh@gmail.com",
        "chennai",
        "123456789"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "oneDimensional.customer_enters_booking_details_with_firstname_lastname_email_address_mobno(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "custoomer will get customer ID",
  "keyword": "Then "
});
formatter.match({
  "location": "oneDimensional.custoomer_will_get_customer_ID()"
});
formatter.result({
  "status": "passed"
});
});