# Project 1

* [Product APIs](#product-apis)
  * [Get all with **price condition**](#get-all-products-with-price-condition)
  * [Get all with **price range**](#get-all-products-with-price-condition)

* [Cart APIs](#cart-apis)
  * [**Create** or **update** cart items](#create-or-update-cart-items)
  * [Get cart items by customer id and product name](#get-cart-items-by-customer-id-and-product-name)

* [Customer APIs](#customer-apis)
  * [Add new customer](#add-new-customer)

> Note: All example results are run with initialization data at application start

## Product APIs
### Get all products with **price condition**

Request parameters:
- price: numeric (required)
- condition: EQUAL | LESS_THAN | GREATER_THAN (required)

Example API
```
GET /api/v1/products/price-condition?price=5000&condition=EQUAL (success)

GET /api/v1/products/price-condition?price=5000&condition=GREATER_THAN (success)

GET /api/v1/products/price-condition?price=5000&condition=LESS_THAN (success)

GET /api/v1/products/price-condition?price=5000&condition=LESS_THA (error)

GET /api/v1/products/price-condition?price=0&condition=LESS_THAN (error)
```
Example

- Request

`GET /api/v1/products/price-condition?price=5000&condition=LESS_THAN`

- Response

```json
{
    "status": "success",
    "data": [
        {
            "productId": 16,
            "productName": "San pham 1",
            "type": "NaN",
            "size": "NaN",
            "price": 1000.0
        },
        {
            "productId": 17,
            "productName": "San pham 2",
            "type": "NaN",
            "size": "NaN",
            "price": 2000.0
        },
        {
            "productId": 18,
            "productName": "San pham 3",
            "type": "NaN",
            "size": "NaN",
            "price": 3000.0
        },
        {
            "productId": 19,
            "productName": "San pham 4",
            "type": "NaN",
            "size": "NaN",
            "price": 4000.0
        }
    ],
    "message": null
}
```

### Get all products with **price range**
Request parameters:
- min-price: numeric (optional)
- max-price: numeric (optional)

Example API
```
GET /api/v1/products/price-range (success)

GET /api/v1/products/price-range?min-price=2000 (success)

GET /api/v1/products/price-range?max-price=3000 (success)

GET /api/v1/products/price-range?min-price=2000&max-price=3000 (success)

GET /products/price-range?max-price=0 (error)
```
Example

- Request

`GET /api/v1/products/price-range?max-price=3000`

- Response

```json
{
  "status": "success",
  "data": [
    {
      "productId": 16,
      "productName": "San pham 1",
      "type": "NaN",
      "size": "NaN",
      "price": 1000.0
    },
    {
      "productId": 17,
      "productName": "San pham 2",
      "type": "NaN",
      "size": "NaN",
      "price": 2000.0
    },
    {
      "productId": 18,
      "productName": "San pham 3",
      "type": "NaN",
      "size": "NaN",
      "price": 3000.0
    }
  ],
  "message": null
}
```


## Cart APIs
### Create or update cart items
Example
- Request

```
POST /api/v1/cart
{
    "customerId": 11,
    "productId": 17 ,
    "quantity": 3
}
```
- Response
```json
{
    "status": "success",
    "data": {
        "id": 44,
        "cartId": 36,
        "productId": 17,
        "productName": "San pham 2",
        "quantityWished": 3,
        "dateAdded": "16:01:27 30-08-2022",
        "totalAmount": 6000.0
    },
    "message": null
}
```

### Get cart items by customer id and product name
Request parameters:
- customer-id: numeric (required)
- product-name: string (required)
- offset: numeric (required)
- limit: numeric (required)

Example APIs:
```
GET /api/v1/cart?customer-id=11&product-name=pham&offset=0&limit=3 (success)
GET /api/v1/cart?customer-id=11&product-name=phamn&offset=0&limit=3 (error)
GET /api/v1/cart?customer-id=12&product-name=San pham&offset=0&limit=3 (error)
```
Example:
- Request

`GET /api/v1/cart?customer-id=11&product-name=pham&offset=0&limit=3`

- Response

```json
{
    "status": "success",
    "data": {
        "cartId": 36,
        "products": [
            {
                "productId": 16,
                "productName": "San pham 1",
                "quantityWished": 2,
                "dateAdded": "15:27:17 30-08-2022",
                "totalAmount": 2000.0
            },
            {
                "productId": 18,
                "productName": "San pham 3",
                "quantityWished": 1,
                "dateAdded": "15:27:17 30-08-2022",
                "totalAmount": 3000.0
            },
            {
                "productId": 19,
                "productName": "San pham 4",
                "quantityWished": 3,
                "dateAdded": "15:27:17 30-08-2022",
                "totalAmount": 12000.0
            }
        ]
    },
    "message": null
}
```


## Customer APIs
### Add new customer
Example
- Request
```
POST /api/v1/customers
{
    "customerName": "Khach hang 11",
    "address": "Dia chi 11",
    "phoneNo": "Phone 11"
}
```
- Response

```json
{
    "status": "success",
    "data": {
        "customerId": 45,
        "customerName": "Khach hang 11",
        "address": "Dia chi 11",
        "phoneNo": "Phone 11",
        "cart": null
    },
    "message": null
}
```


