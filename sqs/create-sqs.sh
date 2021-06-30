#aws --endpoint-url=http://localhost:4576 sqs create-queue --queue-name playground-sqs

# lista as filas
#aws --endpoint-url=http://localhost:4576 sqs list-queues

# envia mensagem para a fila
aws --endpoint-url=http://localhost:4576 sqs send-message --queue-url http://localhost:4576/000000000000/playground-sqs --message-body 'Hello World! 4'

# consume a fila
#aws --endpoint-url=http://localhost:4576 sqs receive-message --queue-url http://localhost:4566/000000000000/playground-sqs