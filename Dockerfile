FROM tomcat:8.5.90-jre8
COPY target/my-servlet-app.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]