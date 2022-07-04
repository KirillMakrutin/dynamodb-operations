#!/bin/sh

echo ">>> initializing dynamodb"

awslocal dynamodb create-table \
  --table-name rates \
  --attribute-definitions \
  AttributeName=id,AttributeType=S AttributeName=rateCode,AttributeType=S\
  --key-schema AttributeName=id,KeyType=HASH \
  --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=10 \
  --global-secondary-indexes \
          "[
              {
                  \"IndexName\": \"idx_global_rateCode\",
                  \"KeySchema\": [
                      {\"AttributeName\":\"rateCode\",\"KeyType\":\"HASH\"}
                  ],
                  \"Projection\": {
                      \"ProjectionType\":\"ALL\"
                  },
                  \"ProvisionedThroughput\": {
                      \"ReadCapacityUnits\": 10,
                      \"WriteCapacityUnits\": 10
                  }
              }
          ]"