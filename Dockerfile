FROM amazoncorretto:21-alpine-jdk

COPY ./certs/nginx-selfsigned.crt /certs/nginx-selfsigned.crt
COPY ./target/performance-objectmapper-app.jar /jar/performance-objectmapper-app.jar
COPY ./java-cmd-run.sh /

RUN keytool -importcert -file /certs/nginx-selfsigned.crt -alias nginx -cacerts -storepass changeit -noprompt
RUN chmod +x java-cmd-run.sh

ENTRYPOINT ["/java-cmd-run.sh"]

CMD ["/jar/performance-objectmapper-app.jar"]

