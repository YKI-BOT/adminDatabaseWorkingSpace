# Stage 1: Build React application
FROM node:16 as build

WORKDIR /app

# Copy the frontend package.json and package-lock.json
COPY frontend/package*.json ./

RUN npm install

# Copy the rest of the frontend code
COPY frontend ./

RUN npm run build

# Stage 2: Build Spring Boot application
FROM maven:3.6.3-openjdk-17 AS maven_build

WORKDIR /app

# Copy the Spring Boot application code
COPY . .

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Stage 3: Run the application
FROM openjdk:17-slim

WORKDIR /app

# Copy the built React files to Spring Boot static directory
COPY --from=build /app/build /src/main/resources/static

# Copy the JAR file to the working directory
COPY --from=maven_build /app/target/*.jar app.jar

EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
