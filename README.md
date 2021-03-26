## Requirements

Using Feign and Eureka, complete the following:

1. Refactor your labs from the previous set of labs to use feign instead of RestTemplates

2. Build the following

   - A service with a database that stores product names and prices in USD. With a simple GET by id route.
   - A service without a database with a single route that takes in a price in USD and a currency and returns the price in the new currency (you may approximate the exchange rate)
   - An edge service with a single GET route that takes in a product id and currency and returns the product name and price in the specified currency.

3. 1. Build the following phoneNumber look-up service with ads

   - A service with a POST route to add new Advertisements and a GET route that serves up Advertisements at random from a list of ads (an Advertisements should have a vendor and adText)
   - A service with a POST route to add new people, a GET by name route and a GET by phone number route. (A person should have a name and phone number).
   - An edge service that returns a viewModel with an Advertisements and a Person when a Person is requested by phoneNumber or name. The edge service should also support the POST routes.