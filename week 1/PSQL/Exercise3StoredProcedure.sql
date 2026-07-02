-- SCENARIO 1: The bank needs to process monthly interest for all savings accounts.
-- Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.
-- Solution:
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
UPDATE accounts
SET balance = balance + (balance * 0.01)
WHERE account_type = 'SAVINGS';

COMMIT;
END;
/
-- SCENARIO 2: The bank wants to implement a bonus scheme for employees based on their performance.
-- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.
-- Solution:


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
p_department_id IN employees.department_id%TYPE,
p_bonus_percent IN NUMBER
)
IS
BEGIN
UPDATE employees
SET salary = salary + (salary * p_bonus_percent / 100)
WHERE department_id = p_department_id;

COMMIT;
END;
/
-- SCENARIO 3: Customers should be able to transfer funds between their accounts.
-- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
-- Solution:


CREATE OR REPLACE PROCEDURE TransferFunds (
p_from_account IN accounts.account_id%TYPE,
p_to_account   IN accounts.account_id%TYPE,
p_amount       IN NUMBER
)
IS
v_balance accounts.balance%TYPE;
BEGIN
SELECT balance INTO v_balance
FROM accounts
WHERE account_id = p_from_account
FOR UPDATE;

IF v_balance >= p_amount THEN

UPDATE accounts
SET balance = balance - p_amount
WHERE account_id = p_from_account;

UPDATE accounts
SET balance = balance + p_amount
WHERE account_id = p_to_account;

COMMIT;

ELSE
RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
END IF;

END;
/
