./mvnw package -Pnative -Dquarkus.native.container-build=true \
-Dquarkus.container-image.build=true \
-Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:21.3.3.0-Final-java11 \
-Dquarkus.container-image.name=papler-ops \
-Dquarkus.container-image.tag=0.0.2

docker tag admin/papler-ops:0.0.2 core.harbor.domain/library/papler-ops:0.0.2
docker push core.harbor.domain/library/papler-ops:0.0.2

curl -X POST -H 'content-type: application/json' --url http://velaux.example.com/api/v1/webhook/32xhc2mooxqxutxf -d '{"upgrade":{"papler-ops":{"image":"core.harbor.domain/library/papler-ops:0.0.2"}},"codeInfo":{"commit":"","branch":"","user":""}}'