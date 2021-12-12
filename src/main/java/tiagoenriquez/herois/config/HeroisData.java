package tiagoenriquez.herois.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static tiagoenriquez.herois.constants.HeroisConstant.ENDPOINT_DYNAMO;
import static tiagoenriquez.herois.constants.HeroisConstant.REGION_DYNAMO;

public class HeroisData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Herois_Api_Table");

        Item heroi = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Homem de Ferro")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        Item heroi2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Thor")
                .withString("universe", "marvel")
                .withNumber("films", 4);

        Item heroi3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Capitão América")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome1 = table.putItem(heroi);
        PutItemOutcome outcome2 = table.putItem(heroi2);
        PutItemOutcome outcome3 = table.putItem(heroi3);

    }

}
