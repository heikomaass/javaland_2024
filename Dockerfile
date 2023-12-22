FROM amazoncorretto:21-alpine-jdk

COPY ./target/performance-objectmapper-app.jar /jar/performance-objectmapper-app.jar
COPY ./java-cmd-run.sh /

RUN chmod +x java-cmd-run.sh

ENTRYPOINT ["/java-cmd-run.sh"]

CMD ["/jar/performance-objectmapper-app.jar"]

