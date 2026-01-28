```sh
docker build -t cloud-compose-spring:latest .
docker tag cloud-compose-spring:latest ghcr.io/NAMESPACE/cloud-compose-spring:latest
```

```sh
export CR_PAT=YOUR_TOKEN
echo $CR_PAT | docker login ghcr.io -u USERNAME --password-stdin
docker push ghcr.io/NAMESPACE/IMAGE_NAME:latest
```