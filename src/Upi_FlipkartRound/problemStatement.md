# Flipkart UPI Design

## Background

Flipkart is aiming to enter the UPI (Unified Payments Interface) market to enhance its financial ecosystem and improve customer convenience. By integrating UPI, Flipkart can:

- Streamline payment processes
- Reduce dependency on third-party payment gateways
- Leverage India's growing digital payment landscape

This move aligns with Flipkart's strategy to offer a seamless and integrated shopping experience, fostering customer loyalty and driving higher transaction volumes. To achieve these goals, Flipkart intends to integrate with a Payment Service Provider (PSP) layer to process UPI transactions securely and efficiently, ensuring real-time payment confirmations without excess regulatory overheads.

---

## Objective

Design and implement the Flipkart UPI system.

---

## Features

### 1. **User Onboarding**
- Users can be onboarded by providing relevant details:
    - Name
    - Phone number
    - Active/Inactive status

### 2. **List of Registered Banks**
- Maintain a list of registered banks with the following fields:
    - Bank name
    - Server status (up/down)
- Bank account linking can only be done for registered banks.

### 3. **Linking a Bank Account**
- Users can link multiple banks to their accounts.
- Bank details:
    - Bank name
    - Bank account number
    - Bank balance (initializable)
- A primary bank account must be linked to a phone number.

### 4. **Making a Payment**
- Users can make payments to another user by providing:
    - Username
    - Phone number
    - Bank account
- Conditions:
    - Deduct balance from sender's account.
    - Add balance to receiver's account.
    - Payments can only be made from an active account.
    - Payments to inactive accounts should throw relevant errors.
    - Insufficient balance should throw proper exceptions.
    - If a bank server is down, no bank or payment operations should be allowed.

### 5. **Handling Concurrency**
- Transactions should handle concurrency to ensure data consistency and integrity.

### 6. **Transaction History**
- Users can view transactions at two levels:
    1. Bank account level
    2. User level (cumulative for all accounts)
- Include details of amounts paid and received.
- Allow searching transactions by payer/payee.

### Bonus Features
- Search transactions by:
    - Dates
    - Transaction status
- Handle pending payment transactions:
    - PSP layer may return a pending status for a transaction.
    - Retry mechanism should handle edge cases, ensuring updates within 120 seconds.

---

## Important Cases

1. **Unique Phone Number and User Account Linking**
    - A phone number cannot be linked to more than one user account.

2. **Unique Bank Account Linking**
    - A bank account cannot be linked to more than one user account.

3. **Account Activation/Deactivation**
    - A user account can be marked as activated or deactivated.

4. **Payment Validations**
    - Ensure the sender's account is active.
    - Payments to inactive accounts should fail.
    - Handle insufficient balance exceptions.
    - Disallow operations if a bank server is down.

5. **Testing Payment Operations**
    - Add 3 seconds of sleep time for testing purposes.

---

## Other Notes

1. **Payment and Bank Operations**
    - All payment and bank-related transactions should interact with the PSP interface.
    - Bank list and status services should be separate for configuration and testing.

2. **Driver Class/Test Cases**
    - Include a driver class or test cases to demonstrate functionality.

3. **Implementation Requirements**
    - No need for a REST API.
    - Functional completeness is essential.
    - Bonus features are optional.
    - Ensure clean interface design for the module.
    - Internal design and implementation should be clean and extensible.
    - Handle exceptions and corner cases.
    - Include test cases covering various scenarios.

4. **Language and Storage**
    - Use any Object-Oriented language.
    - Use in-memory data structures for storing data.

---

## Deliverables
- Demoable code showcasing the functionalities mentioned above.
- Functional completeness with clean and extensible design.
- Test cases for validations, concurrency, and edge cases.
- Exception handling for all important scenarios.
