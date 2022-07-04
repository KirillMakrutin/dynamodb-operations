```
docker run --rm -it -v $PWD/localstack/cli:/root/.aws amazon/aws-cli --endpoint-url=http://host.docker.internal:4566 dynamodb scan --table-name rates
```