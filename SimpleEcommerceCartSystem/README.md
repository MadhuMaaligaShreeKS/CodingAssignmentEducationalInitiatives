# CodingAssignmentEducationalInitiatives

**Shopping Cart System**
**Purpose**
This Shopping Cart System is designed to manage a shopping cart's functionality, including adding and removing products, calculating total costs, and applying various discount strategies. The code emphasizes the use of object-oriented programming (OOP) principles and design patterns to ensure modularity, maintainability, and scalability.
**Key Functionalities**

**Product Management:**
Add Products:
 Users can add different types of products to the cart.
Remove Products: Users can remove products from the cart.
Clone Products: Products can be cloned when added to the cart to maintain separate instances.
Discount Management:
Apply Discounts: 
Various discount strategies can be applied to the total bill.
Discount Strategies: Implemented strategies include first-time customer discounts and bulk purchase discounts.
Total Calculation:
Calculate Total: The total cost of the items in the cart is calculated, including the applied discounts.


Design Patterns Used
**Strategy Pattern:**
Purpose: To define and use various discount strategies interchangeably.
Implementation:
DiscountStrategy interface defines a common method applyDiscount.
Implementations include FirstTimeCustomerDiscount, BulkPurchaseDiscount, and NoDiscount.
**Prototype Pattern:**
Purpose: To clone product objects when adding them to the cart.
Implementation:
CartItem class implements the Cloneable interface.
The clone method creates a copy of the CartItem object, including the product and its quantity.
Object-Oriented Principles
**Encapsulation:**
All classes have private fields with public getter and setter methods to protect object state.
**Inheritance:**
Discount classes (FirstTimeCustomerDiscount, BulkPurchaseDiscount, and NoDiscount) inherit from the DiscountStrategy interface.

**Product Class:**
Represents a generic product with attributes like name and price.
**CartItem Class:**
Represents an item in the shopping cart, including the product and quantity.
Implements the Cloneable interface to support cloning.
**ShoppingCart Class:**
Manages the list of CartItem objects.
Provides methods to add, remove, and calculate total cost of items in the cart.
Allows applying different discount strategies.

**DiscountStrategy Interface:**
Defines a method applyDiscount for applying discounts.
**Discount Strategy Implementations:**
FirstTimeCustomerDiscount: Applies a 10% discount.
BulkPurchaseDiscount: Applies a 15% discount.
NoDiscount: Applies no discount.

This system ensures a robust and flexible shopping cart management solution, leveraging object-oriented principles and design patterns to maintain high code quality and ease of future modifications