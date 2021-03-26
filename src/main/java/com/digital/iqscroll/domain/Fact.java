package com.digital.iqscroll.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Fact")
public class Fact {
    private String id;
    private String imageUrl;
    private String bodyText;

    public Fact() {
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return this.id;
    }

    @DynamoDBAttribute
    public String getImageUrl() {
        return this.imageUrl;
    }

    @DynamoDBAttribute
    public String getBodyText() {
        return this.bodyText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
}
