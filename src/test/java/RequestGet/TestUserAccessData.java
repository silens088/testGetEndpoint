package RequestGet;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestUserAccessData {

    @Test
    void user1() {
        RequestGet request1 = new RequestGet();

        request1.requestGet("globaldb.com/company/100/users?name=Vitalii", "zxcvbnm"); //Пользователь user1: аутентификация выполнена. Данные получены.

        Assert.assertEquals(200, request1.getCode()); 
    }

    @Test
    @Description("test that the user is not allowed to search for data not of his company")
    void user2() {
        RequestGet request2 = new RequestGet();

        request2.requestGet("globaldb.com/company/100/users?name=Vitalii", "mnbvcxz"); //Пользователь user2: аутентификация выполнена, нет доступа к данным. 403 (Forbidden)

        Assert.assertEquals(403, request2.getCode()); 
    }
}
