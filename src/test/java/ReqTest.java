import org.junit.Test;

public class ReqTest {
    @Test
    public void whenQueueModePostMethod() {
        String ls = System.lineSeparator();
        String content = "POST /queue/weather HTTP/1.1" + ls +
                "Host: localhost:9000" + ls +
                "User-Agent: curl/7.72.0" + ls +
                "Accept: */*" + ls +
                "Content-Length: 14" + ls +
                "Content-Type: application/x-www-form-urlencoded" + ls +
                "" + ls +
                "temperature=18" + ls;
//        Req req = Req.of(content);
//        assertThat(req.httpRequestType(), is("POST"));
//        assertThat(req.getPoohMode(), is("queue"));
//        assertThat(req.getSourceName(), is("weather"));
//        assertThat(req.getParam(), is("temperature=18"));
    }

}
