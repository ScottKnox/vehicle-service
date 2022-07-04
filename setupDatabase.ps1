Write-Host "Populating DynamoDB"

aws dynamodb create-table --table-name Vehicle --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:8000

aws dynamodb put-item --table-name Vehicle --item file://vehicle1.json --endpoint=http://localhost:8000

aws dynamodb put-item --table-name Vehicle --item file://vehicle2.json --endpoint=http://localhost:8000