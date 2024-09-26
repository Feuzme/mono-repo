# MONO REPOSITORY

## Table of content

<!-- TOC -->

* [MONO REPOSITORY](#mono-repository)
    * [Table of content](#table-of-content)
    * [Versions](#versions)
    * [Description](#description)
    * [Pre-requisite](#pre-requisite)
    * [Run project](#run-project)
        * [Local launch](#local-launch)
            * [with IntelliJ](#with-intellij)
        * [Deploy using docker](#deploy-using-docker)

<!-- TOC -->

## Versions

* Java 21
* Spring 3.3.3
* Mongo 8.0.0

## Description

This repository should demonstrate how to set up and use a mono repository spring project

## Pre-requisite

* [Docker](https://docs.docker.com/engine/install/)

## Run project

### Local launch

#### with IntelliJ

1. Run External dependencies from the docker file

    ```shell
    docker compose up -d broker mongo
    ```
2. Install dependencies and install project
   ```shell
    mvn clean install
    ```

2. Set up environment variables :
    * **COMPONENT** to set up the desired component to launch
        * `COMPONENT=home-api` to launch the api component
        * `COMPONENT=home-listener` to launch the kafka listener component
    * **BROKER_URL** to modify the kafka broker URL (default `localhost:9092`)
    * **MONGO_HOST** to modify the mongodb URL (default `localhost`)
3. Run the application, you can check if the application is up by running :
    ```shell
    curl -X GET --location "http://127.0.0.1:8080/actuator/health" 
    ```
   Response should be :
   ```json
    {
      "status": "UP"
    }
   ```

### Deploy using docker

1. Run command :
    ```shell
    docker compose up -d
    ```
2. You can check if the application is up by running :
    ```shell
    curl -X GET --location "http://127.0.0.1:8080/actuator/health" 
    ```
   Response should be :
   ```json
    {
      "status": "UP"
    }
   ```
