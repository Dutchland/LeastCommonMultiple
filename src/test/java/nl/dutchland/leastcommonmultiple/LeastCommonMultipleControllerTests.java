package nl.dutchland.leastcommonmultiple;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LeastCommonMultipleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void leastCommonMultiple_1to10() throws Exception{
        this.mockMvc
                .perform(get("/leastcommonmultiple/from/{from}/until/{until}", 1, 10))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(2520));
    }

    @Test
    public void leastCommonMultiple_1to25() throws Exception{
        this.mockMvc
                .perform(get("/leastcommonmultiple/from/{from}/until/{until}", 1, 25))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(26771144400L));
    }

    @Test
    public void invalidRange_negativeRange_returnsBadRequest() throws Exception{
        this.mockMvc
                .perform(get("/leastcommonmultiple/from/{from}/until/{until}", -1, 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Start of the range has to be bigger than zero"));
    }

    @Test
    public void invalidRange_endSmallerThanStart_returnsBadRequest() throws Exception{
        this.mockMvc
                .perform(get("/leastcommonmultiple/from/{from}/until/{until}", 10, 9))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("End of the range has to be bigger than the start"));
    }
}
