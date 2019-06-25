# Associate level technical test

## How to run it

1. Run spring-boot:run on your terminal
2. Open Postman and send GET request to: [localhost:8080/exchange/gbp-to-usd/VALUE](localhost:8080/exchange/gbp-to-usd/VALUE)
replacing VALUE with the amount you want to convert
3. In the response you should receive JSON:

`{
     "gbp": 1,
     "usd": 1.3,
     "exchangeRate": 1.3
 }` 
