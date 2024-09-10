# Springboot - Customer Management System

A customer management tool that helps users keep track of customers using micorservices and a simple, easy-to-use frontend.

## Table of Contents
- [About](###About)
- [Springboot](###Springboot)
- [Microservices](###Microservices)
    - [Authentication Service](####Authentication-Service)
    - [Creation Service](####Authentication-Service)
    - [Transaction Service](####Authentication-Service)
- [Frontend](###Frontend)
- [Run The Project](###Run-The-Project)


### About
This project is a customer record management system designed to streamline the tracking and management of customer information. Built using Java Spring Boot, it comprises three distinct microservices that handle various aspects of customer record management, ensuring a modular and scalable architecture.

### Springboot
Spring Boot is an open-source Java framework used for programming standalone, production-grade Spring-based applications with minimal effort.
### Microsevices
A microservice architecture is an architectural pattern that arranges an application as a collection of loosely coupled, fine-grained services. This project makes use of three services as listed below.
- #### Authentication Service
The service runs on port 8000. Handles simple username and password matching to authenticate a user. More secure authentication features will be implemented in the future. Endpoints exposed :
| Method | Endpoint | Description |
| ----------- | ----------- | ----------- |
| ***GET*** | `/api/user/{userId}` | get user details with user ID |
| ***POST*** | `/api/user/login` | authenticates user, takes username and password in the request body |
| ***POST*** | `/api/user` | creates a new user, takes user details in request body |
| ***PUT*** | `/api/user` | updates existing user, takes user details in request body |
| ***DELETE*** | `/api/user/{userId}` | deletes user |

- #### Creation Service
The creation service handles creation and searching of customer records. The service runs on port 8001. Endpoints exposed :
| Method | Endpoint | Description |
| ----------- | ----------- | ----------- |
| ***GET*** | `/api/customers` | gets all customer records |
| ***GET*** | `/api/customers/{customerId}` | gets record with matching ID |
| ***GET*** | `/api/customers/search?query` | gets customer records with matching name |
| ***POST*** | `/api/customers` | save new customer record |

- #### Transaction Service
The transaction service handles the updating the deletion of customer records. The service runs on port 8002. Endpoints exposed :
| Method | Endpoint | Description |
| ----------- | ----------- | ----------- |
| ***PUT*** | `/api/customers` | updates existing customer record, takes updated record as request body |
| ***DELETE*** | `/api/customers/{customerId}` | deletes customer record |


### Frontend
TBD
### Run The Project !
Ensure all services and frontend are running.

