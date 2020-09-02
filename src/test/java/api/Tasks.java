package test.java.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Tasks {
    long newId;

    @Test
    public void get() {
        Response response = given().
                header("Authorization", "Bearer a5357e4113acd8a6f9593942b4dec32b804bf998").
                when().
                get("https://api.todoist.com/rest/v1/tasks");
        JsonPath path = response.jsonPath();
        List<Map> list = path.getList("");
        List<String> actualNames = new ArrayList<>();
        for (Map task : list) {
            actualNames.add((String) task.get("content"));
        }
        response.
                then().
                statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("getBodyValidation.json"));
        ;
        assertEquals(actualNames.get(0), "Anatomy");
        actualNames.remove(0);
        for (String name : actualNames)
            assertFalse(name.equals("Anatomy"), String.format("Expected name '%s' not to be Anatomy", name));
    }

    @Test
    public void create() {
        newId = given().
                header("Authorization", "Bearer a5357e4113acd8a6f9593942b4dec32b804bf998").
                contentType(ContentType.JSON).
                body(new File("createProjectBody.json")).
                when().
                post("https://api.todoist.com/rest/v1/tasks").
                then().
                statusCode(200).
                extract().
                path("id");
    }

    @Test(dependsOnMethods = "create")
    public void delete() {

        given().
                header("Authorization", "Bearer a5357e4113acd8a6f9593942b4dec32b804bf998").
                when().
                delete("https://api.todoist.com/rest/v1/tasks/" + newId).
                then().
                statusCode(204);
    }

    @Test
    public void update() {
        given().header("Authorization", "Bearer a5357e4113acd8a6f9593942b4dec32b804bf998").
                contentType(ContentType.JSON).
                body(new File("updateProjectBody.json")).
                when().
                post("https://api.todoist.com/rest/v1/tasks/3965519332").
                then().statusCode(204);


    }

    @Test(dependsOnMethods = "update")
    public void updateRollBack() {
        given().header("Authorization", "Bearer a5357e4113acd8a6f9593942b4dec32b804bf998").
                contentType(ContentType.JSON).
                body(new File("updateRollBackProjectBody.json")).
                when().
                post("https://api.todoist.com/rest/v1/tasks/3965519332").
                then().statusCode(204);

    }

}
