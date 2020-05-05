package RequestGet;

import org.junit.Assert;

public class Main {
    public static void main(String[] args) {

        RequestGet request1 = new RequestGet();
        RequestGet request2 = new RequestGet();

        request1.requestGet("globaldb.com/company/100/users?name=Vitalii", "zxcvbnm");
        request2.requestGet("globaldb.com/company/100/users?name=Vitalii", "mnbvcxz");

        Assert.assertEquals(200, request1.getCode());
        Assert.assertEquals(403, request2.getCode());

    }
}
