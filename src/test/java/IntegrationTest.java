import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Test;

import java.util.Collections;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;


public class IntegrationTest {


    @Test
    public void getAssets_shouldReturnAssets() {
        when().get("https://api.kraken.com/0/public/Assets").
                then().statusCode(200).body("error", equalTo(Collections.emptyList()));

        when().get("https://api.kraken.com/0/public/Assets").
                then().statusCode(200).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("assets-schema.json"));
    }
}
