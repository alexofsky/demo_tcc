echo '---------start begin------'

DIR=/home/hgang
cd $DIR
ps -ef | grep cpm-basic-management.jar  | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep cpm-api-gateway.jar | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep cpm-sleuth-server.jar | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep cpm-service-governance.jar | grep -v grep | awk '{print $2}' | xargs kill -9
ps -ef | grep cpm-basic-erp-service.jar | grep -v grep | awk '{print $2}' | xargs kill -9

ps -ef | grep erp-basic-service.jar | grep -v grep | awk '{print $2}' | xargs kill -9


sleep 3
java  -Dspring.profiles.active=dev -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/cpm-service-governance/application/ -Dserver.undertow.accesslog.dir=./logs/cpm-logs/cpm-service-governance/access/   -jar cpm-service-governance.jar &
sleep 30
java  -Dspring.profiles.active=dev -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/cpm-sleuth-server/application/   -jar cpm-sleuth-server.jar &
java  -Dspring.profiles.active=dev -Dserver.port=8081 -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/cpm-api-gateway/application/   -jar cpm-api-gateway.jar &
java  -Dspring.profiles.active=dev -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/cpm-basic-management/application/   -jar cpm-basic-management.jar &
java  -Dspring.profiles.active=dev -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/cpm-basic-erp-service/application/   -jar cpm-basic-erp-service.jar &

java  -Dlogging.config=/home/hgang/microservice/cpm-logback-config.xml -Dlogging.dir=./logs/cpm-logs/erp-basic-service/application/   -jar erp-basic-service.jar &
echo '---------start end------'