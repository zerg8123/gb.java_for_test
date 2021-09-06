
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Data;
import utils.PropertyScanner;

import java.io.IOException;
@Data
abstract class BaseApiTest {

    private final String token;
    private final String baseUri;
    private final String userName;
    private final String commentId;
    private final String imageHash;
    private final String statusCode;
    private final String headerDataAccUrl;
    private final String headerDataUrl;
    private final String headerAuthName;
    private final String dataAlbumCover;
    private final String statusLine;
    private final String responseTime;
    private final PropertyScanner scanner;
    public ResponseSpecification responseSpecification = null;
    public RequestSpecification requestSpecification = null;

    public BaseApiTest() throws IOException {
        scanner = new PropertyScanner();
        token = scanner.getProperty("imgur.auth.token");
        baseUri = scanner.getProperty("imgur.api.url");
        userName = scanner.getProperty("imgur.username");
        commentId = scanner.getProperty("imgur.commentId");
        imageHash = scanner.getProperty("imgur.imageHash");
        statusCode = scanner.getProperty("status.code");
        headerDataAccUrl = scanner.getProperty("header.query.param.data.account.url");
        headerAuthName = scanner.getProperty("header.auth.name");
        statusLine = scanner.getProperty("status.line");
        responseTime = scanner.getProperty("response.time");
        headerDataUrl = scanner.getProperty("header.query.param.data.url");
        dataAlbumCover = scanner.getProperty("header.data.album.cover");
    }
}