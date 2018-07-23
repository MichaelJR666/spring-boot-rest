/**
 * 
 */
package com.stcoder.spring.boot.controller.v1;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.company.spring.boot.Application;
import com.company.spring.boot.controller.v1.StoreOwnerController;

/**
 * @author NevinChen
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@AutoConfigureMockMvc
// The MockMvc comes from Spring Test and allows you, via a set of convenient builder classes, 
// to send HTTP requests into the DispatcherServlet and make assertions about the result. 
// Note the use of the @AutoConfigureMockMvc together with @SpringBootTest to inject a MockMvc instance. 
// Having used @SpringBootTest we are asking for the whole application context to be created. 
// An alternative would be to ask Spring Boot to create only the web layers of the context using the @WebMvcTest. 
// Spring Boot automatically tries to locate the main application class of your application in either case, 
// but you can override it, or narrow it down, if you want to build something different.
public class StoreOwnerControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateStoreOwner() throws Exception {
        RequestBuilder requestBuilder = null;
        String requestBody = "{\"name\":\"Tom\"}";
        requestBuilder = post(StoreOwnerController.STORE_OWNER_PATH + "/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestBody);
        mvc.perform(requestBuilder).andExpect(status().isCreated()).andExpect(content().string(equalTo("")));
    }
    
    @Test
    public void testCreateStoreOwnerWithEmptyRequestBody() throws Exception {
        RequestBuilder requestBuilder = null;
        String requestBody = "";
        requestBuilder = post(StoreOwnerController.STORE_OWNER_PATH + "/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestBody);
        mvc.perform(requestBuilder).andExpect(status().isBadRequest());
    }
    
}
