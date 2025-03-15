# stub-service

## Overview
The Stub Service API is designed to provide a simple and flexible way to mock and stub HTTP endpoints for testing purposes. This API supports CRUD operations on entities and allows for dynamic and customized responses.

This service is an implementation of the WireMock extension `ResponseDefinitionTransformerV2`. It allows us to create dynamic and customized responses for various CRUD operations. By leveraging this extension, we can define stub responses that cater to specific requirements and scenarios, enhancing the flexibility and functionality of our testing environment.

## Purpose
The primary purpose of this service is to support stub responses for CRUD (Create, Read, Update, Delete) operations. We can use this service to perform operations such as store, retrieve, delete & update on any kind of objects with the help of stub APIs. 

## Installation
Clone the repository:
```sh
git clone https://github.com/anilkumbhar5418/stub-service.git
cd stub-service
```

Build the project:
```sh
mvn clean install
```

Run the application:
```sh
mvn exec:java -Dexec.mainClass="com.ak.stub.StubService"
```

## API Endpoints

### Create Entity
- **Method:** POST
- **URL:** `/entity/create`
- **Request Body:**
  ```json
  {
    "name": "John Doe",
    "address": "123 Main St"
  }
  ```
- **Response:**
    - **Status:** 200
    - **Body:**
      ```json
      {
        "id": 1,
        "name": "John Doe",
        "address": "123 Main St"
      }
      ```

### Get Entity
- **Method:** GET
- **URL:** `/entity/get`
- **Query Parameters:**
    - `id` (required): The ID of the entity.
- **Response:**
    - **Status:** 200
    - **Body:**
      ```json
      {
        "id": 1,
        "name": "John Doe",
        "address": "123 Main St"
      }
      ```

### Update Entity
- **Method:** PUT
- **URL:** `/entity/update`
- **Request Body:**
  ```json
  {
    "id": 1,
    "name": "John Smith",
    "address": "456 Elm St"
  }
  ```
- **Response:**
    - **Status:** 200
    - **Body:**
      ```json
      {
        "id": 1,
        "name": "John Smith",
        "address": "456 Elm St"
      }
      ```

### Delete Entity
- **Method:** DELETE
- **URL:** `/entity/delete`
- **Query Parameters:**
    - `id` (required): The ID of the entity.
- **Response:**
    - **Status:** 200
    - **Body:**
      ```json
      {
        "message": "Entity deleted successfully"
      }
      ```

### Get All Entities
- **Method:** GET
- **URL:** `/entity/get-all`
- **Response:**
    - **Status:** 200
    - **Body:**
      ```json
      [
        {
          "id": 1,
          "name": "John Doe",
          "address": "123 Main St"
        },
        {
          "id": 2,
          "name": "Jane Doe",
          "address": "456 Elm St"
        }
      ]
      ```