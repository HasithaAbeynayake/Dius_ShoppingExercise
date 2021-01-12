# Dius_ShoppingExercise
Checkout system for DiUS exercise

## How to Test the Application

### Go to the test package and run the ShoppingCartTest unit tests

## Covered Tests
1. SKUs Scanned: atv, atv, atv, vga Total expected: $249.00
2. SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd Total expected: $2718.95
3. SKUs Scanned: mbp, vga, ipd Total expected: $1949.98
4. Null values should yield an exception

## Application Design

### Simple POJO design - using SOLID pattern
### Coding for interfaces - Use of interface to add common method for all offers

## Package structure
1. Model package
    - Product class: use of enums to add the given products
        i. Pre-defined list of values
        ii. Increase compile time checking
        iii. Avoid passing invalid constants
    - Stock class: to return the price for each product
    
2. Service package
    - StockService: Assign special offer handlers to specific products and insert the pre-defined stocks with base
     prices to the service.
    - CheckoutService: Apply the offers to the selected products at checkout to calculate the discounted price.
    
3. Handler package
    - SpecialOffers interface - to re-use code by adding the common applyOffer() method
    - BuyMoreGetFreeOfferHandler - To incorporate Buy X amount and only pay for X-1 amount
    - BulkBuyingDiscountHandler - To incorporate bulk buying discount
    - FreeStockHandler - To incorporate buy X product and get Y product free.
    
4. ShoppingCart class - Main class used calculate the final price

## Further improvements possible

### Coding using TDD pattern - Add more test cases while coding the application
### Make the system more interactive by enabling user to communicate via command prompt or a GUI
### Adding a MySQL database and use a react frontend and spring-boot backend to make the application more full-stack
