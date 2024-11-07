FROM alpine:latest

RUN apk add --no-cache openjdk11

WORKDIR /app

COPY HelloWorld.java .

RUN javac HelloWorld.java

CMD ["java", "HelloWorld"]
