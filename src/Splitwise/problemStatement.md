# Expense Sharing Application

## Problem Statement

Create an expense sharing application where users can add their expenses and split them among different people. The app should keep track of balances between people, indicating who owes how much to whom.

## Requirements

- **User**: Each user should have a userId, name, email, and mobile number.
- **Expense**: Could be EQUAL, EXACT, or PERCENT.
- Users can add any amount, select any type of expense, and split it with any available users.
- The percent and amount provided could have decimals up to two decimal places.
- Verify if the total sum of percentage shares is 100 for percent expenses, or if the sum of shares equals the total amount for exact expenses.
- The application should have the capability to show expenses for a single user as well as balances for everyone.
- Balances should be rounded off to two decimal places.
- Input:
    - Expense format: EXPENSE <user-id-of-person-who-paid> <no-of-users> <space-separated-list-of-users> <EQUAL/EXACT/PERCENT> <space-separated-values-in-case-of-non-equal>
    - Show balances for all: SHOW
    - Show balances for a single user: SHOW <user-id>
- Output:
    - When asked to show balance for a single user, display all the balances that user is part of in the format: `<user-id-of-x> owes <user-id-of-y>: <amount>`
    - If there are no balances for the input, print "No balances"
    - In cases where the user for which balance was asked for owes money, they’ll be x. They’ll be y otherwise.

## Expectations

- Working and demonstrable code
- Functionally correct
- Modular and readable code
- Separation of concerns addressed
- No single-file code
- Easily accommodates new requirements and minimal changes
- Includes a main method for easy testing
- Optional: Write unit tests
- No GUI required

## Optional Requirements

- Add an expense name while adding the expense, and optionally add notes, images, etc.
- Option to split by share, such as: 'User4 pays and everyone splits equally. You pay for 2 people.' This could be added as: `u4 1200 4 u1 u2 u3 u4 SHARE 2 1 1 1`
- Show a passbook for a user, displaying all the transactions they were part of.
- Option to simplify expenses. When simplify expenses is turned on (is true), the balances should get simplified. For example, 'User1 owes 250 to User2 and User2 owes 200 to User3' should simplify to 'User1 owes 50 to User2 and 200 to User3'.

