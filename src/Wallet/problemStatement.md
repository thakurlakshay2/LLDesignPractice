# Flipkart Wallet System

## Overview
This project implements a digital wallet system similar to Flipkart's wallet functionality. The system allows users to manage their digital money, perform transactions, and track their transaction history.

## Features
1. User Registration
    - Users must register to create a wallet
    - Each user gets a unique wallet associated with their account

2. Money Loading
    - Support for multiple payment sources (Credit Card, Debit Card, UPI)
    - Minimum transaction amount enforcement
    - Simple integration with payment sources (mock implementation)

3. Wallet-to-Wallet Transfers
    - Send money to other registered users
    - Balance validation before transfer
    - Minimum transfer amount enforcement

4. Balance Management
    - Real-time balance checking
    - Support for both credit and debit transactions
    - Automatic balance updates after transactions

5. Transaction History
    - Comprehensive transaction tracking
    - Multiple filtering options:
        - Amount-based filtering
        - Date/time-based filtering
        - Transaction type filtering (send/receive)

## Technical Details

### Design Patterns Used
1. Repository Pattern
    - Clean separation of data access logic
    - Easily swappable data storage implementations

2. Strategy Pattern
    - Flexible payment processing for different sources
    - Extensible transaction filtering system

3. Factory Pattern
    - Centralized creation of transaction strategies
    - Easy addition of new payment methods

4. Facade Pattern
    - Simplified interface through WalletService
    - Encapsulated complex operations

### Key Components
- User Management
- Wallet Operations
- Transaction Processing
- History Management

## Getting Started
1. Clone the repository
2. Ensure you have Java 11 or higher installed
3. Run the Main class for a demonstration
4. Review the example usage in Main.java

## Example Usage
See Main.java for detailed examples of:
- Creating users and wallets
- Loading money
- Performing transfers
- Checking balances
- Retrieving transaction history

## Error Handling
The system includes comprehensive error handling for:
- Insufficient balance
- Invalid transaction amounts
- User not found scenarios
- Invalid payment sources

## Future Enhancements
1. Add support for scheduled transfers
2. Implement transaction rollback mechanisms
3. Add support for multiple currencies
4. Implement more sophisticated filtering options