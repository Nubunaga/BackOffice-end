package com.example.demos;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Optional;

import com.example.demos.controller.ControllerUser;
import com.example.demos.model.Users;
import com.example.demos.repository.UserRepository;
import com.example.demos.utils.Config;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@WebMvcTest(controllers = ControllerUser.class)
@AutoConfigureMockMvc
public class ControllerUserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;
    

    @Before
    public void setut(){
        this.mockMvc = standaloneSetup(new DemossApplication()).build();
    }


    @Test
    public void userAddMessageTest() throws Exception{
        ResultMatcher created = MockMvcResultMatchers.status().isCreated();
        ResultMatcher saved = MockMvcResultMatchers.content().string("Saved");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user/add")
        .param("name", "Val")
        .param("email", "val@val.com")
        .param("password","pass");
        this.mockMvc.perform(builder)
        .andExpect(created)
        .andExpect(saved);
    }


    @Test
    public void userAddMessageWrongInputTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user/add")
        .param("name", "Val")
        .param("password","pass");
        this.mockMvc.perform(builder)
        .andExpect(code);
    }

    @Test
    public void userRemoveTest() throws Exception{
        ResultMatcher removed = MockMvcResultMatchers.status().isNoContent();

        Mockito.when(userRepository.existsById("First")).thenReturn(true); //When mockito sees a call is made, cheats and say true!

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/remove")
        .param("id", "First");

        this.mockMvc.perform(builder)
        .andExpect(removed);
    }

    @Test
    public void userRemoveFailTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isNotFound();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/remove")
        .param("id", "This_is_the_Test_1234278");

        this.mockMvc.perform(builder)
        .andExpect(code);
    }

    @Test
    public void findUserTest() throws Exception{
        ResultMatcher isOk = MockMvcResultMatchers.status().isOk();
        Optional<Users> user = Optional.of(new Users());

        Mockito.when(userRepository.findById("First")).thenReturn(user);


        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/user")
        .param("id", "First");

       this.mockMvc.perform(builder)
        .andExpect(isOk);
    }

    @Test
    public void findUserNotFoundTest() throws Exception{
        ResultMatcher isOk = MockMvcResultMatchers.status().isNotFound();


        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/user/user")
        .param("id", "This_is_the_Test_1234278");

       this.mockMvc.perform(builder)
        .andExpect(isOk);
    }

}