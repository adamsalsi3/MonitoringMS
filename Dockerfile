FROM openjdk:17
LABEL authors="p12469f"
COPY ./target/classes/com/example/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "MonitoringMS"]