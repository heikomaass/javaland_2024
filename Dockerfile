FROM amazoncorretto:21-alpine-jdk

COPY ./java-cmd-run.sh /
COPY ./certs/nginx-selfsigned.crt /certs/nginx-selfsigned.crt
COPY ./target/performance-objectmapper-app.jar /jar/performance-objectmapper-app.jar

RUN keytool -importcert -file /certs/nginx-selfsigned.crt -alias verbindung-service -cacerts -storepass changeit -noprompt && \
    chmod +x java-cmd-run.sh

ENTRYPOINT ["/java-cmd-run.sh"]

CMD ["/jar/performance-objectmapper-app.jar"]

