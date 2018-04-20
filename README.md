SpringChain
============

<p align="center">
  <img src="https://raw.githubusercontent.com/karadalex/SpringChain/master/spring-chain-logo.png"/>
</p>

[![Build Status](https://travis-ci.org/karadalex/SpringChain.svg?branch=master)](https://travis-ci.org/karadalex/SpringChain)
[![codecov](https://codecov.io/gh/karadalex/SpringChain/branch/master/graph/badge.svg)](https://codecov.io/gh/karadalex/SpringChain)
[![Maintainability](https://api.codeclimate.com/v1/badges/5cad4f25dafea4ed1168/maintainability)](https://codeclimate.com/github/karadalex/SpringChain/maintainability)


Simple custom Blockchain with REST API using Spring Boot

## Run locally with Maven

Run `./mvnw`

## Run with Docker

Run one instance with docker
**Coming Soon**

## Run with docker-compose

Run multiple instances to test blockchain peer-to-peer functionality
and consensus 
**Coming Soon**

## Code quality locally

Check code quality locally with sonarqube
1. Start sonarqube with docker-compose
```
docker-compose -f sonar.yml up
```
2. Login to sonarqube with username: admin and password: admin and follow the guide for java
3. Run the following command inside your project root directory
```
./mvnn sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login={login-generated-from-sonar}
```  
