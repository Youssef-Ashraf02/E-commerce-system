# E-commerce-system


## 🛒 Overview

This Java project simulates an e-commerce platform where customers can:
- Add products to their cart
- Check product availability
- Handle expirable items (e.g., Cheese, Biscuits)
- Calculate shipping fees based on product weight ranges
- Complete checkout with detailed summaries

The system uses **object-oriented design** principles and demonstrates:
- Inheritance and interface composition
- Factory Pattern for product instantiation
- Service layer abstraction

---

## ✨ Features

✅ Define products with:
- Name
- Price
- Quantity
- Optional expiration date
- Optional shipping weight

✅ Support for:
- Expirable products (`Expirable`)
- Shippable products (`Shippable`, `ShippingItem`)

✅ Cart Management:
- Add products to cart with quantity validation
- Prevent adding more than available stock

✅ Checkout Process:
- Validate cart is not empty
- Check for expired products
- Verify sufficient customer balance
- Calculate dynamic shipping fees:

| Weight Range (kg) | Shipping Fee per kg |
|-------------------|---------------------|
| 0 - 5             | $5                  |
| >5 - 20           | $8                  |
| >20               | $15                |

- Deduct stock and balance
- Print a detailed checkout summary

✅ Shipping Service:
- Collect all shippable items
- Process shipping via ShippingService

---

## 📂 Project Structure

```
src/
└── com/
    └── src/
            ├── Main.java
            ├── model/
            │   ├── Product.java
            │   ├── Biscuit.java
            │   ├── Cheese.java
            │   ├── TV.java
            │   ├── Mobile.java
            │   ├── MobileScratchCard.java
            │   ├── CartItem.java
            │   └── Cart.java
            │   └── Customer.java
            ├── factory/
            │   └── ProductFactory.java
            ├── service/
            │   ├── CheckoutService.java
            │   └── ShippingService.java
            └── interfaces/
                ├── Expirable.java
                ├── Shippable.java
                └── ShippingItem.java
```

---

## ⚙️ How to Run

1. **Compile the project:**
   ```bash
   javac -d out src/com/src/**/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp out com.src.Main
   ```

3. You will see a checkout summary printed to the console.

---

## 💡 Example

When a customer buys Cheese (2kg), TV (20kg), and a Scratch Card, the system will:
- Calculate subtotal
- Apply shipping fees based on weight (e.g., total 22kg → $12/kg)
- Print a summary like:

```
==============================================
 Checkout Summary
==============================================
Customer Name    : Alice
Subtotal         : $2250.00
Shipping Fees    : $264.00
Total Paid       : $2514.00
Remaining Balance: $2486.00
==============================================
 Thank you for your purchase!
==============================================
```

---

## 🧩 Extending the Project

You can further improve the system by:
- Adding discount strategies
- Supporting payment gateways
- Persisting orders to a database
- Exposing REST APIs
- Implementing unit tests for business logic

---

## 📄 License

This project is provided as-is for educational purposes.
