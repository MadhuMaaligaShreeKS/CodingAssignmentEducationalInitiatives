## Shopping Cart System<br/>

### Purpose<br/>
- This Shopping Cart System is designed to manage a shopping cart's functionality, including adding and removing products, calculating total costs, and applying various discount strategies. 
- The code emphasizes the use of object-oriented programming (OOP) principles and design patterns to ensure modularity, maintainability, and scalability.<br/>

## Key Functionalities <br/>

### Product Management:<br/>
1. *Add Products*: Users can add different types of products to the cart.<br/>
2. *Remove Products:* Users can remove products from the cart.<br/>
3. *Clone Products:* Products can be cloned when added to the cart to maintain separate instances.<br/>

### Discount Management:<br/>
1. *Apply Discounts:* Various discount strategies can be applied to the total bill.<br/>
2. *Discount Strategies:* Implemented strategies include first-time customer discounts and bulk purchase discounts.<br/>

### Total Calculation:<br/>
1. *Calculate Total:* The total cost of the items in the cart is calculated, including the applied discounts.<br/>

### Design Patterns Used<br/>

1. *Strategy Pattern:* <br/>

   *Purpose*: To define and use various discount strategies interchangeably.
   *Implementation*:DiscountStrategy interface defines a common method applyDiscount.Implementations include FirstTimeCustomerDiscount, BulkPurchaseDiscount, and NoDiscount. 
   <br/>

2. *Prototype Pattern:* <br/>
   
    *Purpose*: To clone product objects when adding them to the cart.
    *Implementation*:CartItem class implements the Cloneable interface.
    The clone method creates a copy of the CartItem object, including the product and its quantity.<br/>


### Object-Oriented Principles<br/>
1. *Encapsulation:*
All classes have private fields with public getter and setter methods to protect object state.
1. *Inheritance:*
Discount classes (FirstTimeCustomerDiscount, BulkPurchaseDiscount, and NoDiscount) inherit from the DiscountStrategy interface.<br/>

- *Product Class:*
    - Represents a generic product with attributes like name and price.<br/>
- *CartItem Class:*
    - Represents an item in the shopping cart, including the product and quantity.
    - Implements the Cloneable interface to support cloning.<br/>
- *ShoppingCart Class:*
    - Manages the list of CartItem objects.
    - Provides methods to add, remove, and calculate total cost of items in the cart.
    - Allows applying different discount strategies.<br/>

- *DiscountStrategy Interface:*
    - Defines a method applyDiscount for applying discounts.<br/>
- *Discount Strategy Implementations:*
    - FirstTimeCustomerDiscount: Applies a 10% discount.
    - BulkPurchaseDiscount: Applies a 15% discount.
    - NoDiscount: Applies no discount.
This system ensures a robust and flexible shopping cart management solution, leveraging object-oriented principles and design patterns to maintain high code quality and ease of future modifications