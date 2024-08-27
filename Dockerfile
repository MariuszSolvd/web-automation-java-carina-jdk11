FROM openjdk:21

WORKDIR /app

COPY . .

RUN chmod +x mvnw

CMD ["./mvnw", "test"]