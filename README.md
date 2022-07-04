Table `rates` is crated via scripts, see more details [here](https://github.com/derjust/spring-data-dynamodb/wiki/Autocreate-Tables)

To query table content:
```
docker run --rm -it -v $PWD/localstack/cli:/root/.aws amazon/aws-cli --endpoint-url=http://host.docker.internal:4566 dynamodb scan --table-name rates
```